package com.imtiaz.animez.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieResponse {
    //This class is for single movie request
    //finding the movie object

    @SerializedName("results")
    @Expose
    private  PopularMovie movie;

    public PopularMovie getMovie() {
        return movie;
    }

    @Override
    public String toString() {
        return "MovieResponse{" +
                "movie=" + movie +
                '}';
    }
}
