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
            writer.write("<svg><!-- content --></svg>");
            System.out.println("Succesfully saved" + new File(filename).getName());
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}
