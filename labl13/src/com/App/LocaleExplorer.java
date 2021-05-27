package com.App;

import com.Commands.DisplayLocales;
import com.Commands.Info;
import com.Commands.SetLocale;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LocaleExplorer {

    public static Locale locale;
    public static void main(String[] args){
        locale=Locale.getDefault();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("com.res.Messages",locale);

        Scanner scanner=new Scanner(System.in);
        while(true){
            System.out.println(resourceBundle.getString("prompt"));
            String[] command = scanner.nextLine().split(" ");
            switch (command[0]){
                case "locales" : {
                    System.out.println(resourceBundle.getString("locales"));
                    DisplayLocales.display();
                    break;
                }
                case "localSet" :{
                    System.out.println(resourceBundle.getString("locale.set"));
                    SetLocale.setLocale(command[1]);
                    break;
                }
                case "info" :{
		    System.out.println(resourceBundle.getString("info"));
                    Info.getCurrentLocaleInfo();
                    break;
                }
                default:
                    System.out.println(resourceBundle.getString("invalid"));
            }
        }
    }
}
