package CLI.Commands;

import io.SvgWriter;
import svg.core.SvgManager;

public class SaveCommand implements Command {

    public void execute() {
        SvgManager manager = SvgManager.getInstance();
        String filePath = manager.getFilePath();
        if (filePath == null || filePath.isEmpty()) {
            System.out.println("No file is currently open.");
            return;
        }
        SvgWriter.write(filePath, manager.getShapes());
        System.out.println("Successfully saved " + filePath);
    }
}
