package com.example.lib;

public class User {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    private String name;
    private String number;
    private String Id;
    User(String name,String Number,String Id){
        this.name=name;
        this.number=number;
        this.Id=Id;
    }
}
