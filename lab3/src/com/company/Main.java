package com.company;
import java.time.LocalTime;
public class Main {

    public static void main(String[] args) {
        Hotel v1 =new Hotel();
        v1.setOpeningTime(LocalTime.of(7,30));
        v1.setClosingTime(LocalTime.MIDNIGHT);
        v1.setName("Hotel");
        v1.setStars(3.5);

        Museum v2 = new Museum();
        v2.setOpeningTime(LocalTime.of(8, 30)); //9:30
        v2.setClosingTime(LocalTime.parse("19:00"));
        v2.setTicketPrice(15);
        v2.setName("Museum A");
        v2.setStars(2);

        Museum v3 = new Museum();
        v3.setOpeningTime(LocalTime.of(9, 30)); //9:30
        v3.setClosingTime(LocalTime.parse("17:00"));
        v3.setTicketPrice(20);
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

        Restaurant v6=new Restaurant();
        v6.setOpeningTime(LocalTime.parse("09:00"));
        v6.setClosingTime(LocalTime.of(22,15));
        v6.setName("Restaurant");
        v6.setStars(4);

        Location[] arr = {v1,v2,v3,v4,v5,v6};
        for(Location i : arr)
            System.out.println(i);
    }
}
