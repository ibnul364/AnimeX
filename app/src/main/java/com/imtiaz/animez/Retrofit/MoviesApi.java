package com.imtiaz.animez.Retrofit;

import com.imtiaz.animez.Models.MovieSearchResponse;
import com.imtiaz.animez.Models.PopularMovie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MoviesApi {

    //search for movies = https://api.themoviedb.org/3/search/movie?api_key={api_key}&query=Jack+Reacher
    @GET("3/search/movie")
    Call<MovieSearchResponse> searchMovie(
            @Query("api_key") String key,
            @Query("query") String query,
            @Query("page") int page
    );


    //Making Search With ID = https://api.themoviedb.org/3/movie/550?api_key=4ca9a44da5583294c7fc37c3a9836c75

    @GET("3/movie/{movie_id}?")
    Call<PopularMovie> getMovie(
            @Path("movie_id") int movie_id,
            @Query("api_key") String api_key
    );

}


