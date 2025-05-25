package CLI.Commands;

public class HelpCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Available options");
        System.out.println(" open [filename]");
        System.out.println(" close");
        System.out.println(" create [rectangle, circle, line]");
        System.out.println(" erase <n>");
        System.out.println(" translate [<n>] vertical= horizontal =");
        System.out.println(" print (Prints the figures in the open file)");
        System.out.println(" save");
        System.out.println(" saveas [filename]");
        System.out.println(" help");
        System.out.println(" exit");
    }
}
