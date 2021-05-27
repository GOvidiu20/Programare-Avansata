package com.Commands;

import com.App.LocaleExplorer;

import java.util.Locale;
import java.util.ResourceBundle;

public class SetLocale {
    public static void setLocale(String tara){
        LocaleExplorer.locale=new Locale.Builder().setLocale(new Locale(tara)).build();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("com.res.Messages",LocaleExplorer.locale);
        System.out.println(LocaleExplorer.locale.getCountry());

    }

}
