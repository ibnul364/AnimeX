package com.imtiaz.animez.Retrofit;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.imtiaz.animez.Listeners.OnSearchApiListener;
import com.imtiaz.animez.Models.MovieSearchResponse;
import com.imtiaz.animez.Models.PopularMovie;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiController {
    Context mContext;
    private static ApiController controller;
    private static Retrofit retrofit;

    public ApiController(Context mContext){
        this.mContext = mContext;
    }

    ApiController(){
        //Retrofit Object Creation
        retrofit = new Retrofit.Builder()
                .baseUrl(ApiEndpoint.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized ApiController getInstance(){
        if(controller == null){
            controller = new ApiController();
        }
        return controller;
    }

    public  MoviesApi movieApi(){
        return retrofit.create(MoviesApi.class);
    }

    public  MoviesApi getMovieApiByID(){
        return retrofit.create(MoviesApi.class);
    }


//    public void searchMovies(OnSearchApiListener listener){
//
//        Call<MovieSearchResponse> responseCall = ApiController.
//                                                 getInstance().
//                                                  movieApi().
//                                                  searchMovie(
//                                                          ApiEndpoint.API_KEY,
//                                                          "Jack Reacher",
//                                                          1);
//
//        responseCall.enqueue(new Callback<MovieSearchResponse>() {
//            @Override
//            public void onResponse(Call<MovieSearchResponse> call, Response<MovieSearchResponse> response) {
//                if(response.code() == 200){
//                    Toast.makeText(mContext, "Hellow", Toast.LENGTH_SHORT).show();
//                }
////                    Log.v("Tag","the response"+response.body().toString());
////
////                    List<PopularMovie> movies = new ArrayList<>(response.body().getMovies());
////
////                    for(PopularMovie movie : movies){
////                        Log.v("Tag","Movie Name:  "+movie.getVote_average());
////                    }
////
////                }
////                else{
////                    try{
////                        Log.v("Tag","the Error"+response.errorBody().string());
////                    }catch(Exception e){
////                        e.printStackTrace();
////                    }
////                }
//            }
//
//            @Override
//            public void onFailure(Call<MovieSearchResponse> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });
//
//    }






}
