package com.company;
import java.time.LocalTime;

public class Museum extends Location implements Visitable, Payable, Classifiable {
    private LocalTime openingTime, closingTime;
    private double ticketPrice,stars;
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
    public double getTicketPrice() {
        return ticketPrice;
    }
    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
    @Override
    public double getStars() {
        return stars;
    }
    public void setStars(double stars) {
        this.stars = stars;
    }
    @Override
    public String toString() {
        return "Museum{" +
                "name=" + this.getName() +
                ", openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                ", ticketPrice=" + ticketPrice +
                ", stars=" + stars +
                '}';
    }
}