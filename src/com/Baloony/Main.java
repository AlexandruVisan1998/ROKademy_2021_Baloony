package com.Baloony;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

import static com.Baloony.HAB.put;

public class Main {

    public static void main(String[] args) throws IOException {

        HAB[] hab = new HAB[Constants.NUMBER_OF_HABS];
        Thread[] thread = new Thread[Constants.NUMBER_OF_HABS];

        // HABs
        hab[0] = new HAB(Constants.NAME_HAB1, Constants.SERIAL_NUMBER_HAB1, Constants.TYPE_HAB1);
        hab[1] = new HAB(Constants.NAME_HAB2, Constants.SERIAL_NUMBER_HAB2, Constants.TYPE_HAB2);
        hab[2] = new HAB(Constants.NAME_HAB3, Constants.SERIAL_NUMBER_HAB3, Constants.TYPE_HAB3);
        hab[3] = new HAB(Constants.NAME_HAB4, Constants.SERIAL_NUMBER_HAB4, Constants.TYPE_HAB4);
        hab[4] = new HAB(Constants.NAME_HAB5, Constants.SERIAL_NUMBER_HAB5, Constants.TYPE_HAB5);


        // Generate random data for each HAB
        for (int indexHAB = 0; indexHAB < Constants.NUMBER_OF_HABS; indexHAB++) {
            hab[indexHAB].setTakeoffDatetime(LocalDateTime.now());
            hab[indexHAB].setTakeoffLatitude(Math.random() * (Constants.MAX_LATITUDE - Constants.MIN_LATITUDE + 1) + Constants.MIN_LATITUDE);
            hab[indexHAB].setTakeoffLongitude(Math.random() * (Constants.MAX_LONGITUDE - Constants.MIN_LONGITUDE + 1) + Constants.MIN_LONGITUDE);

            File myObj = new File("lastValue_Location" + indexHAB + ".txt");
            Scanner myReader = null;
            try {
                myReader = new Scanner(myObj);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            if(myObj.length() != 0) {
                double[] vect = new double[3];
                int i = 0;
                while (myReader.hasNextLine()) {
                    vect[i++] = Double.parseDouble(myReader.nextLine());
                }
                // Current Latitude and Longitude
                hab[indexHAB].setCurrentLatitude(vect[0]);
                hab[indexHAB].setCurrentLongitude(vect[1]);
                // Current Altitude
                hab[indexHAB].setCurrentAltitude(vect[2]);
            } else {
                // Current Altitude
                hab[indexHAB].setCurrentAltitude(Math.random() * (Constants.MAX_ALTITUDE - Constants.MIN_ALTITUDE + 1) + Constants.MIN_ALTITUDE);
                // Current Latitude and Longitude
                hab[indexHAB].setCurrentLatitude(Math.random() * (Constants.MAX_LATITUDE - Constants.MIN_LATITUDE + 1) + Constants.MIN_LATITUDE);
                hab[indexHAB].setCurrentLongitude(Math.random() * (Constants.MAX_LONGITUDE - Constants.MIN_LONGITUDE + 1) + Constants.MIN_LONGITUDE);
            }

            // Current Wind Speed
            hab[indexHAB].setWindSpeed(Math.random() * (Constants.MAX_WIND - Constants.MIN_VALUE + 1) + Constants.MIN_VALUE);
            // Current Speed
            hab[indexHAB].setCurrentSpeed(Math.random() * (Constants.MAX_SPEED - Constants.MIN_SPEED + 1) + Constants.MIN_SPEED);
            // Current Air Pressure
            hab[indexHAB].setAirPressure(Math.random() * (Constants.MAX_PRESSURE - Constants.MIN_PRESSURE + 1) + Constants.MIN_PRESSURE);
            // Current Air Temperature
            hab[indexHAB].setAirTemperature(Math.random() * (Constants.MAX_TEMP - Constants.MIN_TEMP + 1) + Constants.MIN_TEMP);

            // Launch balloons at a difference of one second from each other
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Send fixed information about HABs
            String reqName = Constants.reqSubstring1 + (indexHAB + 1) + Constants.reqSubstring2 +
                    Constants.NAME + Constants.reqSubstring3 + hab[indexHAB].getName() +
                    Constants.reqSubstring4;
            String reqSerialNumber = Constants.reqSubstring1 + (indexHAB + 1) + Constants.reqSubstring2 +
                    Constants.SERIAL_NUMBER + Constants.reqSubstring3 + hab[indexHAB].getSerialNumber() +
                    Constants.reqSubstring4;
            String reqType = Constants.reqSubstring1 + (indexHAB + 1) + Constants.reqSubstring2 +
                    Constants.TYPE + Constants.reqSubstring3 + hab[indexHAB].getType() +
                    Constants.reqSubstring4;

            String reqTakeoffDateTime = Constants.reqSubstring1 + (indexHAB + 1) + Constants.reqSubstring2 +
                    Constants.TAKEOFF_DATETIME + Constants.reqSubstring3 + hab[indexHAB].getTakeoffDatetime() +
                    Constants.reqSubstring4;

            String location = hab[indexHAB].getCurrentLatitude() + "," + hab[indexHAB].getTakeoffLongitude() + ",0";
            String reqTakeoffLocation = Constants.reqSubstring1 + (indexHAB + 1) + Constants.reqSubstring2 +
                    Constants.TAKEOFF_LOCATION + Constants.reqSubstring3 + location +
                    Constants.reqSubstring4;

            put(reqName);
            put(reqSerialNumber);
            put(reqType);
            put(reqTakeoffDateTime);
            put(reqTakeoffLocation);

        }

        while (true) {
            for (int threadID = 0; threadID < Constants.NUMBER_OF_HABS; threadID++) {
                thread[threadID] = new Thread(new MyThread(hab[threadID], threadID));
                thread[threadID].start();
            }

            for (int threadID = 0; threadID < Constants.NUMBER_OF_HABS; threadID++) {
                try {
                    thread[threadID].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // Delay intre fiecare update
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
