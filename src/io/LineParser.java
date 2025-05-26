package io;

import Shapes.Line;
import Shapes.Shape;
import org.w3c.dom.Element;

public class LineParser implements ShapeParser {
    @Override
    public Shape parse(Element el) {
        int x1 = Integer.parseInt(el.getAttribute("x1"));
        int y1 = Integer.parseInt(el.getAttribute("y1"));
        int x2 = Integer.parseInt(el.getAttribute("x2"));
        int y2 = Integer.parseInt(el.getAttribute("y2"));
        String stroke = el.getAttribute("stroke");
        return new Line(x1, y1, x2, y2, stroke);
    }
}
