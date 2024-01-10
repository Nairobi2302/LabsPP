package lab5;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final String SECRET_KEY = "YourSecretKey123";

    public static void main(String[] args) throws Exception {
        OutputResults.OutputResultsBuilder outputBuilder = new OutputResults.OutputResultsBuilder();

        ArrayList<Fabric> txt = ContainerCreator.createFabricListFromTxtFile("in_file.txt");
        outputBuilder.setFabricDetailsTitle("Fabric Details").setFabrics(txt);

        DataPrinter dataPrinter = DataPrinter.getInstance();
        dataPrinter.printMethod1(txt);
        dataPrinter.printMethod2(txt);
        dataPrinter.printMethod3(txt);

        OutputResults output = outputBuilder.build();

        ArrayList<String> encryptedDataList = ContainerCreator.createEncryptedData(txt, SECRET_KEY);
        outputBuilder.setEncryptedDataTitle("Encrypted Data").setEncryptedDataList(encryptedDataList);

        ArrayList<String> decryptedDataList = new ArrayList<>();
        for (String encryptedData : encryptedDataList) {
            String decryptedData = EncryptionUtil.decryptData(encryptedData, SECRET_KEY);
            decryptedDataList.add(decryptedData);
        }
        outputBuilder.setDecryptedDataTitle("Decrypted Data").setDecryptedDataList(decryptedDataList);

        ArrayList<Fabric> xml = ContainerCreator.createFabricListFromXMLFile("in_file.xml");
        WorkWithXML.WriteInFileXML(xml, "out_file.xml");

        WorkWithTXT.WriteInFileTXT(txt);

        Map<String, Fabric> fabricMap = ContainerCreator.createFabricMap(txt);
        outputBuilder.setFabricMapDetailsTitle("Fabric Map Details").setFabricMap(fabricMap);

        FabricSorter.sortByType(txt);
        outputBuilder.setFabricDetailsTitle("Sorted Fabric Details").setFabrics(txt);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите новые данные Fabric (Brand Type Weight):");

        String newBrand = scanner.next();
        String newType = scanner.next();
        String newWeight = scanner.next();

        FabricBuilder fabricBuilder = FabricBuilder.getInstance();
        Fabric fabric1 = fabricBuilder.setBrand(newBrand).setType(newType).setWeight(newWeight).build();
        txt.add(fabric1);

        outputBuilder.setFabricDetailsTitle("Updated Fabric Details").setFabrics(txt);
        fabricMap = ContainerCreator.createFabricMap(txt);
        outputBuilder.setFabricMapDetailsTitle("Updated Fabric Map Details").setFabricMap(fabricMap);

        DataValidator.validateData(txt);

        archiving.createZipArchive(txt, "car_archive.zip");
        archiving.createZipArchive(txt, "car_archive1.rar");
        archiving.createJarArchive(txt, "fabrics.jar");
        archiving.convertZipToRar("car_archive.zip", "car_archive.rar");

        outputBuilder.setArchiveCreationResult("car_archive.zip");
        outputBuilder.setArchiveCreationResult("car_archive1.rar");
        outputBuilder.setArchiveCreationResult("fabrics.jar");

        // Создание экземпляра OutputResults после установки всех данных
        output = outputBuilder.build();

        // Вывод результатов
        output.displayFabricDetails();
        output.displayEncryptedData();
        output.displayDecryptedData();
        output.displayFabricMapDetails();

        Scanner scanner1 = new Scanner(System.in);

        System.out.println("Введите данные:");
        String brand = scanner1.nextLine();
        String type = scanner1.nextLine();
        String weight = scanner1.nextLine();

        AbstractFabric fabric = new Fabric(brand, type, weight);

        System.out.println("Введите метаданные:");
        String metadata = scanner1.nextLine();

        FabricMetadataDecorator fabricWithMetadata = new FabricMetadataDecorator(fabric, metadata);
        System.out.println("Новая Информация:");
        System.out.println("Марка: " + fabricWithMetadata.getBrand());
        System.out.println("Тип: " + fabricWithMetadata.getType());
        System.out.println("Вес: " + fabricWithMetadata.getWeight());
        System.out.println("Метаданные: " + fabricWithMetadata.getMetadata().getMetadata());

        scanner1.close();
    }
}
