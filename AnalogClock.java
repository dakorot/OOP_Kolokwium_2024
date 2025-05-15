import java.io.FileWriter;
import java.io.IOException;

public class AnalogClock extends Clock {

    public AnalogClock(City city) {
        super(city);
    }

    public static void toSvg(String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        StringBuilder svg = new StringBuilder();

        int size = 200;
        int center = size / 2;
        int radius = center - 10;

        svg.append(String.format("""
                <svg width="%d" height="%d" xmlns="http://www.w3.org/2000/svg">
                    <circle cx="%d" cy="%d" r="%d" stroke="black" stroke-width="4" fill="white"/>
            """, size, size, center, center, radius));

        for (int i = 0; i < 4; i++) {
            double angle = Math.toRadians(i * 90); // 360° / 4 = 90°
            int dotX = (int) (center + (radius - 10) * Math.sin(angle));
            int dotY = (int) (center - (radius - 10) * Math.cos(angle));
            svg.append(String.format(
                    "<circle cx=\"%d\" cy=\"%d\" r=\"3\" fill=\"black\" />\n",
                    dotX, dotY));
        }

        svg.append("</svg>");
        writer.write(svg.toString());
        writer.close();
    }
}
