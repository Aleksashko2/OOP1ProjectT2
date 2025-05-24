package CLI.Commands;

import CLI.Command;

public class HelpCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Available options");
        System.out.println(" open [filename]");
        System.out.println(" close");
        System.out.println(" save");
        System.out.println(" saveas [filename]");
        System.out.println(" help");
        System.out.println(" exit");
    }
}
