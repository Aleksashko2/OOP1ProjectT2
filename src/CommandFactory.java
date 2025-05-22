import java.util.HashMap;
import java.util.Map;


public class CommandFactory {
    private final Map<String, CommandBuilder> commandMap = new HashMap<>();
    private String currentFile = null;

    public CommandFactory() {
        register("open", args -> {
            if (args.length != 1) {
                System.out.println("Usages: open[filename]");
                return null;
            }
            currentFile = args[0];
            return new OpenCommand(currentFile);
        });

        register("close", args -> new CloseCommand());

        register("save", args -> {
            if (currentFile == null) {
                System.out.println("No file is currently open.");
                return null;
            }
            return new SaveCommand(currentFile);
        });

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
}
