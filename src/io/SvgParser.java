package io;

import Shapes.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
import java.util.*;
public class SvgParser {

    private static final Map<String, ShapeParser> parsers = new HashMap<>();
    static {
        parsers.put("rect", SvgParser::parseRectangle);
        parsers.put("circle", SvgParser::parseCircle);
        parsers.put("line", SvgParser::parseLine);
    }

    public static List<Shape> parse(String filePath){
        List<Shape>shapes = new ArrayList<>();
        try{
            File file = new File(filePath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);

            NodeList nodeList = doc.getDocumentElement().getChildNodes();

            for(int i = 0; i < nodeList.getLength(); i++){
                Node node = nodeList.item(i);
                if (node.getNodeType() != Node.ELEMENT_NODE) continue;

                Element element = (Element) node;
                String tag = element.getTagName();

                ShapeParser parser = parsers.get(tag);
                if(parser != null){
                    Shape shape = parser.parse(element);
                    shapes.add(shape);
                }
            }


        } catch (Exception e) {
            System.out.println("Error while parsing SVG:" + e.getMessage());
        }
        return shapes;
    }

    private static Shape parseRectangle(Element el){
        int x = Integer.parseInt(el.getAttribute("x"));
        int y = Integer.parseInt(el.getAttribute("y"));
        int width = Integer.parseInt(el.getAttribute("width"));
        int height = Integer.parseInt(el.getAttribute("height"));
        String fill = el.getAttribute("fill");

        return new Rectangle(x, y, width, height, fill);
    }

    private static Shape parseCircle(Element el){
        int cx = Integer.parseInt(el.getAttribute("cx"));
        int cy = Integer.parseInt(el.getAttribute("cy"));
        int r = Integer.parseInt(el.getAttribute("r"));;
        String fill = el.getAttribute("fill");

        return new Circle(cx,cy,r,fill);
    }

    private static Line parseLine(Element el){
        int x1 = Integer.parseInt(el.getAttribute("x1"));
        int y1 = Integer.parseInt(el.getAttribute("y1"));;
        int x2 = Integer.parseInt(el.getAttribute("x2"));;
        int y2 = Integer.parseInt(el.getAttribute("y2"));;
        String stroke = el.getAttribute("stroke");

        return new Line(x1, y1, x2, y2, stroke);
    }
}
