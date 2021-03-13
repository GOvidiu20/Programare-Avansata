package com.company;
import java.time.LocalTime;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Hotel v1 = new Hotel();
        v1.setOpeningTime(LocalTime.of(7, 30));
        v1.setClosingTime(LocalTime.MIDNIGHT);
        v1.setName("Hotel");
        v1.setStars(3.5);

        Museum v2 = new Museum();
        v2.setOpeningTime(LocalTime.of(10, 30)); //9:30
        v2.setClosingTime(LocalTime.parse("19:00"));
        v2.setTicketPrice(0);
        v2.setName("Museum A");
        v2.setStars(2);

        Museum v3 = new Museum();
        v3.setOpeningTime(LocalTime.of(9, 30)); //9:30
        v3.setClosingTime(LocalTime.parse("17:00"));
        v3.setTicketPrice(0);
        v3.setName("Museum B");
        v3.setStars(5);

        Church v4 = new Church();
        v4.setOpeningTime(LocalTime.of(6, 0));
        v4.setClosingTime(LocalTime.MIDNIGHT);
        v4.setName("Church A");

        Church v5 = new Church();
        v5.setOpeningTime(LocalTime.of(7, 0));
        v5.setClosingTime(LocalTime.MIDNIGHT);
        v5.setName("Church B");

        Restaurant v6 = new Restaurant();
        v6.setClosingTime(LocalTime.of(22, 15));
        v6.setName("Restaurant");
        v6.setStars(4);

        v1.setCost(v2, 10);
        v1.setCost(v3, 50);
        v2.setCost(v3, 20);
        v2.setCost(v4, 20);
        v2.setCost(v5, 10);
        v3.setCost(v2, 20);
        v3.setCost(v4, 20);
        v4.setCost(v5, 30);
        v4.setCost(v6, 10);
        v5.setCost(v4, 30);
        v5.setCost(v6, 20);

        Location[] arr = {v1, v2, v3, v4, v5, v6};
        City city=new City();
        city.addLocation(v1);
        city.addLocation(v2);
        city.addLocation(v3);
        city.addLocation(v4);
        city.addLocation(v5);
        city.addLocation(v6);

        int[][] costuri = {{0,0,0,0,0,0,0},
                           {0,0,10,50,0,0,0},
                           {0,0,0,20,20,10,0},
                           {0,0,20,0,20,0,0},
                           {0,0,0,0,0,30,10},
                           {0,0,0,0,30,0,20},
                           {0,0,0,0,0,0,0}};
        TravelPlan x=new TravelPlan();
        x.setNodes(city.getNodes());
        x.Dijkstra(costuri,"Hotel","Restaurant");
    }
}
