package com.company;

public abstract class Item implements java.io.Serializable{
    private String id;
    private String name;
    private String location;
    private int stars;

    Item(){}
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
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
        if(stars>5 || stars<0) throw new InvalidCatalogException(stars);
        this.stars = stars;
    }

    public void Describe(){
        System.out.println("Item{" +
                "id='" + this.getId() + '\'' +
                ", name='" + this.getName() + '\'' +
                ", location='" + this.getPath() + '\'' +
                ", stars=" + this.getStars() +
                '}');
    }
}
