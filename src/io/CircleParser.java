package io;

import Shapes.Circle;
import Shapes.Shape;
import org.w3c.dom.Element;

public class CircleParser implements ShapeParser{
    @Override
    public Shape parse(Element el) {
        int cx = Integer.parseInt(el.getAttribute("cx"));
        int cy = Integer.parseInt(el.getAttribute("cy"));
        int r = Integer.parseInt(el.getAttribute("r"));
        String fill = el.getAttribute("fill");

        return new Circle(cx, cy, r, fill);
    }
}
