package com.example.cinema_lab.controllers;

import com.example.cinema_lab.models.Movie;
import com.example.cinema_lab.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovie(){
        List<Movie> response = movieService.getAllMovies();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable long id){
        Optional<Movie> movie = movieService.getMovieById(id);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> saveMovie(@RequestBody Movie movie){
        movieService.saveMovie(movie);
        return new ResponseEntity<>("saved movie object", HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Optional<Movie>> updateMovieTitle(@PathVariable long id, @RequestBody String title){
        Optional<Movie>  movie = movieService.updateMovieTitle(id, title);
        return new ResponseEntity<>(movie,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable long id){
        movieService.deleteMovie(id);
        return new ResponseEntity<>("movie object deleted", HttpStatus.OK);
    }
}
