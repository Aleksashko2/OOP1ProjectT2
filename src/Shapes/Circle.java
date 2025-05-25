package Shapes;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Circle implements Shape{
    private int cx,cy,r;
    private String fill;

    public Circle(int cx, int cy, int r, String fill) {
        this.cx = cx;
        this.cy = cy;
        this.r = r;
        this.fill = fill;
    }

    @Override
    public Element toSvgElement(Document doc) {
        Element circle = doc.createElement("circle");
        circle.setAttribute("cx", String.valueOf(cx));
        circle.setAttribute("cy", String.valueOf(cy));
        circle.setAttribute("r", String.valueOf(r));
        circle.setAttribute("fill", fill);
        return circle;
    }

    @Override
    public String toSVG() {
        return String.format("<circle cx=\"%d\"> cy=\"%d\"> r=\"%d\"> fill=\"%s\"/>",
                cx, cy, r, fill);
    }

    @Override
    public String toText() {
        return String.format("circle %d %d %d %s",cx, cy, r ,fill);
    }

    @Override
    public boolean isWithin(Shape region) {
        return false;//за после
    }

    @Override
    public void translate(int dx, int dy) {
    this.cx += dx;
    this.cy += dy;
    }

    @Override
    public String getType() {
        return "ircle";
    }
}
