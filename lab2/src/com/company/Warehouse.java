package com.company;

import java.util.Objects;

public class Warehouse extends Source{
    private String name;

    public Warehouse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Warehouse warehouse = (Warehouse) o;
        return Objects.equals(name, warehouse.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
