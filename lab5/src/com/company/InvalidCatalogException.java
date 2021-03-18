package com.company;

public class InvalidCatalogException extends RuntimeException{

    public InvalidCatalogException(int stars) {
        super("Invalid stars: "+ stars);
    }

}
