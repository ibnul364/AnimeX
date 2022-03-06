package com.imtiaz.animez.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class PopularMovie implements Parcelable
{
    private String overview;
    private String title;
    private String release_date;
    private String poster_path;
    private int id;
    private float vote_average;


    public PopularMovie(String overview, String title, String release_date, String poster_path, int id, float vote_average) {
        this.overview = overview;
        this.title = title;
        this.release_date = release_date;
        this.poster_path = poster_path;
        this.id = id;
        this.vote_average = vote_average;
    }

    protected PopularMovie(Parcel in) {
        overview = in.readString();
        title = in.readString();
        release_date = in.readString();
        poster_path = in.readString();
        id = in.readInt();
        vote_average = in.readFloat();
    }

    public static final Creator<PopularMovie> CREATOR = new Creator<PopularMovie>() {
        @Override
        public PopularMovie createFromParcel(Parcel in) {
            return new PopularMovie(in);
        }

        @Override
        public PopularMovie[] newArray(int size) {
            return new PopularMovie[size];
        }
    };

    public String getOverview() {
        return overview;
    }

    public String getTitle() {
        return title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public int getId() {
        return id;
    }

    public float getVote_average() {
        return vote_average;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(overview);
        parcel.writeString(title);
        parcel.writeString(release_date);
        parcel.writeString(poster_path);
        parcel.writeInt(id);
        parcel.writeFloat(vote_average);
    }
}
