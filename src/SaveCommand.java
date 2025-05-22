import java.io.File;

public class SaveCommand implements Command {
    private final String filename;

    public SaveCommand(String filename) {
        this.filename = filename;
    }

    @Override
    public void execute() {
        File file = new File(filename);
        if (file.exists()) {
            System.out.println("Successfully saved " + filename);
        } else {
            System.out.println("Cannot save: " + filename + ", becaue file does not exist.");
        }
    }
}
