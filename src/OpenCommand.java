import com.sun.net.httpserver.Authenticator;

import java.io.File;

public class OpenCommand implements Command {
    private final String filename;

    public OpenCommand(String filename) {
        this.filename = filename;
    }

    @Override
    public void execute() {
        File file = new File(filename);
        if (file.exists()) {
            System.out.println("Successfully opened " + filename);
        } else {
            System.out.println("File not found:" + filename);
        }
    }
}
