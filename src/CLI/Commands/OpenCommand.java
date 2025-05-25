package CLI.Commands;

import Shapes.Shape;
import io.SvgParser;
import svg.core.SvgManager;

import java.io.File;
import java.util.List;

public class OpenCommand implements Command {
    private final String filename;

    public OpenCommand(String filename) {
        this.filename = filename;
    }

    @Override
    public void execute() {
        try {
            //System.out.println("DEBUG: filename == null? " + (filename == null));
            //System.out.println("DEBUG: filename string: '" + filename + "'");
            File file = new File(filename);
            //System.out.println("DEBUG: filename = " + filename);
            //System.out.println("DEBUG: file exists = " + file.exists());
            if (!file.exists()) {
                System.out.println("File does not exist: " + filename);
                return;
            }
            List<Shape> shapes = SvgParser.parse(filename);
            //System.out.println("DEBUG: shapes = " + shapes);
            SvgManager.getInstance().load(shapes, filename);
            //System.out.println("Successfully opened " + filename);
        } catch (NullPointerException n) {
            n.printStackTrace();
            System.out.println("NullPointer: " + n);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("General Exception: " + e);
        }
    }
}
