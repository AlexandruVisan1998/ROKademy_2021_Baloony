package com.Baloony;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;
import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

import static com.Baloony.HAB.put;

public class Main {

    public static void main(String[] args) {
        // generam cu random
        // 5 thread-uri
        // toate intr-un while cat timp merge aplicatia
        // trimitem datele prin JSON, REST API, catre thingworx

        Random rand = new Random();
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
            // Date format (according with ThingWorx)
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
//            long beginTime = Timestamp.valueOf(Constants.BEGIN_TIME).getTime();
//            long endTime = Timestamp.valueOf(Constants.END_TIME).getTime();
            // Generate random date
            Date randomDate = new Date(System.currentTimeMillis());
            //System.out.println(dateFormat.format(randomDate));
            hab[indexHAB].setTakeoffDatetime(dateFormat.format(randomDate));
            hab[indexHAB].setTakeoffLatitude(Math.random() * (Constants.MAX_LATITUDE - Constants.MIN_VALUE + 1) + Constants.MIN_VALUE);
            hab[indexHAB].setTakeoffLongitude(Math.random() * (Constants.MAX_LONGITUDE - Constants.MIN_VALUE + 1) + Constants.MIN_VALUE);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String req1 = "https://pp-2103241556kr.devportal.ptc.io:443/Thingworx/Things/HAB00" + (indexHAB + 1)  +
                    "/Properties/balloonName?method=PUT&value=" + hab[indexHAB].getName() +
                    "&appKey=ff0a6265-791c-45f7-a567-5d3d3b1e42d9&x-thingworx-session=true";
            System.out.println(req1);


            // TODO: functie in HAB
            put(req1);


        }


        while (true) {
            for (int threadID = 0; threadID < Constants.NUMBER_OF_HABS; threadID++) {
                thread[threadID] = new Thread(new MyThread(hab[threadID]));
                thread[threadID].start();
            }

            for (int threadID = 0; threadID < Constants.NUMBER_OF_HABS; threadID++) {
                try {
                    thread[threadID].join();
//                    System.out.println("Current thread is " + threadID);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // Delay intre fiecare update
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
