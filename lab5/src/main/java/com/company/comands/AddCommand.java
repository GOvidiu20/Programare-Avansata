package com.company.comands;

import com.company.clase.Catalog;
import com.company.clase.Item;

import java.io.IOException;

public class AddCommand extends Command{
    public void executee(Item item, Catalog catagol) throws IOException {
        catagol.add(item);
    }
}
