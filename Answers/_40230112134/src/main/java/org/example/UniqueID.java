package org.example;

public class UniqueID {
    static int UniqueID ;
    public UniqueID() {
        this.UniqueID = 0;
    }
    public static String getUniqueID() {
        int uniqueID = UniqueID;
        UniqueID ++;
        return String.valueOf(uniqueID);
    }
}