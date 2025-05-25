package CLI.Commands;

import svg.core.SvgManager;

public class TranslateCommand implements Command{
    private final Integer index;
    private final int dx;
    private final int dy;

    public TranslateCommand(Integer index, int dx, int dy) {
        this.index = index;
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public void execute() {
        SvgManager manager = SvgManager.getInstance();
        if (!manager.hasOpenFile()){
            System.out.println("No file is currently open.");
            return;
        }
        if (index == null){
            for(int i = 1; i<= manager.getShapes().size(); i++){
                manager.translateOne(i, dx, dy);
            }
            System.out.println("Translated all figures");
        }else{
            if (manager.translateOne(index, dx, dy)){
                System.out.printf("Translated figures (%d)%n", index);
            } else {
                System.out.printf("No suck figures: %d%n", index);
            }
        }
    }
}
