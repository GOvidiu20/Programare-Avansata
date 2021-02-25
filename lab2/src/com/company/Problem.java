package com.company;
import java.lang.Math;
import java.util.Arrays;

public class Problem {
    private Source[] sources;
    private Destination[] destinations;

    private int supply[];
    private int demand[];
    private int cost[][];

    public Source[] getSources() {
        return sources;
    }

    public void setSources(Source[] sources) {
        this.sources = sources;
    }

    public Destination[] getDestinations() {
        return destinations;
    }

    public void setDestinations(Destination[] destinations) {
        this.destinations = destinations;
    }

    public int[] getSupply() {
        return supply;
    }

    public void setSupply(int[] supply) {
        this.supply = supply;
    }

    public int[] getDemand() {
        return demand;
    }

    public void setDemand(int[] demandp) {
        this.demand = demandp;
    }

    public int[][] getCost() {
        return cost;
    }

    public void setCost(int[][] cost) {
        this.cost = cost;
    }
    public void afisareCost(){
        int i,j;
        for(i=0;i< supply.length;i++) {
            for (j = 0; j < supply.length; j++)
                System.out.print(cost[i][j]);
            System.out.println();
        }
    }
    @Override
    public String toString() {
        return "Problem{" +
                "sources=" + Arrays.toString(sources) +
                ", destinations=" + Arrays.toString(destinations) +
                ", supply=" + Arrays.toString(supply) +
                ", demand=" + Arrays.toString(demand) +
                '}';
    }
}
