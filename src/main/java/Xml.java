import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;
import java.util.*;

public class Xml extends MainGui
{
    public static void createChildElement(Document document, Element parent, String tagName, String text)
    {
        Element element = document.createElement(tagName);
        element.setTextContent(text);
        parent.appendChild(element);
    }
    public static void saveMedToXml(ArrayList<Med> meds, String filepath)
    {
        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element rootElement = document.createElement("Medicine");
            document.appendChild(rootElement);

            for (Med med : meds)
            {
                Element medElement = document.createElement("Med");
                rootElement.appendChild(medElement);
                createChildElement(document, medElement, "name", med.getName());
                createChildElement(document, medElement, "des", med.getDes());
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new FileOutputStream(filepath));

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int[] getdata()
    {
        {
            int[] Settings = new int[4];
            try {
                DocumentBuilderFactory documentBuilderFactory
                        = DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                Document document = documentBuilder.parse("Settings.xml");

                Element rootElement = document.getDocumentElement();

                NodeList childNodeList = rootElement.getChildNodes();
                Node node;
                for (int i = 0; i < childNodeList.getLength(); i++) {
                    node = childNodeList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        NodeList childNodesOfSettingsTag = node.getChildNodes();
                        int width = 0, height = 0,widthl = 0, heightl = 0,widthd=0,heightd=0;
                        String bgimage;
                        for (int j = 0; j < childNodesOfSettingsTag.getLength(); j++) {
                            Node childNodeOfSettingsTag = childNodesOfSettingsTag.item(j);
                            if (childNodeOfSettingsTag.getNodeType() == Node.ELEMENT_NODE) {
                                switch (childNodeOfSettingsTag.getNodeName()) {
                                    case "width" -> width = Integer.parseInt(childNodeOfSettingsTag.getTextContent());
                                    case "height" -> height = Integer.parseInt(childNodeOfSettingsTag.getTextContent());
                                    case "widthl" -> widthl = Integer.parseInt(childNodeOfSettingsTag.getTextContent());
                                    case "heightl" -> heightl = Integer.parseInt(childNodeOfSettingsTag.getTextContent());
                                    case "widthd" -> widthd = Integer.parseInt(childNodeOfSettingsTag.getTextContent());
                                    case "heightd" -> heightd = Integer.parseInt(childNodeOfSettingsTag.getTextContent());
                                }
                            }
                        }
                        Settings[0] = width;
                        Settings[1] = height;
                        Settings[2] = widthd;
                        Settings[3] = heightd;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return Settings;
        }
    }
    public String getbgimage()
    {
        String bgimage="";
        try {
            DocumentBuilderFactory documentBuilderFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse("Settings.xml");

            Element rootElement = document.getDocumentElement();

            NodeList childNodeList = rootElement.getChildNodes();
            Node node;
            for (int i = 0; i < childNodeList.getLength(); i++) {
                node = childNodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    NodeList childNodesOfSettingsTag = node.getChildNodes();
                    for (int j = 0; j < childNodesOfSettingsTag.getLength(); j++) {
                        Node childNodeOfSettingsTag = childNodesOfSettingsTag.item(j);
                        if (childNodeOfSettingsTag.getNodeType() == Node.ELEMENT_NODE) {
                            if(childNodeOfSettingsTag.getNodeName()=="bgimage")
                            {
                                bgimage=childNodeOfSettingsTag.getTextContent();
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bgimage;
    }
}
