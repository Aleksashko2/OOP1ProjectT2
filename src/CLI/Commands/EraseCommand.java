package CLI.Commands;

import svg.core.SvgManager;

public class EraseCommand implements Command {
    private final int index;

    public EraseCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute() {
        if(!SvgManager.getInstance().hasOpenFile()){
            System.out.println("No file is currently open.");
            return;
        }
        boolean result = SvgManager.getInstance().erase(index);
        if(result){
            System.out.printf("Erase figure (%d)%n", index);
        } else {
            System.out.printf("No figure with that number (%d)%n", index);
        }
    }
}
