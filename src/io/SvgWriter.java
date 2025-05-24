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

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));

            transformer.transform(source, result);

            System.out.println("Succesfully saved " + new File(filePath));


        } catch (Exception e) {
            System.out.println("Error while saving SVG:" + e.getMessage());
        }
    }
}