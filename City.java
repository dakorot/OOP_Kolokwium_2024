import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class City {
    String name;
    String timezone;
    String latitude; // szerokość - pionowo
    String longitude; // dlugość - poziomo

    private static City parseLine(String line) {
        City newCity = new City();
        String[] values = line.split(",");
        newCity.name = values[0];
        newCity.timezone = values[1];
        newCity.latitude = values[2];
        newCity.longitude = values[3];

        return newCity;
    }

    public static HashMap<String, City> parseFile(String path) throws FileNotFoundException {
        HashMap<String, City> cities = new HashMap<>();
        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNextLine()) {
                City city = parseLine(scanner.nextLine());
                cities.put(city.name, city);
            }

            return cities;
        }
        catch (FileNotFoundException exception) {
            throw new FileNotFoundException(exception.getMessage());
        }
    }
}
