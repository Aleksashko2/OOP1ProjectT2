package CLI.Commands;

import io.SvgWriter;
import svg.core.SvgManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveAsCommand implements Command {
    private final String filename;

    public SaveAsCommand(String filename) {
        this.filename = filename;
    }

    @Override
    public void execute() {
        try (FileWriter writer = new FileWriter(filename)) {
            SvgManager svgManager = SvgManager.getInstance();
            SvgWriter.write(filename, SvgManager.getInstance().getShapes());
            SvgManager.getInstance().load(SvgManager.getInstance().getShapes(), filename);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}
