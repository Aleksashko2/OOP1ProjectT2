package CLI.Commands;

import CLI.Command;

import svg.core.SvgManager;
import io.SvgWriter;

public class SaveCommand implements Command {
    private final String filename;

    public SaveCommand(String filename) {
        this.filename = filename;
    }

    @Override
    public void execute() {
        if(!SvgManager.getInstance().hasOpenFile()){
            
        }
    }
}
