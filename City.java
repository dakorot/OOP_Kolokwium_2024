import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class City {
    String name;
    String timezone;
    String longitude;
    String latitude;

    private City parseLine(String line) {
        City newCity = new City();
        String[] values = line.split(",");
        newCity.name = values[0];
        newCity.timezone = values[1];
        newCity.longitude = values[2];
        newCity.latitude = values[3];

        return newCity;
    }

    public HashMap<String, String> parseFile(String path) throws FileNotFoundException {
        HashMap<String, String> cities = new HashMap<>();
        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNextLine()) {
                City city = parseLine(scanner.nextLine());
                cities.put("name", city.name);
                cities.put("timezone", city.timezone);
                cities.put("longitude", city.longitude);
                cities.put("latitude", city.latitude);
            }

            return cities;
        }
        catch (FileNotFoundException exception) {
            throw new FileNotFoundException(exception.getMessage());
        }
    }
}
