import java.io.FileNotFoundException;
import java.util.HashMap;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        City testCity = new City();
        testCity.name = "Warszawa";
        testCity.timezone = "2";
        testCity.latitude = "52.2297 N";
        testCity.longitude = "21.0122 E";

        DigitalClock testDigitalClock = new DigitalClock(11, 32, 1, 24, testCity);
        System.out.println(testDigitalClock.toString());

        String filePath = "./strefy.csv";
        HashMap<String, City> parsedCities = City.parseFile(filePath);


        City testCity2 = new City();
        testCity2.name = "Kijów";
        testCity2.timezone = "3";
        testCity2.latitude = "50.4501 N";
        testCity2.longitude = "30.5234 E";

        testDigitalClock.setCity(testCity2);

    }
}
