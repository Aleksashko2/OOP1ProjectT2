package CLI.Commands;

public class CloseCommand implements Command {


    @Override
    public void execute() {
        svg.core.SvgManager.getInstance().clear();
        System.out.println("Succesfully closed");
    }
}
