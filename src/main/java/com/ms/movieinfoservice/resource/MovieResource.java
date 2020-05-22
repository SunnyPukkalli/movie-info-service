package com.ms.movieinfoservice.resource;


import com.ms.movieinfoservice.model.Movie;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/movies/")
public class MovieResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId){

        // return Random Movie Details
        String movieName = RandomStringUtils.randomAlphabetic(5);
        String description = RandomStringUtils.randomAlphabetic(10);

        return new Movie(movieId,movieName,description);
    }

}
