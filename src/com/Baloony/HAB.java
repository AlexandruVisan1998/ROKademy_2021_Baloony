package com.Baloony;

public class HAB {

    // ID
    private String name;
    private String serialNumber;
    private String type;

    private String currentDatetime;
    private double currentAltitude;
    private double currentLatitude;
    private double currentLongitude;
    private double currentSpeed;

    private String takeoffDatetime;
    private double takeoffLatitude;
    private double takeoffLongitude;

    private double landTime;
    private double timpTotalTura;

    //date masurate
    private double windSpeed;
    private double airPressure;
    private double airTemperature;
    private double[] airComposition;


    // cat a zburat intr-o tura = landTime - takeoffTime
    // dupa adunam timpul obtinut la total timpTotalTura


    public HAB ( String name, String serialNumber, String type ) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.type = type;
    }

    public String getName ( ) {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public String getSerialNumber ( ) {
        return serialNumber;
    }

    public void setSerialNumber ( String serialNumber ) {
        this.serialNumber = serialNumber;
    }

    public String getType ( ) {
        return type;
    }

    public void setType ( String type ) {
        this.type = type;
    }

    public String getCurrentDatetime ( ) {
        return currentDatetime;
    }

    public void setCurrentDatetime ( String currentDatetime ) {
        this.currentDatetime = currentDatetime;
    }

    public double getCurrentAltitude ( ) {
        return currentAltitude;
    }

    public void setCurrentAltitude ( double currentAltitude ) {
        this.currentAltitude = currentAltitude;
    }

    public double getCurrentLatitude ( ) {
        return currentLatitude;
    }

    public void setCurrentLatitude ( double currentLatitude ) {
        this.currentLatitude = currentLatitude;
    }

    public double getCurrentLongitude ( ) {
        return currentLongitude;
    }

    public void setCurrentLongitude ( double currentLongitude ) {
        this.currentLongitude = currentLongitude;
    }

    public double getCurrentSpeed ( ) {
        return currentSpeed;
    }

    public void setCurrentSpeed ( double currentSpeed ) {
        this.currentSpeed = currentSpeed;
    }

    public String getTakeoffDatetime ( ) {
        return takeoffDatetime;
    }

    public void setTakeoffDatetime ( String takeoffDatetime ) {
        this.takeoffDatetime = takeoffDatetime;
    }

    public double getTakeoffLatitude ( ) {
        return takeoffLatitude;
    }

    public void setTakeoffLatitude ( double takeoffLatitude ) {
        this.takeoffLatitude = takeoffLatitude;
    }

    public double getTakeoffLongitude ( ) {
        return takeoffLongitude;
    }

    public void setTakeoffLongitude ( double takeoffLongitude ) {
        this.takeoffLongitude = takeoffLongitude;
    }

    public double getLandTime ( ) {
        return landTime;
    }

    public void setLandTime ( double landTime ) {
        this.landTime = landTime;
    }

    public double getTimpTotalTura ( ) {
        return timpTotalTura;
    }

    public void setTimpTotalTura ( double timpTotalTura ) {
        this.timpTotalTura = timpTotalTura;
    }

    public double getWindSpeed ( ) {
        return windSpeed;
    }

    public void setWindSpeed ( double windSpeed ) {
        this.windSpeed = windSpeed;
    }

    public double getAirPressure ( ) {
        return airPressure;
    }

    public void setAirPressure ( double airPressure ) {
        this.airPressure = airPressure;
    }

    public double getAirTemperature ( ) {
        return airTemperature;
    }

    public void setAirTemperature ( double airTemperature ) {
        this.airTemperature = airTemperature;
    }

    public double[] getAirComposition ( ) {
        return airComposition;
    }

    public void setAirComposition ( double[] airComposition ) {
        this.airComposition = airComposition;
    }
}
