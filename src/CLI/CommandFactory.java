package CLI;

import CLI.Commands.*;
import svg.core.SvgManager;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class CommandFactory {
    private final Map<String, CommandBuilder> commandMap = new HashMap<>();
    private String currentFile = null;

    public void register(String commandName, CommandBuilder builder) {
        commandMap.put(commandName.toLowerCase(), builder);
    }

    public Command createCommand(String inputLine) {
        String[] parts = inputLine.trim().split("\\s+", 2);
        String commandName = parts[0].toLowerCase();
        String[] args = parts.length > 1 ? parts[1].split("\\s+") : new String[0];

        CommandBuilder builder = commandMap.get(commandName);
        if (builder != null) {
            return builder.build(args);
        }
        System.out.println("Unknown command: " + commandName);
        return null;
    }

    public CommandFactory() {
        register("create", args -> new CreateCommand(args));
        register("print", args -> new PrintCommand());
        register("erase", args -> {
            if(args.length != 1) {
                System.out.println("Usage: erase [number/index]");
                return null;
            }
            try{
                int index = Integer.parseInt(args[0]);
                return new EraseCommand(index);
            }catch(NumberFormatException e){
                System.out.println("Invalid number format" + e);
                return null;
            }
        });
        register("open", args -> {
            if (args.length != 1) {
                System.out.println("Usages: open[filename]");
                return null;
            }
            return new OpenCommand(args[0]);
        });
        register("translate",args ->{
            Integer idx = null;
            int dx = 0, dy = 0;
            int argOffset = 0;
           if(args.length > 0){
               try{
                    idx = Integer.parseInt(args[0]);
                    argOffset = 1;
               }catch(NumberFormatException ignored){}
           }
           for(int i = argOffset; i < args.length;i++){
               if(args[i].startsWith("vertical=")){
                   dy = Integer.parseInt(args[i].substring("vertical=".length()));
               }else if(args[i].startsWith("horizontal=")) {
                   dx = Integer.parseInt(args[i].substring("horizontal=".length()));
               }
           }
            return new TranslateCommand(idx,dx,dy);
        });

        register("close", args -> new CloseCommand());

        register("save", args -> new SaveCommand());

        register("saveas", args -> {
            if (args.length != 1) {
                System.out.println("Usage: saveas[filename]");
                return null;
            }
            currentFile = args[0];
            return new SaveAsCommand(currentFile);
        });

        register("help", args -> new HelpCommand());
        register("exit", args -> new ExitCommand());
    }

}
