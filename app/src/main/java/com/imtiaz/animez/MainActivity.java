package com.imtiaz.animez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.imtiaz.animez.Listeners.OnSearchApiListener;
import com.imtiaz.animez.Models.MovieSearchResponse;
import com.imtiaz.animez.Models.PopularMovie;
import com.imtiaz.animez.Retrofit.ApiController;
import com.imtiaz.animez.Retrofit.ApiEndpoint;
import com.imtiaz.animez.Retrofit.MoviesApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetRetrofitResponse();
            }
        });
    }

//    private  final OnSearchApiListener onSearchApiListener = new OnSearchApiListener() {
//
//
//        @Override
//        public void onResponse(MovieSearchResponse response) {
//            if(response == null){
//                Toast.makeText(MainActivity.this, "No Data is Available", Toast.LENGTH_SHORT).show();
//                return;
//            }
//            showResult(response);
//        }
//
//        @Override
//        public void onError(String message) {
//            Toast.makeText(MainActivity.this, "An Error has been occurred", Toast.LENGTH_SHORT).show();
//
//        }
//    };
//
//    private void showResult(MovieSearchResponse response) {
//        List<PopularMovie> movies = new ArrayList<>(response.getMovies());
//        for(PopularMovie movie : movies) {
////            Log.v("Tag", "Movie Name:  " + movie.getVote_average());
//            btn.setText(movie.getTitle());
//        }
//
//    }
    private void GetRetrofitResponse() {
        MoviesApi movieApi = ApiController.getInstance().movieApi();


        Call<MovieSearchResponse> responseCall = movieApi.searchMovie(
                ApiEndpoint.API_KEY,
                "Jack Reacher",
                1);

        responseCall.enqueue(new Callback<MovieSearchResponse>() {
            @Override
            public void onResponse(Call<MovieSearchResponse> call, Response<MovieSearchResponse> response) {
                if (response.code() == 200) {
                    Log.v("Tag", "the response" + response.body().toString());

                    List<PopularMovie> movies = new ArrayList<>(response.body().getMovies());

                    for (PopularMovie movie : movies) {
                        Log.v("Tag", "Movie Name:  " + movie.getVote_average());
                    }

                } else {
                    try {
                        Log.v("Tag", "the Error" + response.errorBody().string());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieSearchResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }




}