package CLI.Commands;

import CLI.Command;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Exiting program...");
        System.exit(0);
    }
}
