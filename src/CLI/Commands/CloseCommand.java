package CLI.Commands;

import CLI.Command;

public class CloseCommand implements Command {


    @Override
    public void execute() {
        System.out.println("Succesfully closed");
    }
}
