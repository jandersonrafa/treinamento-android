package com.hedo.exemploconsumoretrofit.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.hedo.exemploconsumoretrofit.R;
import com.hedo.exemploconsumoretrofit.model.MovieDetail;
import com.hedo.exemploconsumoretrofit.model.MoviePreview;
import com.hedo.exemploconsumoretrofit.service.IMovieService;
import com.hedo.exemploconsumoretrofit.service.MovieService;

public class DetailMovieActivity extends AppCompatActivity {

    private TextView textView;

    private IMovieService movieService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        movieService = MovieService.getInstance();

        setContentView(R.layout.activity_detail_movie);
        this.initializaComponents();
        this.populate();
    }

    private void initializaComponents() {
        textView = findViewById(R.id.detail_movie_title);
    }

    private void populate() {
        MoviePreview moviePreview = (MoviePreview) getIntent().getSerializableExtra("teste");
        
        MovieDetail movieDetail = (MovieDetail) movieService.getMovieByImdbID(moviePreview.getImdbID());
        setTitle(moviePreview.getTitle());
        textView.setText("titulo teste");
    }

}
