package com.example.talip.recyclerview;

public class City {

    String name;
    String population;
    String altitude;

    public City(String n, String p, String a){
        this.name = n;
        this.population = p;
        this.altitude = a;
    }

    public String getName() {
        return name;
    }

    public String getPopulation() {
        return population;
    }

    public String getAltitude() {
        return altitude;
    }
}
