package org.example;

public class UniqueID {
    private int UniqueID = getUniqueIDINT();
    public String getUniqueID() {
        return String.valueOf(this.UniqueID);
    }
    public int getUniqueIDINT() {
        return this.UniqueID;
    }

    public void setUniqueID(int uniqueID) {
        this.UniqueID = uniqueID + 1;
    }
}