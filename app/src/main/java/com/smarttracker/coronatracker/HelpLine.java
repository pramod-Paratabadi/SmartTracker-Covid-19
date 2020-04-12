package com.smarttracker.coronatracker;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HelpLine extends AppCompatActivity {
    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpline);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HelpLine.this, MainActivity.class);
                startActivity(intent);
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new MoviesAdapter(movieList);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Movie movie = movieList.get(position);
                Toast.makeText(getApplicationContext(), movie.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + movie.getGenre()));
                startActivity(i);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        prepareMovieData();
    }

    /**
     * Prepares sample data to provide data set to adapter
     */
    private void prepareMovieData() {
        Movie movie = new Movie("Andhra Pradesh", "0866-2410978");
        movieList.add(movie);

        movie = new Movie("Arunachal Pradesh", "9536055743");
        movieList.add(movie);
        movie = new Movie("Assam", "6913347770");
        movieList.add(movie);
        movie = new Movie("Bihar", "104");
        movieList.add(movie);
        movie = new Movie("Chhattisgarh", "077122-35091");
        movieList.add(movie);
        movie = new Movie("Goa", "104");
        movieList.add(movie);
        movie = new Movie("Gujarat", "6913347770");
        movieList.add(movie);
        movie = new Movie("Haryana", "8558893911");
        movieList.add(movie);
        movie = new Movie("Himachal Pradesh", "104");
        movieList.add(movie);
        movie = new Movie("Jharkhand", "104");
        movieList.add(movie);
        movie = new Movie("Karnataka", "104");
        movieList.add(movie);
        movie = new Movie("Kerala", "0471-2552056");
        movieList.add(movie);
        movie = new Movie("Haryana", "8558893911");
        movieList.add(movie);
        movie = new Movie("Madhya Pradesh", "0755-2527177");
        movieList.add(movie);
        movie = new Movie("Maharashtra", "020-26127394");
        movieList.add(movie);
        movie = new Movie("Manipur", "3852411668");
        movieList.add(movie);
        movie = new Movie("Meghalaya", "9366090748");
        movieList.add(movie);
        movie = new Movie("Mizoram", "102");
        movieList.add(movie);
        movie = new Movie("Nagaland", "7005539653");
        movieList.add(movie);
        movie = new Movie("Odisha", "9439994859");
        movieList.add(movie);
        movie = new Movie("Punjab", "104");
        movieList.add(movie);
        movie = new Movie("Rajasthan", "0141-2225624");
        movieList.add(movie);
        movie = new Movie("Sikkim", "104");
        movieList.add(movie);
        movie = new Movie("Tamil Nadu", "044-29510500");
        movieList.add(movie);
        movie = new Movie("Telangana", "104");
        movieList.add(movie);
        movie = new Movie("Tripura", "0381-2315879");
        movieList.add(movie);
        movie = new Movie("Uttarakhand", "104");
        movieList.add(movie);
        movie = new Movie("Uttar Pradesh", "18001805145");
        movieList.add(movie);
        movie = new Movie("West Bengal", "3323412600");
        movieList.add(movie);
        movie = new Movie("West Bengal", "3323412600");
        movieList.add(movie);
        movie = new Movie("West Bengal", "3323412600");
        movieList.add(movie);
        movie = new Movie("West Bengal", "3323412600");
        movieList.add(movie);
        mAdapter.notifyDataSetChanged();
    }
}