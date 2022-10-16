package com.helbiz.helbizassignment.model;

public class Report {

    private final String name;
    private final String phoneNumber;
    private final String country;

    public Report(String name, String phoneNumber, String country) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.country = country;
    }

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", country='" + country + '\'';
    }
}
