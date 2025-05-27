package CLI.Commands;

import Shapes.*;
import svg.core.SvgManager;

public class CreateCommand implements Command{
    private final String[] args;

    public CreateCommand(String[] args) {
        this.args = args;
    }

    @Override
    public void execute() {
        if(args.length < 1){
            System.out.println("Usage: create[rectangle, circle, line]...");
            return;
        }
        String type = args[0].toLowerCase();
        Shape shape = null;

        try{
            switch(type) {
                case "rectangle":{
                    if(args.length != 6){
                        System.out.println("Usage: Create rectangle x y width, height, fill");
                        return;
                    }
                    int x = Integer.parseInt(args[1]);
                    int y = Integer.parseInt(args[2]);
                    int width = Integer.parseInt(args[3]);
                    int height = Integer.parseInt(args[4]);
                    String fill = args[5];
                    shape = new Rectangle(x, y, width, height, fill);
                    break;
                }
                case "circle":{
                    if(args.length != 5){
                        System.out.println("Usage: Create circle cx, cy, r, fill");
                        return;
                    }
                    int cx = Integer.parseInt(args[1]);
                    int cy = Integer.parseInt(args[2]);
                    int r = Integer.parseInt(args[3]);
                    String fill = args[4];
                    shape = new Circle(cx, cy, r, fill);
                    break;
                }
                case "line":{
                    if(args.length != 6){
                        System.out.println("Usage: Create line x1, y1, x2, y2, stroke");
                        return;
                    }
                    int x1 = Integer.parseInt(args[1]);
                    int y1 = Integer.parseInt(args[2]);
                    int x2 = Integer.parseInt(args[3]);
                    int y2 = Integer.parseInt(args[4]);
                    String stroke = args[5];
                    shape = new Line(x1, y1, x2, y2, stroke);
                    break;
                }
                default:
                    System.out.println("Invalid shape:"+ type);
            }
        }catch(NumberFormatException e){
            System.out.println("Invalid number format" + e.getMessage());
        }
        SvgManager.getInstance().getShapes().add(shape);
        System.out.printf("Succesfully created %s, (%d)%n", type, SvgManager.getInstance().getShapes().size());
    }
}
