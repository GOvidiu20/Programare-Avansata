package com.company;

public class Main {

    public static void main(String[] args) {
        Source s1=new Source(sourceTypes.FACTORY,"Sursa1");
        Source s2=new Source(sourceTypes.WAREHOUSE ,"Sursa2");
        Source s3=new Source(sourceTypes.WAREHOUSE,"Sursa3");
        Destination d1=new Destination("Destinatia1");
        Destination d2=new Destination("Destinatia2");
        Destination d3=new Destination("Destinatia3");

        Source sources[]={s1,s2,s3};
        Destination desti[]={d1,d2,d3};
        int demands[]={20,25,25};
        int supplys[]={10,35,25};
        int cost[][]={{2,3,1},{5,4,8},{5,6,8}};

        Problem problema=new Problem();
        problema.setSources(sources);
        problema.setDestinations(desti);
        problema.setDemand(demands);
        problema.setSupply(supplys);
        problema.setCost(cost);
        System.out.println(problema.toString());
        problema.afisareCost();
    }
}
