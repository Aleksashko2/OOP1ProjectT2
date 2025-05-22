import java.util.Scanner;

public class SvgCLI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommandFactory factory = new CommandFactory();

        System.out.println("SVG CLI started. type 'help' for commands.");

        while (true) {
            System.out.println("> ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) continue;

            Command command = factory.createCommand(input);
            if (command != null) {
                command.execute();
            }
        }
    }
}
