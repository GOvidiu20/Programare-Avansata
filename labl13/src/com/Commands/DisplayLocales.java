package com.Commands;

import java.util.Locale;

public class DisplayLocales {
    public static void display(){
        Locale available[] =
                Locale.getAvailableLocales();

        for(Locale locale : available) {
            System.out.println(locale.getDisplayCountry() + "\t" + locale.getDisplayLanguage(locale));
        }

    }
}
