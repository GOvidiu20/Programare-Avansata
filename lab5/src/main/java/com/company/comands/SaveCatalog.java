package com.company.comands;

import com.company.clase.Catalog;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveCatalog extends Command {
    @Override
    public void execute(String param, Catalog catalog) throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream(param);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(catalog);
            fos.close();
            out.close();
        }
        catch(java.io.IOException e){
            System.out.println("eroare la scriere");
        }
    }
}
