package com.company;
import java.lang.Math;
import java.util.Arrays;

public class Problem {
    private Source[] sources;
    private Destination[] destinations;

    private int supply[];
    private int demand[];
    private int cost[][];
    private int cost_maxim;

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

    public void setDemand(int[] demand) {
        this.demand = demand;
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
            for (j = 0; j < demand.length; j++)
                System.out.print(cost[i][j]+" ");
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

    //Optional
    private void makeCostMaxim(){
        int i,j;
        for(i=0;i< supply.length;i++)
            for(j=0;j<demand.length;j++)
                if(cost_maxim<cost[i][j])
                    cost_maxim=cost[i][j];
        cost_maxim++;
    }
    private int[] minim(){
        int i,j,x=0,y=0;
        int min=cost_maxim;
        for(i=0;i< supply.length;i++)
            for(j=0;j<demand.length;j++)
                if(min>cost[i][j]){
                    min=cost[i][j];
                    x=i;y=j;
                }
        int vec[]={x,y};
        return vec;
    }
    private void deleteLinie(int linie){
        int i;
        for(i=0;i< supply.length;i++)
            cost[linie][i]=cost_maxim;
    }
    private void deleteColoana(int coloana){
        int i;
        for(i=0;i< supply.length;i++)
            cost[i][coloana]=cost_maxim;
    }
    private int verificare(){
        for(int x : supply)
            if(x!=0)
                return 1;
        for(int x : demand)
            if(x!=0)
                return 1;
        return 0;
    }
    public int solution(){
        int i,j,linie,coloana,min[];
        int ok=1;
        int costul=0;
        makeCostMaxim();    //gasim costul maxim din matricea de costuri
        while(ok==1){
            min=this.minim();  //luam la fiecare pas linie si coloana celui mai mic cost ramas in matrice
            linie=min[0];
            coloana=min[1];
            if(supply[linie]<demand[coloana]) {     //daca supply ul este mai mic decat demand-ul,scadem din demand supply-ul,iar supply-ul devine 0
                demand[coloana]-= supply[linie];
                costul=costul+cost[linie][coloana]*supply[linie]; //la cost se va aduna supply-ul*costul
                supply[linie]=0;
                deleteLinie(linie); //linia va fi setata la costul maxim astfel incat sa nu mai putem reveni la ea
            }
            else
                if(supply[linie]>demand[coloana]){
                    supply[linie]-=demand[coloana];
                    costul=costul+cost[linie][coloana]*demand[coloana];
                    demand[coloana]=0;
                    deleteColoana(coloana);
                }
                else{
                    costul=costul+cost[linie][coloana]*supply[linie];
                    supply[linie]-=demand[coloana];
                    demand[coloana]-= demand[coloana];
                    deleteLinie(linie);
                    deleteColoana(coloana);
                }
            ok=verificare();  // se va incheia cand si demand-ul si supply-ul vor fi 0
        }
        return costul;
    }

    //Bonus
    private void eliminareLinie(int linie){
         int i,j;
         for(i=linie;i< supply.length-1;i++)
             for(j=0;j<demand.length;j++)
                 cost[i][j]=cost[i+1][j];
    }
    private void eliminareColoana(int coloana){
        int i,j;
        for(i=coloana;i< demand.length-1;i++)
           for(j=0;j< supply.length;j++)
               cost[j][i]=cost[j][i+1];
    }
    private int[] lowestValueOnLines(int n,int m){
        int array[]=new int[n];
        int i,j,min1,min2;
        for(i=0;i<n;i++) {
            min1=min2=cost_maxim;
            for (j = 0; j < m; j++)
                if(cost[i][j]<min1){
                    min2=min1;
                    min1=cost[i][j];
                }
                else
                    if(cost[i][j]<min2) {
                        min2 = cost[i][j];
                    }
            array[i]=min2-min1;
        }
        return array;
    }
    private int[] lowestValueOnColumns(int n,int m){
        int array[]=new int[m];
        int i,j,min1,min2;
        for(i=0;i<m;i++) {
            min1=min2=cost_maxim;
            for (j = 0; j < n; j++){
                if(cost[j][i]<min1){
                    min2=min1;
                    min1=cost[j][i];
                }
                else
                if(cost[j][i]<min2)
                    min2=cost[j][i];
            }
            array[i]=min2-min1;
        }
        return array;
    }
    private int maximumValueArray(int array[]){
        int maxim=array[0];
        for(int x : array)
            if(maxim<x)
                maxim=x;
        return maxim;
    }
    private void eliminateFromArray(int pozitie,int array[],int n){
        int i;
        for(i=pozitie;i<n-1;i++)
            array[i]=array[i+1];
    }
    public int VoguelSolution(){
        makeCostMaxim(); //gasim costul maxim in matricea de costuri
        int costul=0;
        int ok=1;
        int n,m,i,j;
        n= supply.length;
        m= demand.length;
        while(ok==1){
            int arrayLine[]=lowestValueOnLines(n,m);          // facem vectorul de diferente care va contine diferenta intre al doilea cel mai mic cost si cel
                                                              // mai mic cost de pe fiecare linie
            int arrayColumn[]=lowestValueOnColumns(n,m);      // -||- de pe fiecare coloana
            int maximLinii=maximumValueArray(arrayLine);      // cautam cea mai mare diferenta de pe fiecare linie
            int maximColoana=maximumValueArray(arrayColumn);  // coloana
            if(maximLinii>maximColoana) {                     // luam cea mai mare diferenta intre costuro de pe linie/coloana
                int linie=0,coloana=0;
                for (i = 0; i < arrayLine.length; i++)        // cautam linia si coloana pe care se afla cel mai mic cost de pe linii/coloane
                    if (maximLinii == arrayLine[i]) {
                        linie = i;
                        break;
                    }
                int minim=cost[linie][0];
                for(i=1;i<m;i++)
                    if(cost[linie][i]<minim){
                        minim=cost[linie][i];
                        coloana=i;
                    }
                if(supply[linie]<demand[coloana]){          // pentru cea mai mica valoare pe linie/coloana scadem demand ul/supply in functie de valoarea
                    demand[coloana]-=supply[linie];         // lor,si eliminam din matricea de costuri linia/coloana aferenta acelui cost
                    costul+=cost[linie][coloana]*supply[linie]; // totodata,stergem si din vectorii demand si supply valoarea daca cumva aceasta este 0
                    eliminateFromArray(linie,supply,n);         // in urma scaderii
                    eliminareLinie(linie);
                    n--;
                }
                else
                    if(supply[linie]>demand[coloana]){
                        supply[linie]-=demand[coloana];
                        costul+=cost[linie][coloana]*demand[coloana];
                        eliminateFromArray(coloana,demand,m);
                        eliminareColoana(coloana);
                        m--;
                    }
                    else{
                        costul+=cost[linie][coloana]*demand[coloana];
                        eliminateFromArray(linie,supply,n);
                        eliminateFromArray(coloana,demand,m);
                        eliminareColoana(coloana);
                        eliminareLinie(linie);
                        n--;m--;
                    }
            }
            else{
                int linie=0,coloana=0
                for (i = 0; i < arrayColumn.length; i++)
                    if (maximColoana == arrayColumn[i]) {
                        coloana = i;
                        break;
                    }
                int minim=cost[0][coloana];
                for(i=1;i<n;i++)
                    if(cost[i][coloana]<minim){
                        minim=cost[i][coloana];
                        linie=i;
                    }
                if(supply[linie]<demand[coloana]){
                    demand[coloana]-=supply[linie];
                    costul+=cost[linie][coloana]*supply[linie];
                    eliminateFromArray(linie,supply,n);
                    eliminareLinie(linie);
                    n--;
                }
                else
                if(supply[linie]>demand[coloana]){
                    supply[linie]-=demand[coloana];
                    costul+=cost[linie][coloana]*demand[coloana];
                    eliminateFromArray(coloana,demand,m);
                    eliminareColoana(coloana);
                    m--;
                }
                else{
                    costul+=cost[linie][coloana]*demand[coloana];
                    eliminateFromArray(coloana,supply,n);
                    eliminateFromArray(linie,demand,m);
                    eliminareColoana(coloana);
                    eliminareLinie(linie);
                    n--;m--;
                }
            }
            if(n==0 && m==0)        // programul se va oprii atunci cand atat vectorul de supply cat si cel de demand sunt liberi(acest lucru se intampla
                ok=0;               // in acelasi timp)
        }
        return costul;
    }
}
