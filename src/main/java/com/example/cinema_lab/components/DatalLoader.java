package com.example.cinema_lab.components;

import com.example.cinema_lab.models.Movie;
import com.example.cinema_lab.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DatalLoader implements ApplicationRunner {
    @Autowired
    MovieService movieService;
    Movie movie = new Movie("Finding Nemo","PG13",260);
    Movie movie1 = new Movie("Harry Potter","PG13",260);
    Movie movie2 = new Movie("Home Alone","PG13",350);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        movieService.saveMovie(movie);
        movieService.saveMovie(movie1);
        movieService.saveMovie(movie2);
    }
}
