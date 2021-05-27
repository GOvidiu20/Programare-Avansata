package com.Commands;

import com.App.LocaleExplorer;

import java.text.DateFormatSymbols;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.time.temporal.WeekFields;
import java.util.Currency;
import java.util.Locale;

public class Info {
    public static void getCurrentLocaleInfo() {
        Locale locale = Locale.getDefault();
        System.out.println("Country: " + LocaleExplorer.locale.getCountry() + "\n" +
                "Language: " + LocaleExplorer.locale.getDisplayLanguage() + "\n" +
                "Currency: " + displayCurrencyInfoForLocale("RON") + "\n" +
                "Week Days: " + getDayString() + "\n" +
                "Months: " + getMonthsString() + "\n" +
                "Current day: "+ getDate()
        );
    }
    private static String getDayString() {

        String[] weekdays = new DateFormatSymbols().getWeekdays();
        String zile = new String();
        WeekFields weekFields=WeekFields.of(LocaleExplorer.locale);
        DayOfWeek day=weekFields.getFirstDayOfWeek();

        for (int i=0;i<DayOfWeek.values().length;i++) {
            zile += day.getDisplayName(TextStyle.FULL,LocaleExplorer.locale) + " ";
            day=day.plus(1);
        }
        return zile;
    }
    private static String getMonthsString() {
        String[] months = new DateFormatSymbols(LocaleExplorer.locale).getMonths();
        String luni = new String();
        for (String month : months) {
            luni += month += " ";
        }
        return luni;
    }
    public static String getDate(){
        LocalDate currentdate = LocalDate.now();
        int currentDay = currentdate.getDayOfMonth();
        Month currentMonth = currentdate.getMonth();
        int currentYear = currentdate.getYear();

        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.FULL)
                .withLocale(LocaleExplorer.locale);
        return currentMonth+" "+currentDay+", "+currentYear;
    }
    public static String displayCurrencyInfoForLocale(String ban) {
        Currency currency = Currency.getInstance(ban);
        return currency.getCurrencyCode();
    }
}
