package io;

import Shapes.Shape;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

import java.io.File;
import java.util.List;

public class SvgWriter {

    public static void write(String filePath, List<Shape> shapes){
        try{
            // Създава нов XML Документ
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            // Добясяме <svg> елемент
            Element svgElement = doc.createElement("svg");
            doc.appendChild(svgElement);

            // Добавяме всички вигури(shape елементи)
            for(Shape shape : shapes){
                Element shapeElement = shape.toSvgElement(doc);
                svgElement.appendChild(shapeElement);
            }
            // Записваме във файл
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();


            // Форамтира xml файла
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");

            //Тъй като презаписваме целият файл и тези конкретни редове се изтриват всеки път се налага да ги връщаме всеки път
            transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC,"-//W3C//DTD SVG 1.1//EN");
            transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));

            transformer.transform(source, result);

            System.out.println("Succesfully saved " + new File(filePath));


        } catch (Exception e) {
            System.out.println("Error while saving SVG:" + e.getMessage());
        }
    }
}