package com.example.lab8_1847253;

public class Model {

    private String title, genre, year;
    boolean colored;

    public Model() {
    }

    public Model(String title, String genre, String year, boolean colored) {

        this.colored = colored;

        this.title = title;
        this.genre = genre;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
