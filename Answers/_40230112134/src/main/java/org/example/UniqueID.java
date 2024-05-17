package org.example;

import java.util.Random;

public class UniqueID {
    Random random = new Random();
    private int UniqueID = random.nextInt(1000) + 1;
    public String getUniqueIDString() {
        return String.valueOf(this.UniqueID);
    }
    public int getUniqueIDInt() {
        return this.UniqueID;
    }
    public void setUniqueID(int uniqueID) {
        this.UniqueID = uniqueID + 1;
    }
}