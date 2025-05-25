package Shapes;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Line implements Shape{

    private int x1, y1, x2, y2;
    private String stroke;

    public Line(int x1, int y1, int x2, int y2, String stroke) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.stroke = stroke;
    }

    @Override
    public Element toSvgElement(Document doc) {
        Element line = doc.createElement("line");
        line.setAttribute("x1",String.valueOf(x1));
        line.setAttribute("y1",String.valueOf(y1));
        line.setAttribute("x2",String.valueOf(x2));
        line.setAttribute("y2",String.valueOf(y2));
        line.setAttribute("stroke",stroke);
        return line;
    }

    @Override
    public String toSVG() {
        return String.format("<line x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\" stroke=\"%s\"/>",x1,y1,x2,y2,stroke);
    }

    @Override
    public String toText() {
        return String.format("line %d %d %d %d %s", x1, y1, x2, y2, stroke);
    }

    @Override
    public boolean isWithin(Shape region) {
        return false;
    }

    @Override
    public void translate(int dx, int dy) {
        this.x1 +=dx;
        this.y1 +=dy;
        this.x2 +=dx;
        this.y2 +=dy;
    }

    @Override
    public String getType() {
        return "line";
    }
}
