package com.example.cinema_lab.services;

import com.example.cinema_lab.models.Movie;
import com.example.cinema_lab.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<Movie> getAllMovies(){
        List<Movie> movies = movieRepository.findAll();
        return movies;
    }

    public List<Movie> filterMoviesByDuration(Double maxDuration){
        List<Movie> movies = movieRepository.findAll();
        List<Movie> filteredMovie = new ArrayList<>();
        for (Movie movie: movies){
            if(movie.getDuration()<= maxDuration){
                filteredMovie.add(movie);
            }
        }
        return filteredMovie;
    }

    public Optional<Movie> updateMovieTitle(long id, String title){
        Optional<Movie> movie = movieRepository.findById(id);
        movie.get().setTitle(title);
        movieRepository.save(movie.get());
        return movie;
    }


    public void deleteMovie(long id){
        movieRepository.deleteById(id);
    }
}
