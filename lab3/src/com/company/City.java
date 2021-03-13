package com.company;
import java.util.*;

public class City {
    private List<Location> nodes = new ArrayList<>();
    public City(){}
    public City(List<Location> nodes) {
        this.nodes = nodes;
    }
    public List<Location> getNodes() {
        return nodes;
    }
    public void setNodes(List<Location> nodes) {
        this.nodes = nodes;
    }
    public void addLocation(Location node) {
        nodes.add(node);
    }
    public void displyLocation(){
        List<Location> n = new ArrayList<>();
        for(Location x : nodes) {
            Visitable y=(Visitable) x;
            if(x instanceof Payable){
                if(y.getOpeningTime()!=null && ((Payable) x).getTicketPrice()==0)
                    n.add(x);
                }
        }
        n.sort(Location::compareTo);
        System.out.println(n);
    }

    @Override
    public String toString() {
        return "City{" +
                "nodes=" + nodes +
                '}';
    }
}
