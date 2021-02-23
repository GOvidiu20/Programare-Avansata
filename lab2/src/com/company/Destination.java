package com.company;

public class Destination {
    private String name;
    private int demand;
    static public int[] Destinations=new int[10];
    static public int numberDestinations=0;
    public Destination(String name, int demand) {
        this.name = name;
        this.demand = demand;
        Destinations[numberDestinations++]=demand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDemand() {
        return demand;
    }

    public void setDemand(int demand) {
        this.demand = demand;
    }

    @Override
    public String toString() {
        String s="Name:" + this.name + " Demand:" + this.demand;
        return s;
    }
}
