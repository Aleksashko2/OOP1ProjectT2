package CLI;

import CLI.Commands.Command;

public interface CommandBuilder {
    Command build(String[] args);
}
