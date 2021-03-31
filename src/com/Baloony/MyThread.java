package com.Baloony;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Runnable;
import java.time.*;
import java.util.concurrent.TimeUnit;

import static com.Baloony.HAB.put;


public class MyThread implements Runnable {

    private HAB hab;
    private final int indexHab;

    public MyThread(HAB hab, int indexHab) {
        this.hab = hab;
        this.indexHab = indexHab;
    }

    public void run() {
        hab.setCurrentDatetime(LocalDateTime.now());
        // Altitude
        double previousValue = Math.random() * (Constants.VAR_ALTITUDE - (-Constants.VAR_ALTITUDE)) + (-Constants.VAR_ALTITUDE);
        if (hab.getCurrentAltitude() + previousValue > Constants.MAX_ALTITUDE) {
            hab.setCurrentAltitude(hab.getCurrentAltitude() - previousValue);
        } else if (hab.getCurrentAltitude() + previousValue < Constants.MIN_VALUE) {
            hab.setCurrentAltitude(hab.getCurrentAltitude() - previousValue);
        } else {
            hab.setCurrentAltitude(hab.getCurrentAltitude() + previousValue);
        }

        // Location
        // Latitude
        previousValue = Math.random() * (Constants.VAR_LAT_LONG - (-Constants.VAR_LAT_LONG)) + (-Constants.VAR_LAT_LONG);
        if (hab.getCurrentLatitude() + previousValue > Constants.MAX_LATITUDE) {
            hab.setCurrentLatitude(hab.getCurrentLatitude() - previousValue);
        } else if (hab.getCurrentLatitude() + previousValue < Constants.MIN_LATITUDE) {
            hab.setCurrentLatitude(hab.getCurrentLatitude() - previousValue);
        } else {
            hab.setCurrentLatitude(hab.getCurrentLatitude() + previousValue);
        }

        // Longitude
        previousValue = Math.random() * (Constants.VAR_LAT_LONG - (-Constants.VAR_LAT_LONG)) + (-Constants.VAR_LAT_LONG);
        if (hab.getCurrentLongitude() + previousValue > Constants.MAX_LONGITUDE) {
            hab.setCurrentLongitude(hab.getCurrentLongitude() - previousValue);
        } else if (hab.getCurrentLongitude() + previousValue < Constants.MIN_LONGITUDE) {
            hab.setCurrentLongitude(hab.getCurrentLongitude() - previousValue);
        } else {
            hab.setCurrentLongitude(hab.getCurrentLongitude() + previousValue);
        }

        // Current Speed
        previousValue = Math.random() * (Constants.VAR_SPEED - (-Constants.VAR_SPEED)) + (-Constants.VAR_SPEED);
        if (hab.getCurrentSpeed() + previousValue > Constants.MAX_SPEED) {
            hab.setCurrentSpeed(hab.getCurrentSpeed() - previousValue);
        } else if (hab.getCurrentSpeed() + previousValue < Constants.MIN_SPEED) {
            hab.setCurrentSpeed(hab.getCurrentSpeed() - previousValue);
        } else {
            hab.setCurrentSpeed(hab.getCurrentSpeed() + previousValue);
        }

        // Wind Speed
        previousValue = Math.random() * (Constants.VAR_SPEED - (-Constants.VAR_SPEED)) + (-Constants.VAR_SPEED);
        if (hab.getWindSpeed() + previousValue > Constants.MAX_WIND) {
            hab.setWindSpeed(hab.getWindSpeed() - previousValue);
        } else if (hab.getWindSpeed() + previousValue < Constants.MIN_VALUE) {
            hab.setWindSpeed(hab.getWindSpeed() - previousValue);
        } else {
            hab.setWindSpeed(hab.getWindSpeed() + previousValue);
        }

        // Air Pressure
        previousValue = Math.random() * (Constants.VAR_AIR_PRESSURE - (-Constants.VAR_AIR_PRESSURE)) + (-Constants.VAR_AIR_PRESSURE);
        if (hab.getAirPressure() + previousValue > Constants.MAX_PRESSURE) {
            hab.setAirPressure(hab.getAirPressure() - previousValue);
        } else if (hab.getAirPressure() + previousValue < Constants.MIN_PRESSURE) {
            hab.setAirPressure(hab.getAirPressure() - previousValue);
        } else {
            hab.setAirPressure(hab.getAirPressure() + previousValue);
        }

        // Air Temperature
        previousValue = Math.random() * (Constants.VAR_TEMPERATURE - (-Constants.VAR_TEMPERATURE)) + (-Constants.VAR_TEMPERATURE);
        if (hab.getAirTemperature() + previousValue > Constants.MAX_TEMP) {
            hab.setAirTemperature(hab.getAirTemperature() - previousValue);
        } else if (hab.getAirTemperature() + previousValue < Constants.MIN_TEMP) {
            hab.setAirTemperature(hab.getAirTemperature() - previousValue);
        } else {
            hab.setAirTemperature(hab.getAirTemperature() + previousValue);
        }

        for (int indexElem = 0; indexElem < 7; indexElem++) {
            hab.setOneElemAirComposition(Constants.compositionValues[indexElem], indexElem);
            if (indexElem == 0) {
                previousValue = 1000 * Math.random() * (Constants.VARIATION_VALUE - (-Constants.VARIATION_VALUE)) + (-Constants.VARIATION_VALUE);
            } else {
                previousValue = Math.random() * (Constants.VARIATION_VALUE - (-Constants.VARIATION_VALUE)) + (-Constants.VARIATION_VALUE);
            }
            // Current elem
            double changedValue = hab.getOneElemAirComposition(indexElem) - previousValue;
            if (changedValue < 0) {
                changedValue = 0;
            }
            hab.setOneElemAirComposition(changedValue, indexElem);
            // Next elem
            changedValue = hab.getOneElemAirComposition(indexElem + 1) - previousValue;
            if (changedValue < 0) {
                changedValue = 0;
            }
            hab.setOneElemAirComposition(changedValue, indexElem + 1);
        }

        // Send request
        String reqCurrentDateTime = Constants.reqSubstring1 + (indexHab + 1) + Constants.reqSubstring2 +
                Constants.CURRENT_DATETIME + Constants.reqSubstring3 + hab.getCurrentDatetime() +
                Constants.reqSubstring4;

        String reqCurrentAltitude = Constants.reqSubstring1 + (indexHab + 1) + Constants.reqSubstring2 +
                Constants.CURRENT_ALTITUDE + Constants.reqSubstring3 + hab.getCurrentAltitude() +
                Constants.reqSubstring4;

        String location = hab.getCurrentLatitude() + "," + hab.getCurrentLongitude() + ",0";
        String reqCurrentLocation = Constants.reqSubstring1 + (indexHab + 1) + Constants.reqSubstring2 +
                Constants.CURRENT_LOCATION + Constants.reqSubstring3 + location +
                Constants.reqSubstring4;

        String reqCurrentSpeed = Constants.reqSubstring1 + (indexHab + 1) + Constants.reqSubstring2 +
                Constants.CURRENT_SPEED + Constants.reqSubstring3 + hab.getCurrentSpeed() +
                Constants.reqSubstring4;

        String reqWindSpeed = Constants.reqSubstring1 + (indexHab + 1) + Constants.reqSubstring2 +
                Constants.WIND_SPEED + Constants.reqSubstring3 + hab.getWindSpeed() +
                Constants.reqSubstring4;

        String reqAirPressure = Constants.reqSubstring1 + (indexHab + 1) + Constants.reqSubstring2 +
                Constants.AIR_PRESSURE + Constants.reqSubstring3 + hab.getAirPressure() +
                Constants.reqSubstring4;

        String reqAirTemperature = Constants.reqSubstring1 + (indexHab + 1) + Constants.reqSubstring2 +
                Constants.AIR_TEMPERATURE + Constants.reqSubstring3 + hab.getAirTemperature() +
                Constants.reqSubstring4;

        for (int i = 0; i < 8; i++) {
            String reqElemComposition = Constants.reqSubstring1 + (indexHab + 1) + Constants.reqSubstring2 +
                    Constants.arrayComposition[i] + Constants.reqSubstring3 + hab.getOneElemAirComposition(i) +
                    Constants.reqSubstring4;
            put(reqElemComposition);
        }
        long millis = Duration.between(hab.getTakeoffDatetime(), hab.getCurrentDatetime()).toMillis();
        String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
                TimeUnit.MILLISECONDS.toMinutes(millis) % TimeUnit.HOURS.toMinutes(1),
                TimeUnit.MILLISECONDS.toSeconds(millis) % TimeUnit.MINUTES.toSeconds(1));
        String reqTotalTime = Constants.reqSubstring1 + (indexHab + 1) + Constants.reqSubstring2 +
                Constants.TOTAL_TIME + Constants.reqSubstring3 + hms +
                Constants.reqSubstring4;

        put(reqCurrentDateTime);
        put(reqCurrentAltitude);
        put(reqCurrentLocation);
        put(reqCurrentSpeed);
        put(reqWindSpeed);
        put(reqAirPressure);
        put(reqAirTemperature);
        put(reqTotalTime);

        try {
            FileWriter myWriter = new FileWriter("lastValue_Location" + indexHab + ".txt");
            myWriter.write(String.valueOf(hab.getCurrentLatitude()) + '\n');
            myWriter.write(String.valueOf(hab.getCurrentLongitude()) + '\n');
            myWriter.write(String.valueOf(hab.getCurrentAltitude()) + '\n');
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
