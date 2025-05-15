public class MinuteHand extends ClockHand {
    private double angle;

    @Override
    public void setTime(int timeInSeconds) {
        int minutes = (timeInSeconds / 60) % 60;
        int seconds = timeInSeconds % 60;

        angle = (minutes * 60 + seconds) * (360.0 / 3600.0);
    }

    @Override
    public String toSvg() {
        int length = 80;
        int thickness = 3;
        int centerX = 100;
        int centerY = 100;

        double rad = Math.toRadians(angle - 90);
        int endX = centerX + (int)(length * Math.cos(rad));
        int endY = centerY + (int)(length * Math.sin(rad));

        return String.format(
                "<line x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\" stroke=\"blue\" stroke-width=\"%d\" stroke-linecap=\"round\" />",
                centerX, centerY, endX, endY, thickness);
    }
}
