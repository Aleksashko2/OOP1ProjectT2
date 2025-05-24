package io;

import org.w3c.dom.Element;
import Shapes.Shape;

public interface ShapeParser {
    Shape parse(Element element);
}
