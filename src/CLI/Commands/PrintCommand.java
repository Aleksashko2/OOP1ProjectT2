package CLI.Commands;

import svg.core.SvgManager;

public class PrintCommand implements Command{
    @Override
    public void execute() {
        if(!SvgManager.getInstance().hasOpenFile()){
            System.out.println("No file is currently open");
            return;
        }
        SvgManager.getInstance().printShapes();
    }
}
