package com.company;

public class Main {

    public static void main(String[] args) {
        Source s1=new Source(sourceTypes.FACTORY,"Sursa1",10);
        Source s2=new Source(sourceTypes.WAREHOUSE ,"Sursa2",35);
        Source s3=new Source(sourceTypes.WAREHOUSE,"Sursa3",25);
        Destination d1=new Destination("Destinatia1",20);
        Destination d2=new Destination("Destinatia2",25);
        Destination d3=new Destination("Destinatia3",25);
        System.out.println(s1.toString());
        System.out.println(s2.toString());
        System.out.println(s3.toString());
        System.out.println(d1.toString());
        System.out.println(d2.toString());
        System.out.println(d3.toString());
        Problem p=new Problem(Source.numberSources,Destination.numberDestinations);
        p.buildMatrix(Source.Sources,Destination.Destinations);
        p.afisareMatrix();
        p.rezolvare();
    }
}
