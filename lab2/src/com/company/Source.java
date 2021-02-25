package com.company;

import java.util.Objects;

public class Source {
    private sourceTypes type;
    private String name;
    public Source(sourceTypes type, String name) {
        this.type = type;
        this.name = name;
    }

    public sourceTypes getType() {
        return type;
    }

    public void setType(sourceTypes type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalAccessException {
        if(name==null)
            throw new IllegalAccessException("Null?");
        this.name = name;
    }

    @Override
    public String toString(){
        String s= "Name:" + this.name + " Type:" + this.type;
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Source source = (Source) o;
        return type == source.type && Objects.equals(name, source.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name);
    }
}
