package com.Baloony;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;

public class HAB {

    // General information about HAB
    private String name;
    private String serialNumber;
    private String type;

    // Date and location when it was launched
    private LocalDateTime takeoffDatetime;
    private double takeoffLatitude;
    private double takeoffLongitude;

    // Information about the current state of the HAB
    private LocalDateTime currentDatetime;
    private double currentAltitude;
    private double currentLatitude;
    private double currentLongitude;
    private double currentSpeed;

    // Measurable data
    private double windSpeed;
    private double airPressure;
    private double airTemperature;
    private double[] airComposition;

    public HAB(String name, String serialNumber, String type) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.type = type;
        // Initial zero values
        this.currentAltitude = 0;
        this.currentLatitude = 0;
        this.currentLongitude = 0;
        this.currentSpeed = 0;
        this.windSpeed = 0;
        this.airPressure = 0;
        this.airTemperature = 0;
        this.airComposition = new double[8];
    }

    public static void put(String req) {
        try {
            URL url = new URL(req);
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            for (int i = 1; i <= 8; i++) {
                System.out.println(httpCon.getHeaderFieldKey(i) + " = " + httpCon.getHeaderField(i));
            }
            httpCon.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getCurrentDatetime() {
        return currentDatetime;
    }

    public void setCurrentDatetime(LocalDateTime currentDatetime) {
        this.currentDatetime = currentDatetime;
    }

    public double getCurrentAltitude() {
        return currentAltitude;
    }

    public void setCurrentAltitude(double currentAltitude) {
        this.currentAltitude = currentAltitude;
    }

    public double getCurrentLatitude() {
        return currentLatitude;
    }

    public void setCurrentLatitude(double currentLatitude) {
        this.currentLatitude = currentLatitude;
    }

    public double getCurrentLongitude() {
        return currentLongitude;
    }

    public void setCurrentLongitude(double currentLongitude) {
        this.currentLongitude = currentLongitude;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public LocalDateTime getTakeoffDatetime() {
        return takeoffDatetime;
    }

    public void setTakeoffDatetime(LocalDateTime takeoffDatetime) {
        this.takeoffDatetime = takeoffDatetime;
    }

    public double getTakeoffLatitude() {
        return takeoffLatitude;
    }

    public void setTakeoffLatitude(double takeoffLatitude) {
        this.takeoffLatitude = takeoffLatitude;
    }

    public double getTakeoffLongitude() {
        return takeoffLongitude;
    }

    public void setTakeoffLongitude(double takeoffLongitude) {
        this.takeoffLongitude = takeoffLongitude;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getAirPressure() {
        return airPressure;
    }

    public void setAirPressure(double airPressure) {
        this.airPressure = airPressure;
    }

    public double getAirTemperature() {
        return airTemperature;
    }

    public void setAirTemperature(double airTemperature) {
        this.airTemperature = airTemperature;
    }

    public double[] getAirComposition() {
        return airComposition;
    }

    public void setAirComposition(double[] airComposition) {
        this.airComposition = airComposition;
    }

    public void setOneElemAirComposition(double elemAirComposition, int indexElem) {
        this.airComposition[indexElem] = elemAirComposition;
    }

    public double getOneElemAirComposition(int indexElem) {
        return this.airComposition[indexElem];
    }
}
