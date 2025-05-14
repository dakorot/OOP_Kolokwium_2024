import java.io.FileNotFoundException;
import java.util.HashMap;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        DigitalClock testClock = new DigitalClock(11, 32, 1, 24);
        System.out.println(testClock.toString());

        String filePath = "./strefy.csv";
        HashMap<String, City> parsedCities = City.parseFile(filePath);
    }
}
