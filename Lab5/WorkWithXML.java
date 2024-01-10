package lab5;
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
