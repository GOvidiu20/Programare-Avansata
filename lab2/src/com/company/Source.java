package com.company;

public class Source {
    private sourceTypes type;
    private String name;
    private int supply;
    static public int[] Sources=new int[10];
    static public int numberSources=0;
    public Source(sourceTypes type, String name, int supply) {
        this.type = type;
        this.name = name;
        this.supply = supply;
        Sources[numberSources++]=supply;
    }

    public sourceTypes getType() {
        return type;
    }

    public void setType(sourceTypes type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSupply() {
        return supply;
    }

    public void setSupply(int supply) {
        this.supply = supply;
    }

    @Override
    public String toString(){
        String s= "Name:" + this.name + " Type:" + this.type + " Supply:" +this.supply;
        return s;
    }
}
