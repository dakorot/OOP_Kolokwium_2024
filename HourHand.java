public class HourHand extends ClockHand {
    private double angle;

    @Override
    public void setTime(int timeInSeconds) {
        int hours = (timeInSeconds / 3600) % 12;
        int minutes = (timeInSeconds % 3600) / 60;
        int seconds = timeInSeconds % 60;

        angle = (hours * 3600 + minutes * 60 + seconds) * (360.0 / 43200.0);
    }

    @Override
    public String toSvg() {
        int length = 60;
        int thickness = 5;
        int centerX = 100;
        int centerY = 100;

        double rad = Math.toRadians(angle - 90);
        int endX = centerX + (int)(length * Math.cos(rad));
        int endY = centerY + (int)(length * Math.sin(rad));

        return String.format(
                "<line x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\" stroke=\"black\" stroke-width=\"%d\" stroke-linecap=\"round\" />",
                centerX, centerY, endX, endY, thickness);
    }
}
