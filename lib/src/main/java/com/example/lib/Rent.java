package com.example.lib;

import java.time.LocalDate;

public class Rent {
    public String getReservedBookid() {
        return reservedBookid;
    }

    public void setReservedBookid(String reservedBookid) {
        this.reservedBookid = reservedBookid;
    }

    public String getReserveUserId() {
        return reserveUserId;
    }

    public void setReserveUserId(String reserveUserId) {
        this.reserveUserId = reserveUserId;
    }

    public String getRentId() {
        return rentId;
    }

    public void setRentId(String rentId) {
        this.rentId = rentId;
    }

    public LocalDate getRentDate() {
        return rentDate;
    }

    public void setRentDate(LocalDate rentDate) {
        this.rentDate = rentDate;
    }

    private String reservedBookid,reserveUserId,rentId;
    private LocalDate rentDate ;
}
