package com.example.bookscatalog.entities;

import com.example.bookscatalog.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book {
    public  enum  Categories{
        Historic,
        Thriller,
        Fantasy
    }

    private String Title;
    private String Category ;
    private String Description ;
    private String Link;
    private int Thumbnails;
    private int Pages ;

    public Book() {
    }

    public Book(String title, String category, String description, int thumbnails, int pages, String link) {
        Title = title;
        Category = category;
        Description = description;
        Thumbnails = thumbnails;
        Pages = pages;
        Link = link;
    }


    public String getTitle() {
        return Title;
    }

    public String getCategory() {
        return Category;
    }

    public String getDescription() {
        return Description;
    }

    public int getPages() {
        return Pages;
    }

    public int getThumbnails() {
        return Thumbnails;
    }

    public String getLink() {
        return Link;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setPages(int pages) {
        Pages = pages;
    }

    public void setThumbnails(int thumbnails) { Thumbnails = thumbnails; }

    public void setLink(String link) {
        Link = link;
    }

    public static List<Book> books = new ArrayList<>(Arrays.asList(
        new Book("The Vegetarian",Categories.Thriller.name(),"Description book",R.drawable.vegetarian_cover, 100, "https://www.goodreads.com/book/show/25489025-the-vegetarian"),
        new Book("Game Of Thrones",Categories.Fantasy.name(),"Description book",R.drawable.game_of_thrones, 150, "https://www.goodreads.com/book/show/13496.A_Game_of_Thrones"),
        new Book("Percy Jackson",Categories.Fantasy.name(),"Description book",R.drawable.percy_jackson, 300, "https://www.goodreads.com/book/show/28187.The_Lightning_Thief"),
        new Book("An ember in the ashes",Categories.Fantasy.name(),"Description book",R.drawable.ember_cover, 280, "https://www.goodreads.com/book/show/27774758-an-ember-in-the-ashes"),
        new Book("Atlas shrugged",Categories.Historic.name(),"Description book",R.drawable.atlas, 450, "https://www.goodreads.com/book/show/662.Atlas_Shrugged"),
        new Book("To kill a mockingbird",Categories.Historic.name(),"Description book",R.drawable.mockingbird, 320, "https://www.goodreads.com/book/show/2657.To_Kill_a_Mockingbird"),
        new Book("The catcher in the rye",Categories.Historic.name(),"Description book",R.drawable.catcher_in_the_rye, 380, "https://www.goodreads.com/book/show/5107.The_Catcher_in_the_Rye"),
        new Book("The lord of the rings",Categories.Fantasy.name(),"Description book",R.drawable.lord_rings, 1200, "https://www.goodreads.com/book/show/33.The_Lord_of_the_Rings"),
        new Book("The Hobbit",Categories.Fantasy.name(),"Description book",R.drawable.hobbit, 500, "https://www.goodreads.com/book/show/5907.The_Hobbit_or_There_and_Back_Again"),
        new Book("Metro 2033",Categories.Thriller.name(),"Description book",R.drawable.metro, 420, "https://www.goodreads.com/book/show/17274667-metro-2033"),
        new Book("Земя за прицел",Categories.Historic.name(),"Description book",R.drawable.land, 390, "https://www.goodreads.com/book/show/8031623"),
        new Book("IT",Categories.Thriller.name(),"Description book",R.drawable.it_book, 520, "https://www.goodreads.com/book/show/830502.It")));
}
