import java.time.LocalTime;

public abstract class Clock {
    int hour, minute, second;
    private City city;

    public Clock(City city) {
        this.city = city;
    }

    public void setCity(City city) {
            int timeDifference = Integer.parseInt(city.timezone) - Integer.parseInt(this.city.timezone);
            this.city = city;
            this.hour += timeDifference;
    }
    public void setCurrentTime() {
        LocalTime currentTime = LocalTime.now();
        this.hour = currentTime.getHour();
        this.minute = currentTime.getMinute();
        this.second = currentTime.getSecond();
    };

    public void setTime(int hour, int minute, int second) {
        try {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }

        catch (Exception IllegalArgumentException) {
            System.err.println(IllegalArgumentException.getMessage());
        }
    };

    public String toString() {
        return this.hour + ":" + this.minute + ":" + this.second;
    }
}