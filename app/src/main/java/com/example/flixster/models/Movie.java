package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    String posterPath;
    String title;
    String overview;

    public Movie(JSONObject json_movie) throws JSONException {
        posterPath = json_movie.getString("poster_path");
        title = json_movie.getString("title");
        overview = json_movie.getString("overview");
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
}
