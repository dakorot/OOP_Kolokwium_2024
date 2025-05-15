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
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

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

    public static double parseLongitude(String longitude) {
        String[] parts = longitude.trim().split(" ");
        double degrees = Double.parseDouble(parts[0]);
        String direction = parts[1];

        return direction.equalsIgnoreCase("W") ? -degrees : degrees;
    }
    public String localMeanTime(int hour, int min, int sec) {
        double longitude = parseLongitude(this.longitude);
        double timezoneDifference = longitude - Double.parseDouble(this.timezone)*15.0;
        int localTimeShiftInSeconds = (int)Math.round(timezoneDifference*240);
        int totalSeconds = hour*3600 + min*60 + sec;
        totalSeconds += localTimeShiftInSeconds;
        totalSeconds = ((totalSeconds % 86400) + 86400) % 86400;

        int newHour = totalSeconds / 3600;
        int newMin = (totalSeconds % 3600) / 60;
        int newSec  = totalSeconds % 60;

        return String.format("%02d:%02d:%02d", newHour, newMin, newSec);
    }

    public static int worstTimezoneFit(City city1, City city2) {
        double longitude1 = parseLongitude(city1.longitude);
        double longitude2 = parseLongitude(city2.longitude);
        double difference1 = Math.abs(longitude1 - Double.parseDouble(city1.timezone)*15.0);
        double difference2 = Math.abs(longitude2 - Double.parseDouble(city2.timezone)*15.0);

        return Double.compare(difference2, difference1);
    }
}
