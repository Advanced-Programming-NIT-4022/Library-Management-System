package org.example;

import java.util.Random;

public abstract class UniqueID {
    public static String getID()
    {
        Random randomnumber = new Random();
        return String.valueOf(randomnumber.nextInt(1000) + 1);
    }
}
