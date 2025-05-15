public class SecondHand extends ClockHand {
    private int angle;
    @Override
    public void setTime(int timeInSeconds) {
        int seconds = timeInSeconds % 60;
        angle = seconds * 6; // 360° / 60 sec = 6 degrees per sec
    }

    @Override
    public String toSvg() {
        int length = 90;      // hand's length
        int thickness = 2;    // hand's width
        int centerX = 100;    // clock's center X
        int centerY = 100;    // clock's center Y

        double rad = Math.toRadians(angle - 90); //-90 because 0 degrees in SVG is 3:00
        int endX = centerX + (int)(length * Math.cos(rad));
        int endY = centerY + (int)(length * Math.sin(rad));

        return String.format(
                "<line x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\" stroke=\"red\" stroke-width=\"%d\" stroke-linecap=\"round\" />",
                centerX, centerY, endX, endY, thickness);
    }
}
