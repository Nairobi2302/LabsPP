package lab4;
import java.util.ArrayList;
import java.util.zip.ZipOutputStream;
import java.util.zip.ZipEntry;
import java.io.FileOutputStream;
import java.io.IOException;

public class lab4 {
	
    public static void main(String[] args) throws Exception {
        ArrayList<Fabric> txt = new ArrayList<>(WorkWithTXT.ReadFromFileTXT("in_file.txt"));

        // Encrypt data and print encrypted output
        System.out.println("--- Encrypted Data ---");
        for (Fabric fabric : txt) {
            String data = fabric.getBrand() + "\n" + fabric.getType() + "\n" + fabric.getWeight();
            String encryptedData = EncryptionUtil.encryptData(data);
            System.out.println(encryptedData);

        }

        ArrayList<Fabric> xml = new ArrayList<>(WorkWithXML.ReadFromFileXML("in_file.xml"));
        WorkWithXML.WriteInFileXML(xml, "out_file.xml");


        WorkWithTXT.WriteInFileTXT(txt);

        // Rest of your original code remains unchanged below...
        System.out.println("--- Method 1 ---");
        for (Fabric p : txt) {
            System.out.println(p.getBrand() + " " + p.getType() + " " + p.getWeight());
        }
        System.out.println("\n");

        System.out.println("--- Method 2 ---");
        txt.forEach(n -> System.out.println(n.getBrand() + " " + n.getType() + " " + n.getWeight()));
        System.out.println("\n");

        System.out.println("--- Method 3 ---");
        for (Fabric t : txt) {
            System.out.println(t.getBrand() + " " + t.getType() + " " + t.getWeight());
        }
        DataValidator.validateData(txt);
        archiving.createZipArchive(txt, "car_archive.zip");
    }
}
