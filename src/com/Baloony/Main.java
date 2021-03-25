package com.Baloony;
import java.util.Random;


public class Main {

    public static void main(String[] args) {
	    // generam cu random
        // 5 thread-uri
        //toate intr-un while cat timp merge aplicatia
        //trimitem datele prin JSON, REST API, catre thingworx

        //nume balon

        Random rand = new Random();

        HAB hab1 = new HAB("Joanne", "UX550","Bulbous balloon,");
        HAB hab2 = new HAB("Mario", "UX551","Diagonal gore");
        HAB hab3 = new HAB("Johnny", "UX552","Smooth gore envelope");
        HAB hab4 = new HAB("Estella", "UX553","Straight-cut gore");
        HAB hab5 = new HAB("Rocky", "UX554","Diagonal gore");

        MyThread[] t = new MyThread[5];

        for (int i = 0; i < 5; ++i) {
            t[i].start();
        }

        for(;;) // bucla infinita
        {


            for (int i = 0; i < 5; ++i) {
                try {
                    t[i].join();
                    System.out.println("Thread " + i + " computed result " + ((Task)t[i]).getResult() + ".");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
