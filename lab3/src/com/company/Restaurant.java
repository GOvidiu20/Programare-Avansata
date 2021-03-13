package com.company;
import java.time.LocalTime;

public class Restaurant extends Location implements Visitable, Classifiable{
    private LocalTime openingTime, closingTime;
    private double stars;
    @Override
    public LocalTime getOpeningTime() {
        return openingTime;
    }
    @Override
    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }
    @Override
    public LocalTime getClosingTime() {
        return closingTime;
    }
    @Override
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
        return "Restaurant{" +
                "name=" + this.getName() +
                ", openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                ", stars=" + stars +
                '}';
    }
}
