package lab4;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class WorkWithXML {

    public static ArrayList<Fabric> ReadFromFileXML(String filePath) {
        ArrayList<Fabric> fabrics = new ArrayList<>();

       
        try {
            File file = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            NodeList fabricList = doc.getElementsByTagName("Fabric");

            for (int temp = 0; temp < fabricList.getLength(); temp++) {
                Node fabricNode = fabricList.item(temp);
                if (fabricNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element fabricElement = (Element) fabricNode;
                    String brand = fabricElement.getElementsByTagName("Brand").item(0).getTextContent();
                    String type = fabricElement.getElementsByTagName("Type").item(0).getTextContent();
                    String weight = fabricElement.getElementsByTagName("Weight").item(0).getTextContent();
                    fabrics.add(new Fabric(brand, type, weight));
                    
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fabrics;
    }

    public static void WriteInFileXML(ArrayList<Fabric> fabrics, String filePath) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // Root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("Fabrics");
            doc.appendChild(rootElement);

            for (Fabric fabric : fabrics) {
                // Fabric elements
                Element fabricElement = doc.createElement("Fabric");
                rootElement.appendChild(fabricElement);

                // Brand element
                Element brand = doc.createElement("Brand");
                brand.appendChild(doc.createTextNode(fabric.getBrand()));
                fabricElement.appendChild(brand);

                // Type element
                Element type = doc.createElement("Type");
                type.appendChild(doc.createTextNode(fabric.getType()));
                fabricElement.appendChild(type);

                // Weight element
                Element weight = doc.createElement("Weight");
                weight.appendChild(doc.createTextNode(String.valueOf(fabric.getWeight())));
                fabricElement.appendChild(weight);
            }

            // Write the content into XML file
            FileOutputStream outputStream = new FileOutputStream(filePath);
            javax.xml.transform.TransformerFactory.newInstance().newTransformer().transform(new javax.xml.transform.dom.DOMSource(doc), new javax.xml.transform.stream.StreamResult(outputStream));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
