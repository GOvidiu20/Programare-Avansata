package com.company.comands;

import com.company.clase.Catalog;

import java.io.IOException;

public class ListCommand extends Command {
    @Override
    public void execute(String param, Catalog catalog) throws IOException {
        catalog.show();
    }
}
