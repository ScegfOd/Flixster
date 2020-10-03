package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Movie {
    String posterPath;
    String title;
    String overview;
    double popularity;
    double rating;
    int id;

    public Movie(){/*for Parcel library*/}

    public Movie(JSONObject json_movie) throws JSONException {
        posterPath = json_movie.getString("poster_path");
        title = json_movie.getString("title");
        overview = json_movie.getString("overview");
        popularity = json_movie.getDouble("popularity");
        rating = json_movie.getDouble("vote_average");
        id = json_movie.getInt("id");
    }

    public static List<Movie> from_JSON_array(JSONArray jsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            movies.add(new Movie(jsonArray.getJSONObject(i)));
        }
        return movies;
    }

    public String getPosterPath() {
        //TODO fetch sizes and pick correct one instead of hardcoding w342
        return String.format("https://image.tmdb.org/t/p/w342%s",posterPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public double getPopularity() {
        return popularity;
    }

    public double getRating() {
        return rating;
    }

    public int getId() {
        return id;
    }
}
