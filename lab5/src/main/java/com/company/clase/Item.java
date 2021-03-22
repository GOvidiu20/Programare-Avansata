package com.company.clase;

public abstract class Item implements java.io.Serializable{
    private String name;
    private String location;
    private int stars;

    Item(){}
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPath() {
        return location;
    }
    public void setPath(String path) {
        this.location = path;
    }
    public int getStars() {
        return stars;
    }
    public void setStars(int stars) {
        this.stars = stars;
    }

    public void Describe(){
        System.out.println("Item{" +
                ", name='" + this.getName() + '\'' +
                ", location='" + this.getPath() + '\'' +
                ", stars=" + this.getStars() +
                '}');
    }
}
