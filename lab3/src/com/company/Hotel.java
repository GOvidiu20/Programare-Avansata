package com.company;
import java.time.LocalTime;

public class Hotel extends Location implements Visitable, Classifiable{
    private LocalTime openingTime, closingTime;
    private double stars;
    @Override
    public LocalTime getOpeningTime() {
        return openingTime;
    }
    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }
    @Override
    public LocalTime getClosingTime() {
        return closingTime;
    }
    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }
    @Override
    public double getStars() {
        return 0;
    }
    public void setStars(double stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name=" + this.getName() +
                ", openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                ", stars=" + stars +
                '}';
    }
}
