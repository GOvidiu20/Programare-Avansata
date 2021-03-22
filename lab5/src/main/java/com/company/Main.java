package com.company;

import com.company.clase.*;
import com.company.comands.*;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String args[])  throws IOException {
        Scanner scanner = new Scanner (System.in);
        Catalog catalog=new Catalog();
        Item song=new Song();
        Item book=new Book();
        while(true){
            System.out.println("Comanda noua: ");
            String commandName=scanner.next();
            if(commandName.equalsIgnoreCase("exit"))
                break;
            try {
                switch (commandName){
                    case "Save" : {
                        System.out.println("Path: ");
                        String path=scanner.next();
                        Command comanda = new SaveCatalog();
                        comanda.execute(path,catalog);
                        break;
                    }
                    case "Load" : {
                        System.out.println("Path: ");
                        String path=scanner.next();
                        Command comanda = new LoadCommand();
                        comanda.execute(path,catalog);
                        break;
                    }
                    case "Add" : {
                        System.out.println("Book/Song?");
                        String next=scanner.next();
                        System.out.println("Numele: ");
                        String name=scanner.next();
                        System.out.println("locatia: ");
                        String locatie= scanner.next();
                        System.out.println("Stars: ");
                        String stars = scanner.next();
                        if(next.equals("Book")){
                            book.setStars(Integer.parseInt(stars));
                            book.setPath(locatie);
                            book.setName(name);
                            AddCommand comanda = new AddCommand();
                            comanda.executee(book,catalog);
                        }
                        else{
                            song.setStars(Integer.parseInt(stars));
                            song.setPath(locatie);
                            song.setName(name);
                            AddCommand comanda = new AddCommand();
                            comanda.executee(song,catalog);
                        }
                        break;
                    }
                    case "List" :{
                        System.out.println("Ce sa afisez: ");
                        String next=scanner.next();
                        Command comanda = new ListCommand();
                        comanda.execute(next,catalog);

                    }
                }
            }
            catch(IOException e){
                System.err.println(e);
            }
        }
        Configuration configuration = new Configuration();
        try {
            configuration.setDirectoryForTemplateLoading(
                    new File(Main.class.getResource("/templates").toURI()));

            Template template = configuration.getTemplate("template.ftl");
            Writer writer = new OutputStreamWriter(System.out);
            template.process(catalog.findByName("book1"), writer);
        }
        catch (java.net.URISyntaxException e){
            System.err.println(e);
        }
        catch (freemarker.template.TemplateException e){
            System.err.println(e);
        }
    }

    private void testCreateSave() {
        Catalog catalog = new Catalog("My Books", "C:\\Users\\Ovidiu Gabor\\Desktop\\PA\\lab5\\fisier.txt");
        var song = new Song("bestSong","C:\\Users\\Ovidiu Gabor\\Desktop\\PA\\lab5\\items",5);
        var book = new Book("bestBook","C:\\Users\\Ovidiu Gabor\\Desktop\\PA\\lab5\\items",4);
        catalog.add(song);
        catalog.add(book);

        CatalogUtil.save(catalog);
    }
    private void testLoadView() {
        Catalog catalog = CatalogUtil.load("C:\\Users\\Ovidiu Gabor\\Desktop\\PA\\lab5\\fisier.txt");
        CatalogUtil.view(catalog.findByName("bestSong"));
    }
}