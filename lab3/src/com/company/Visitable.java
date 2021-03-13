package com.company;
import java.time.LocalTime;
import java.time.Duration;

public interface Visitable {
    LocalTime getOpeningTime();
    LocalTime getClosingTime();
    void setOpeningTime(LocalTime x);
    void setClosingTime(LocalTime x);
    default void setOpeningClosingTime(){
            this.setOpeningTime(LocalTime.parse("09:00"));
            this.setClosingTime(LocalTime.parse("20:00"));
        }
    static long getVisitingDuration(LocalTime openingTime,LocalTime closingTime){
        return Duration.between(openingTime,closingTime).toMinutes();
    }
}
