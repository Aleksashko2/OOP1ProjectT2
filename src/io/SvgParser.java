package io;

import Shapes.*;
import org.w3c.dom.*;

import javax.xml.parsers.*;
import java.io.File;
import java.util.*;

public class SvgParser {

    private static final Map<String, ShapeParser> parsers = new HashMap<>();

    static {
        parsers.put("rect", new RectangleParser());
        parsers.put("circle", new CircleParser());
        parsers.put("line", new LineParser());
    }

    public static List<Shape> parse(String filePath) {
        List<Shape> shapes = new ArrayList<>();

        try {
            File file = new File(filePath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);

            NodeList nodeList = doc.getDocumentElement().getChildNodes();

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() != Node.ELEMENT_NODE) continue;

                Element element = (Element) node;
                String tag = element.getTagName();

                ShapeParser parser = parsers.get(tag);
                if (parser != null) {
                    Shape shape = parser.parse(element);
                    shapes.add(shape);
                }
            }


        } catch (Exception e) {
            System.out.println("Error while parsing SVG:" + e.getMessage());
        }
        return shapes;
    }

}
