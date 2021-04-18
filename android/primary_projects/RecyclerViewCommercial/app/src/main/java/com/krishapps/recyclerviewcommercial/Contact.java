package com.krishapps.recyclerviewcommercial;

public class Contact {
    private String sNo;
    private String phoneNo;
    private String name;

    public Contact(String sNo, String phoneNo, String name){
        this.sNo = sNo;
        this.phoneNo = phoneNo;
        this.name = name;
    }

    public String getsNo() {
        return sNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setsNo(String sNo) {
        this.sNo = sNo;
    }
}
