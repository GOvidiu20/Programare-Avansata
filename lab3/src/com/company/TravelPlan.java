package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class TravelPlan {
    private List<Location> nodes = new ArrayList<>();
    public List<Location> getNodes() {
        return nodes;
    }
    public void setNodes(List<Location> nodes) {
        this.nodes = nodes;
    }

    int minDistance(int dist[], int viz[]) {
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int i = 1; i < dist.length; i++)
            if (viz[i] == 0 && dist[i] <= min) {
                min = dist[i];
                min_index = i;
            }
        return min_index;
    }
    public int getPosition(String name){
        int x=1;
        for(Location loc : nodes){
            if(loc.getName().equals(name))
                return x;
            x++;
        }
        return 0;
    }
    public void Dijkstra(int[][] cost,String name1 ,String name2){
        int source=getPosition(name1) ;
        int destination=getPosition(name2);
        int distante[]=new int[cost.length];
        int vizitat[] =new int[cost.length];
        int dad[]=new int[cost.length];
        for (int i = 1; i < distante.length; i++) {
            distante[i] = Integer.MAX_VALUE;
            vizitat[i] = 0;
        }
        distante[source]=0;
        for (int count = 1; count < distante.length; count++){
            int min=minDistance(distante,vizitat);
            vizitat[min]=1;
            for(int i=1;i<distante.length;i++)
                if(vizitat[i]==0 && cost[min][i]!=0 && distante[min]!=Integer.MAX_VALUE && (distante[min]+cost[min][i])<distante[i]) {
                    distante[i] = distante[min] + cost[min][i];
                    dad[i]=min;
                }
        }
        if(distante[destination]==Integer.MAX_VALUE)
            System.out.println("Nu exista drum");
        else
            path(dad,destination);
    }
    private void path(int[] dad,int destination){
        if(dad[destination]!=0){
            path(dad,dad[destination]);
            int x=1;
            Location aux=null;
            for(Location loc : nodes) {
                if (x == destination) {
                    aux=loc;
                    break;
                }
                x++;
            }
            System.out.print("  ->  " + aux.getName());
        }
        else {
            int x=1;
            Location aux=null;
            for(Location loc : nodes) {
                if (x == destination) {
                    aux=loc;
                    break;
                }
                x++;
            }
            System.out.print(aux.getName());
        }
    }
}
