package com.imtiaz.animez.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieSearchResponse {
    //this class is for getting multiple movies

    @SerializedName("total_results")
    @Expose()

    private int total_count ;


    @SerializedName("results")
    @Expose()

    private List<PopularMovie> movies;

    public int getTotal_count(){
        return total_count;
    }

    public List<PopularMovie> getMovies(){
        return movies;
    }


    @Override
    public String toString() {
        return "MovieSearchResponse{" +
                "total_count=" + total_count +
                ", movies=" + movies +
                '}';
    }
}
