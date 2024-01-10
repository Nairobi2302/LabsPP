package lab5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FabricSorter {

    public static void sortByType(ArrayList<Fabric> fabrics) {
        Collections.sort(fabrics, Comparator.comparing(Fabric::getBrand));
    }

    public static void sortByPlace(ArrayList<Fabric> fabrics) {
        Collections.sort(fabrics, Comparator.comparing(Fabric::getType));
    }

    public static void sortByAmount(ArrayList<Fabric> fabrics) {
        Collections.sort(fabrics, Comparator.comparing(Fabric::getWeight));
    }
}
