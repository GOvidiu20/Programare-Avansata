package com.company;

public class Main {
	public static void main(String args[]) {
		Main app = new Main();
		app.testCreateSave();
		app.testLoadView();
	}

	private void testCreateSave() {
		Catalog catalog =
				new Catalog("My Books", "C:\\Users\\Ovidiu Gabor\\Desktop\\PA\\lab5\\fisier.txt");
		var song = new Song("123","bestSong","C:\\Users\\Ovidiu Gabor\\Desktop\\PA\\lab5\\items",5);
		var book = new Book("124","bestBook","C:\\Users\\Ovidiu Gabor\\Desktop\\PA\\lab5\\items",4);
		catalog.add(song);
		catalog.add(book);

		CatalogUtil.save(catalog);
	}
	private void testLoadView() {
		Catalog catalog = CatalogUtil.load("C:\\Users\\Ovidiu Gabor\\Desktop\\PA\\lab5\\fisier.txt");
		CatalogUtil.view(catalog.findById("124"));
	}

}

