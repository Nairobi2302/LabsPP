package lab5;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Comparator;
import static org.junit.jupiter.api.Assertions.*;

public class FabricSorterTest {

    @Test
    public void testSortByType() {
        // Подготовка
        ArrayList<Fabric> fabrics = new ArrayList<>();
        fabrics.add(new Fabric("Kamaz", "Gas_tanker", "22884"));
        fabrics.add(new Fabric("Maz", "Wood_truck", "19500"));
        fabrics.add(new Fabric("Maz2", "Gas", "34680"));

        ArrayList<Fabric> expectedList = new ArrayList<>(fabrics);
        expectedList.sort(Comparator.comparing(Fabric::getBrand));

        // Выполнение
        FabricSorter.sortByType(fabrics);

        // Проверка
        assertEquals(expectedList.size(), fabrics.size());
        for (int i = 0; i < expectedList.size(); i++) {
            assertEquals(expectedList.get(i).getBrand(), fabrics.get(i).getBrand());
            assertEquals(expectedList.get(i).getType(), fabrics.get(i).getType());
            assertEquals(expectedList.get(i).getWeight(), fabrics.get(i).getWeight());
        }
    }

    @Test
    public void testSortByPlace() {
        // Подготовка
        ArrayList<Fabric> fabrics = new ArrayList<>();
        fabrics.add(new Fabric("Kamaz", "Gas_tanker", "22884"));
        fabrics.add(new Fabric("Maz", "Wood_truck", "19500"));
        fabrics.add(new Fabric("Maz2", "Gas", "34680"));

        ArrayList<Fabric> expectedList = new ArrayList<>(fabrics);
        expectedList.sort(Comparator.comparing(Fabric::getType));

        // Выполнение
        FabricSorter.sortByPlace(fabrics);

        // Проверка
        assertEquals(expectedList.size(), fabrics.size());
        for (int i = 0; i < expectedList.size(); i++) {
            assertEquals(expectedList.get(i).getBrand(), fabrics.get(i).getBrand());
            assertEquals(expectedList.get(i).getType(), fabrics.get(i).getType());
            assertEquals(expectedList.get(i).getWeight(), fabrics.get(i).getWeight());
        }
    }

    @Test
    public void testSortByAmount() {
        // Подготовка
        ArrayList<Fabric> fabrics = new ArrayList<>();
        fabrics.add(new Fabric("Kamaz", "Gas_tanker", "22884"));
        fabrics.add(new Fabric("Maz", "Wood_truck", "19500"));
        fabrics.add(new Fabric("Maz2", "Gas", "34680"));

        ArrayList<Fabric> expectedList = new ArrayList<>(fabrics);
        expectedList.sort(Comparator.comparing(Fabric::getWeight));

        // Выполнение
        FabricSorter.sortByAmount(fabrics);

        // Проверка
        assertEquals(expectedList.size(), fabrics.size());
        for (int i = 0; i < expectedList.size(); i++) {
            assertEquals(expectedList.get(i).getBrand(), fabrics.get(i).getBrand());
            assertEquals(expectedList.get(i).getType(), fabrics.get(i).getType());
            assertEquals(expectedList.get(i).getWeight(), fabrics.get(i).getWeight());
        }
    }
}
