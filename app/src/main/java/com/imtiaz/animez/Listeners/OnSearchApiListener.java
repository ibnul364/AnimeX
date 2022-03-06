package com.imtiaz.animez.Listeners;

import com.imtiaz.animez.Models.MovieSearchResponse;

public interface OnSearchApiListener {
    void onResponse(MovieSearchResponse response);
    void onError(String message);
}
