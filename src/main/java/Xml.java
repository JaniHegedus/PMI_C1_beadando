import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Xml extends MedicineGui
{
    public static void saveMedToXml(ArrayList<Medicine> users, String filepath)
    {
        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element rootElement = document.createElement("Medicines");
            document.appendChild(rootElement);

            for (Medicine user : users)
            {
                Element userElement = document.createElement("Medicine");
                rootElement.appendChild(userElement);
                createChildElement(document, userElement, "name", user.getName());
                createChildElement(document, userElement, "des", user.getDes());
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
    public static void createChildElement(Document document, Element parent, String tagName, String text)
    {
        Element element = document.createElement(tagName);
        element.setTextContent(text);
        parent.appendChild(element);
    }
    public static int[] getdata()
    {
        {
            int[] Settings = new int[4];
            try {
                DocumentBuilderFactory documentBuilderFactory
                        = DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                Document document = documentBuilder.parse("src/main/resources/Settings.xml");

                Element rootElement = document.getDocumentElement();

                NodeList childNodeList = rootElement.getChildNodes();
                Node node;
                for (int i = 0; i < childNodeList.getLength(); i++) {
                    node = childNodeList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        NodeList childNodesOfUserTag = node.getChildNodes();
                        int width = 0, height = 0,widthl = 0, heightl = 0;
                        for (int j = 0; j < childNodesOfUserTag.getLength(); j++) {
                            Node childNodeOfUserTag = childNodesOfUserTag.item(j);
                            if (childNodeOfUserTag.getNodeType() == Node.ELEMENT_NODE) {
                                switch (childNodeOfUserTag.getNodeName()) {
                                    case "width" -> width = Integer.parseInt(childNodeOfUserTag.getTextContent());
                                    case "height" -> height = Integer.parseInt(childNodeOfUserTag.getTextContent());
                                    case "widthl" -> widthl = Integer.parseInt(childNodeOfUserTag.getTextContent());
                                    case "heightl" -> heightl = Integer.parseInt(childNodeOfUserTag.getTextContent());
                                }
                            }
                        }
                        Settings[0] = width;
                        Settings[1] = height;
                        Settings[2] = widthl;
                        Settings[3] = heightl;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return Settings;
        }
    }
}
