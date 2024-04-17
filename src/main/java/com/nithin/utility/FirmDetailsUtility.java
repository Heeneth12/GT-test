package com.nithin.utility;

import java.util.Random;

public class FirmDetailsUtility {

    public static long generateFirmId(){
        long min = 100000L;
        long max = 999999L;
        Random random = new Random();
        return min + ((long) (random.nextDouble() * (max - min)));
    }
}
