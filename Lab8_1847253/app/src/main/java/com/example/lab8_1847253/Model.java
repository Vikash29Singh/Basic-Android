package com.example.lab8_1847253;

public class Model {

    private String title, genre, year, rating;
    int image;
    boolean colored;

    public Model() {
    }

    public Model(String title, String genre, String year, String rating,int image, boolean colored) {

        this.colored = colored;

        this.title = title;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
        this.image = image;
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

    public int getImage(){
        return image;
    }

    public void setImage(int image){
        this.image = image;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
