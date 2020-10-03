package com.example.flixster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.flixster.models.Movie;

import org.parceler.Parcels;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Movie movie = (Movie) Parcels.unwrap(getIntent().getParcelableExtra("movie"));
        ((TextView)findViewById(R.id.title)).setText(movie.getTitle());
        ((RatingBar)findViewById(R.id.ratingBar)).setRating((float)movie.getRating());
        ((TextView)findViewById(R.id.synopsis)).setText(movie.getOverview());
        ((TextView)findViewById(R.id.popularity)).setText("Popularity: " + movie.getPopularity());
    }
}