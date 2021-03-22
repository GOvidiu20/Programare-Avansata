package com.company.comands;

import com.company.clase.Catalog;

import java.io.IOException;

public abstract class Command {
    public void execute(String param, Catalog catalog) throws IOException{};
}
