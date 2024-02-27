package com.example.cinema_lab.controllers;

import com.example.cinema_lab.models.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @GetMapping
    public ResponseEntity<String> getMovie(){

        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<String> getMovieById(@PathVariable long id){

        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> saveMovie(Movie movie){
        return new ResponseEntity<>("", HttpStatus.CREATED);
    }
}
