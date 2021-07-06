package com.example.jsondemoapplication;

import java.util.ArrayList;

public class DataModel {
    String title;
    int image;
    double rating;
    int releaseYear;
    ArrayList<String> genre;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }

//    public DataModel(String title, int image, double rating, int releaseYear, ArrayList<String> genre) {
//        this.title = title;
//        this.image = image;
//        this.rating = rating;
//        this.releaseYear = releaseYear;
//        this.genre = genre;
//    }

    public String getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }

    public double getRating() {
        return rating;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }
}
