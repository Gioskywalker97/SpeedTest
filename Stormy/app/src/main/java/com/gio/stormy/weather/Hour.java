package com.gio.stormy.weather;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Hour {

    private long time;
    private String summary;
    private double temperature;
    private String icon;
    private String timeZone;


    public String getTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("h a");
        formatter.setTimeZone(TimeZone.getTimeZone(timeZone));

        Date datetime = new Date(time * 1000);
        return formatter.format(datetime);
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getTemperature() { return (int)Math.round(temperature); }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getIcon() {
        return Forecast.getIconeId(icon);
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
}
