package com.example.cinema_lab.services;

import com.example.cinema_lab.models.Movie;
import com.example.cinema_lab.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public MovieService(){

    }

    public String saveMovie(Movie movie){
        movieRepository.save(movie);
        return "movie saved in db";
    }

    public Optional<Movie> getMovieById(long id){
        return movieRepository.findById(id);
    }

    public String getAllMovies(){
        List<Movie> movies = movieRepository.findAll();
        for (Movie movie : movies){
            System.out.println(movie.getTitle());
        }
        return "movie saved in db";
    }
}
