package io;

import Shapes.Rectangle;
import Shapes.Shape;
import org.w3c.dom.Element;

public class RectangleParser implements ShapeParser{
    @Override
    public Shape parse(Element el) {
        int x = Integer.parseInt(el.getAttribute("x"));
        int y = Integer.parseInt(el.getAttribute("y"));
        int width = Integer.parseInt(el.getAttribute("width"));
        int height = Integer.parseInt(el.getAttribute("height"));
        String fill = el.getAttribute("fill");
        return new Rectangle(x, y, width, height, fill);
    }
}
