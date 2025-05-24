package Shapes;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Rectangle implements Shape{
    private int x,y, width, height;
    private String fill;

    public Rectangle(int x, int y, int width, int height, String fill) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.fill = fill;
    }

    @Override
    public Element toSvgElement(Document doc) {
        Element rect = doc.createElement("rect");
        rect.setAttribute("x", String.valueOf(x));
        rect.setAttribute("y", String.valueOf(y));
        rect.setAttribute("width", String.valueOf(width));
        rect.setAttribute("height", String.valueOf(height));
        rect.setAttribute("fill",fill);

        return rect;
    }

    @Override
    public String toSVG() {
        return String.format("<rect x=\"%d\" y=\"%d\" width=\"%d\" height=\"%d\" fill=\"%s\"",
                x, y, width, height, fill);
    }

    @Override
    public String toText() {
        return String.format("rectangle %d %d %d %d %s",
                x, y, width, height, fill);
    }

    @Override
    public boolean isWithin(Shape region) {
        return false;
    }

    @Override
    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public String getType() {
        return "Rectangle";
    }
}
