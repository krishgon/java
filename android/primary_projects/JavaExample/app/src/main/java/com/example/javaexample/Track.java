package com.example.javaexample;

public class Track {
    private String name;
    private String intructor;

    Track(String name, String instructor){
        this.name = name;
        this.intructor = instructor;
    }

    public String getName(){
        return name;
    }

    public String getIntructor(){
        return intructor;
    }
}