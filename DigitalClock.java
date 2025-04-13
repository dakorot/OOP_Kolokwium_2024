public class DigitalClock extends Clock {
    int format;

    public DigitalClock(int hour, int minute, int second, int format) {
        setTime(hour, minute, second);
        if(format == 12 || format == 24)
            this.format = format;
    }

    public String formattedHour()
    {
        if(this.hour >= 1 && this.hour <= 9)
            return "0" + this.hour;

        if(this.hour == 12)
            return "12";

        if(this.hour == 0 || this.hour == 24)
            return "00";

        if(this.format == 12) {
            if(this.hour % 12 >= 1 && this.hour % 12 <= 9) {
                return "0" + this.hour % 12;
            }
            else
                return "" + this.hour % 12;
        }

        if(this.format == 24)
            return "" + this.hour;

        return "" + this.hour;
    }

    public String formattedMinute()
    {
        if(this.minute >= 0 && this.minute <= 9)
            return "0" + this.minute;

        return "" + this.minute;
    }

    public String formattedSecond()
    {
        if(this.second >= 0 && this.second <= 9)
            return "0" + this.second;

        return "" + this.second;
    }

    @Override
    public String toString() {
        if(this.format == 12 && ((this.hour >= 0 && this.hour <= 11) || this.hour == 24))
            return formattedHour() + ":" + formattedMinute() + ":" + formattedSecond() + " AM";
        else if(this.format == 12)
            return formattedHour() + ":" + formattedMinute() + ":" + formattedSecond() + " PM";

        return formattedHour() + ":" + formattedMinute() + ":" + formattedSecond();
    }
}