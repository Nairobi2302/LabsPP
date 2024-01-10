package lab5;
import java.util.ArrayList;

public class DataValidator {

    public static void validateData(ArrayList<Fabric> fabrics) {
        System.out.println("--- Data Validation ---");
        for (Fabric fabric : fabrics) {
            if (fabric.getBrand() == null || fabric.getType() == null || fabric.getWeight() == null) {
                System.out.println("Invalid data found:");
                System.out.println("Brand: " + fabric.getBrand());
                System.out.println("Type: " + fabric.getType());
                System.out.println("Weight: " + fabric.getWeight());
            } else {
                System.out.println("Data is valid for:");
                System.out.println("Brand: " + fabric.getBrand());
                System.out.println("Type: " + fabric.getType());
                System.out.println("Weight: " + fabric.getWeight());
            }
            System.out.println("----------------------");
        }
    }
}
