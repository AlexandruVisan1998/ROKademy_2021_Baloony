package com.Baloony;

public class Constants {
    public static final int NUMBER_OF_HABS = 5;

    // Limits
    public static final double MIN_VALUE = 0;
    public static final double MIN_LATITUDE = -90;
    public static final double MAX_LATITUDE = 90;
    public static final double MIN_LONGITUDE = -180;
    public static final double MAX_LONGITUDE = 180;
    public static final double MIN_ALTITUDE = 1000;
    public static final double MAX_ALTITUDE = 5000;
    public static final double MIN_SPEED = 20;
    public static final double MAX_SPEED = 200;
    public static final double MAX_WIND = 200;
    public static final double MAX_PRESSURE = 800;
    public static final double MIN_PRESSURE = 600;
    public static final double MAX_TEMP = 70;
    public static final double MIN_TEMP = -30;
    public static final double VARIATION_VALUE = 0.0001;
    public static final double VAR_ALTITUDE = 100;
    public static final double VAR_LAT_LONG = 2;
    public static final double VAR_SPEED = 15;
    public static final double VAR_AIR_PRESSURE = 10;
    public static final double VAR_TEMPERATURE = 5;

    // HAB names
    public static final String NAME_HAB1 = "Joanne";
    public static final String NAME_HAB2 = "Mario";
    public static final String NAME_HAB3 = "Johnny";
    public static final String NAME_HAB4 = "Estella";
    public static final String NAME_HAB5 = "Rocky";

    // HAB serialNumbers
    public static final String SERIAL_NUMBER_HAB1 = "UX550";
    public static final String SERIAL_NUMBER_HAB2 = "UX551";
    public static final String SERIAL_NUMBER_HAB3 = "UX552";
    public static final String SERIAL_NUMBER_HAB4 = "UX553";
    public static final String SERIAL_NUMBER_HAB5 = "UX554";

    // HAB types
    public static final String TYPE_HAB1 = "TYPE1";
    public static final String TYPE_HAB2 = "TYPE2";
    public static final String TYPE_HAB3 = "TYPE3";
    public static final String TYPE_HAB4 = "TYPE4";
    public static final String TYPE_HAB5 = "TYPE5";

    public static final double[] compositionValues = new double[]{78.075857, 20.946, 0.934, 0.0415, 0.001818, 0.000524, 0.000187, 0.000114};
    // diff 0.008143

    public static final String reqSubstring1 = "https://pp-2103241556kr.devportal.ptc.io:443/Thingworx/Things/HAB00";
    public static final String reqSubstring2 = "/Properties/";
    public static final String reqSubstring3 = "?method=PUT&value=";
    public static final String reqSubstring4 = "&appKey=ff0a6265-791c-45f7-a567-5d3d3b1e42d9&x-thingworx-session=true";

    public static final String NAME = "balloonName";
    public static final String SERIAL_NUMBER = "balloonSerialNumber";
    public static final String TYPE = "balloonType";
    public static final String TAKEOFF_DATETIME = "takeoffDatetime";
    public static final String TAKEOFF_LOCATION = "takeOffLocation";
    public static final String CURRENT_DATETIME = "currentDateTime";
    public static final String CURRENT_ALTITUDE = "currentAltitude";
    public static final String CURRENT_LOCATION = "currentLocation";
    public static final String CURRENT_SPEED = "currentSpeed";
    public static final String WIND_SPEED = "windSpeed";
    public static final String AIR_PRESSURE = "airPressure";
    public static final String AIR_TEMPERATURE = "airTemperature";
    public static final String TOTAL_TIME = "totalTime";

    public static final String[] arrayComposition = new String[]{"nitrogenPercentage", "oxygenPercentage", "argonPercentage",
            "carbonDioxidePercentage", "neonPercentage", "heliumPercentage",
            "methanePercentage", "kryptonPercentage"};
}
