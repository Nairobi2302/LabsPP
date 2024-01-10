package lab5;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorkWithXMLTest {

    @Test
    public void testReadFromFileXML() {
        // Подготовка
        ArrayList<Fabric> expectedFabrics = new ArrayList<>();
        expectedFabrics.add(new Fabric("Kamaz", "Gas_tanker", "22884"));
        expectedFabrics.add(new Fabric("Maz", "Woodchip_truck", "19500"));

        // Выполнение
        ArrayList<Fabric> actualFabrics = WorkWithXML.ReadFromFileXML("in_file.xml");

        // Проверка
        assertEquals(expectedFabrics.size(), actualFabrics.size());
        for (int i = 0; i < expectedFabrics.size(); i++) {
            assertEquals(expectedFabrics.get(i).getBrand(), actualFabrics.get(i).getBrand());
            assertEquals(expectedFabrics.get(i).getType(), actualFabrics.get(i).getType());
            assertEquals(expectedFabrics.get(i).getWeight(), actualFabrics.get(i).getWeight());
        }
    }

    @Test
    public void testWriteInFileXML() {
        // Подготовка
        ArrayList<Fabric> fabricsToWrite = new ArrayList<>();
        fabricsToWrite.add(new Fabric("Kamaz", "Gas_tanker", "22884"));
        fabricsToWrite.add(new Fabric("Maz", "Woodchip_truck", "19500"));

        String filePath = "test_output.xml";

        // Выполнение
        WorkWithXML.WriteInFileXML(fabricsToWrite, filePath);
        ArrayList<Fabric> readFabrics = WorkWithXML.ReadFromFileXML(filePath);

        // Проверка
        assertEquals(fabricsToWrite.size(), readFabrics.size());
        for (int i = 0; i < fabricsToWrite.size(); i++) {
            assertEquals(fabricsToWrite.get(i).getBrand(), readFabrics.get(i).getBrand());
            assertEquals(fabricsToWrite.get(i).getType(), readFabrics.get(i).getType());
            assertEquals(fabricsToWrite.get(i).getWeight(), readFabrics.get(i).getWeight());
        }
    }
}
