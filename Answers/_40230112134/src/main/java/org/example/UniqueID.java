package org.example;

import java.util.Random;

public abstract class UniqueID {
    public static int getID()
    {
        Random randomnumber = new Random();
        return randomnumber.nextInt(100) + 1;
    }
}
