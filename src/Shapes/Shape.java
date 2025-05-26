package Shapes;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public interface Shape {
    Element toSvgElement(Document doc);
    String toText();
    boolean isWithin(Shape region);
    void translate(int dx, int dy);
}
