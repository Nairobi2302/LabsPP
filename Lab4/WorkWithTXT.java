package lab4;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WorkWithTXT {
    public static ArrayList<Fabric> ReadFromFileTXT(String filename) {
        ArrayList<Fabric> people = new ArrayList<>();
        try(FileReader reader = new FileReader(filename)) {
            Scanner scanner = new Scanner(reader);
            while(scanner.hasNextLine()) {
                people.add(new Fabric(scanner.nextLine(), scanner.nextLine(), scanner.nextLine()));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return people;
    }

    public static void WriteInFileTXT(ArrayList<Fabric> people) {
        try(FileWriter writer = new FileWriter("out_file.txt")) {
            for(int i = 0; i < people.size(); ++i) {
                writer.write(people.get(i).getBrand() + " " + people.get(i).getType() + " " + people.get(i).getWeight() + "\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
