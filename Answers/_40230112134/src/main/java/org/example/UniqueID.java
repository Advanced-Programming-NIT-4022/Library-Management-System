package org.example;

import java.util.Random;

public abstract class UniqueID {
    private int UniqueID ;
    public UniqueID(){
        this.UniqueID = 0;
    }

    public String getUniqueID() {
        int IDID = this.UniqueID;
        this.UniqueID ++;
        return String.valueOf(IDID);
    }
}
