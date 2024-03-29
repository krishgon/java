package com.krishapps.sqlitedb;

public class Student {
    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getIncrement() {
        return increment;
    }

    public void setIncrement(double increment) {
        this.increment = increment;
    }

    public Student(int sno, String name, double increment) {
        this.sno = sno;
        this.name = name;
        this.increment = increment;
    }

    private int sno;
    private String name;
    private double increment;
}
