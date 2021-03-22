package com.company.comands;

import com.company.clase.Catalog;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadCommand extends Command {

    public void execute(String path, Catalog catalog) throws IOException {
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
    }
}
