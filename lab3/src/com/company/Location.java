package com.company;
import java.util.*;

public abstract class Location implements Comparable<Location>
{
    private String name;
    private Map<Location, Integer> cost = new HashMap<>();
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Map<Location, Integer> getCost() {
        return cost;
    }
    public void setCost(Map<Location, Integer> cost) {
        this.cost = cost;
    }
    public void setCost(Location node, int value) {
        cost.put(node, value);
    }
    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
    @Override
    public int compareTo(Location other) {
        return this.name.compareTo(other.name);
        //not safe, check if name is null before
    }
}
