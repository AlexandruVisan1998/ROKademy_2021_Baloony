package com.Baloony;
import java.lang.Runnable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import static com.Baloony.Constants.MAX_COMP;


public class MyThread implements Runnable {

    private Random rand = new Random();
    private HAB hab;

    public MyThread(HAB hab) {
        this.hab = hab;
    }

    public void run() {
        double sum = MAX_COMP;
        // Date format (according with ThingWorx)
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        // Generate random date
        Date randomDate = new Date(System.currentTimeMillis());
        hab.setTakeoffDatetime(dateFormat.format(randomDate));

        hab.setCurrentAltitude(Math.random() * (Constants.MAX_ALTITUDE - Constants.MIN_VALUE + 1) + Constants.MIN_VALUE);
        hab.setCurrentLatitude(Math.random() * (Constants.MAX_LATITUDE - Constants.MIN_VALUE + 1) + Constants.MIN_VALUE);
        hab.setCurrentLongitude(Math.random() * (Constants.MAX_LONGITUDE - Constants.MIN_VALUE + 1) + Constants.MIN_VALUE);
        hab.setCurrentSpeed(Math.random() * (Constants.MAX_SPEED - Constants.MIN_VALUE + 1) + Constants.MIN_VALUE);

        hab.setWindSpeed(Math.random() * (Constants.MAX_WIND - Constants.MIN_VALUE + 1) + Constants.MIN_VALUE);
        hab.setAirPressure(Math.random() * (Constants.MAX_PRESSURE - Constants.MIN_PRESSURE + 1) + Constants.MIN_PRESSURE);
        hab.setAirTemperature(Math.random() * (Constants.MAX_TEMP - Constants.MIN_TEMP + 1) + Constants.MIN_TEMP);
        double minus = 0;
        for (int indexElem = 0; indexElem < 9; indexElem++)
        {
            //minus = Math.random() * (sum - Constants.MIN_VALUE  ) + Constants.MIN_VALUE;
            //minus = (Math.random() * (Constants.compositionValues[indexElem] + Constants.DIFF )) + Constants.DIFF;
            minus = (Constants.compositionValues[indexElem] ) ;
            hab.setOneElemAirComposition(minus, indexElem);
            //sum -= minus;

        }
        /*
        int summ = 0;
        for(int i = 0; i < hab.getAirComposition().length; i++)
        {
            summ += hab.getOneElemAirComposition(i);
        }

        if(summ <= 100)
        {
            hab.setOneElemAirComposition(100-summ,8 );
        }
        else
        {
            //hab.setOneElemAirComposition(-100+summ,8 );
        }
*/
        System.out.println("fiecare" + hab.getOneElemAirComposition(8));

        System.out.println("suma lor" + Arrays.toString( hab.getAirComposition()));


        String req1 = "https://pp-2103241556kr.devportal.ptc.io:443/Thingworx/Things/hab1/Properties/<YOUR_PROPERTY_NAME>?method=PUT&value=" + hab.getCurrentDatetime() +
                "&appKey=ff0a6265-791c-45f7-a567-5d3d3b1e42d9 &x-thingworx-session=true";

        String req2 = "https://pp-2103241556kr.devportal.ptc.io:443/Thingworx/Things/hab1/Properties/<YOUR_PROPERTY_NAME>?method=PUT&value=" + hab.getCurrentAltitude() +
                "&appKey=ff0a6265-791c-45f7-a567-5d3d3b1e42d9 &x-thingworx-session=true";

        String req3 = "https://pp-2103241556kr.devportal.ptc.io:443/Thingworx/Things/hab1/Properties/<YOUR_PROPERTY_NAME>?method=PUT&value=" + hab.getCurrentLatitude() +
                "&appKey=ff0a6265-791c-45f7-a567-5d3d3b1e42d9 &x-thingworx-session=true";
        String req4 = "https://pp-2103241556kr.devportal.ptc.io:443/Thingworx/Things/hab1/Properties/<YOUR_PROPERTY_NAME>?method=PUT&value=" + hab.getCurrentLongitude() +
                "&appKey=ff0a6265-791c-45f7-a567-5d3d3b1e42d9 &x-thingworx-session=true";
        String req5 = "https://pp-2103241556kr.devportal.ptc.io:443/Thingworx/Things/hab1/Properties/<YOUR_PROPERTY_NAME>?method=PUT&value=" + hab.getCurrentSpeed() +
                "&appKey=ff0a6265-791c-45f7-a567-5d3d3b1e42d9 &x-thingworx-session=true";
        String req6 = "https://pp-2103241556kr.devportal.ptc.io:443/Thingworx/Things/hab1/Properties/<YOUR_PROPERTY_NAME>?method=PUT&value=" + hab.getWindSpeed() +
                "&appKey=ff0a6265-791c-45f7-a567-5d3d3b1e42d9 &x-thingworx-session=true";
        String req7 = "https://pp-2103241556kr.devportal.ptc.io:443/Thingworx/Things/hab1/Properties/<YOUR_PROPERTY_NAME>?method=PUT&value=" + hab.getAirPressure() +
                "&appKey=ff0a6265-791c-45f7-a567-5d3d3b1e42d9 &x-thingworx-session=true";
        String req8 = "https://pp-2103241556kr.devportal.ptc.io:443/Thingworx/Things/hab1/Properties/<YOUR_PROPERTY_NAME>?method=PUT&value=" + hab.getAirTemperature() +
                "&appKey=ff0a6265-791c-45f7-a567-5d3d3b1e42d9 &x-thingworx-session=true";



        // trimitere

    }
}
