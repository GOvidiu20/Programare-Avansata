package com.company;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Desktop;
public class Catalog implements java.io.Serializable{
    private String name;
    private String path;
    List<Item> items=new ArrayList<>();

    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }
    public Catalog(){}
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public void add(Item x){
        items.add(x);
    }
    public void list(){
        for(Item x : items)
            System.out.println(x.getName());
    }
    public void play(){
        try {
            URI uri = new URI("http://www.java2s.com");
            Desktop desktop = null;
            if (Desktop.isDesktopSupported()) {
                desktop = Desktop.getDesktop();
            }

            if (desktop != null)
                desktop.browse(uri);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (URISyntaxException use) {
            use.printStackTrace();
        }
    }
    public Item findById(String id) {
        return items.stream()
                .filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }


}
