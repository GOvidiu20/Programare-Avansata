package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CatalogUtil {
    public static void save(Catalog catalog) {
        try {
            FileOutputStream fos = new FileOutputStream(catalog.getPath());
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(catalog);
            fos.close();
            out.close();
        }
        catch(java.io.IOException e){
            System.out.println("eroare la scriere");
        }
    }
    public static Catalog load(String path){
        Catalog catalog=new Catalog();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fis);
            catalog=(Catalog)in.readObject();
            in.close();
            fis.close();
        }
        catch(java.io.IOException e){
            System.out.println("Eroare la scriere");
        }
        catch(java.lang.ClassNotFoundException e){
            System.out.println("Class not found");
        }
        return catalog;
    }
    public static void view(Item x){
        x.Describe();
    }
}
