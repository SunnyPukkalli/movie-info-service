package com.ms.movieinfoservice.resource;


import com.ms.movieinfoservice.model.Movie;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/movies/")
public class MovieResource {

    Logger logger = LoggerFactory.getLogger(MovieResource.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") Integer movieId){

        logger.info("Input Movie Id is :"+movieId);

        // return Random Movie Details
        Movie movie = new Movie(movieId,RandomStringUtils.randomAlphabetic(5),RandomStringUtils.randomAlphabetic(10)) ;
        logger.info("Returning Movie with Details :"+movie);

        return movie;
    }

}
