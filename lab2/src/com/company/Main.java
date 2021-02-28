package com.company;

public class Main {

    public static void main(String[] args) {

        Warehouse s1=new Warehouse("Sursa1");
        Warehouse s2=new Warehouse("Sursa2");
        Warehouse s3=new Warehouse("Sursa3");
        Destination d1=new Destination("Destinatia1");
        Destination d2=new Destination("Destinatia2");
        Destination d3=new Destination("Destinatia3");

        Source sources[]={s1,s2,s3};
        Destination desti[]={d1,d2,d3};
        int demands[]={20,25,25};
        int supplys[]={10,35,25};
        int cost[][]={{2,3,1},{5,4,8},{5,6,8}};

        //Optional solve with my own method
        Problem problema=new Problem();
        problema.setSources(sources);
        problema.setDestinations(desti);
        problema.setDemand(demands);
        problema.setSupply(supplys);
        problema.setCost(cost);
        System.out.println(problema.toString());
        problema.afisareCost();
        System.out.println("costul este: " + problema.solution());

        //Bonus-Solve with the Vogel's approximation method
        int demands1[]={250,350,400,200};
        int supplys1[]={300,400,500};
        int cost1[][]={{3,1,7,4},{2,6,5,9},{8,3,3,2}};
        Problem problema1=new Problem();
        problema1.setDemand(demands1);
        problema1.setSupply(supplys1);
        problema1.setCost(cost1);
        System.out.println(problema1.toString());
        problema1.afisareCost();
        System.out.println("costul este: " + problema1.VoguelSolution());
    }
}
