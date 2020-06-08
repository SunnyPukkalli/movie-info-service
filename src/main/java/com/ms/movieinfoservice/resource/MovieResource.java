package com.ms.movieinfoservice.resource;


import com.ms.movieinfoservice.model.ExternalMovieResponse;
import com.ms.movieinfoservice.model.Movie;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
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

    @GetMapping("/v1/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") Integer movieId){

        logger.info("Input Movie Id is :"+movieId);

        // return Random Movie Details
        Movie movie = new Movie(movieId, RandomStringUtils.randomAlphabetic(5),RandomStringUtils.randomAlphabetic(10)) ;
        logger.info("Returning Movie with Details :"+movie);

        return movie;
    }

    @Value("${api.key:default}")
    private String API_KEY ;

    @Value("${api.url:default}")
    private String EXTERNAL_API_URL ;

    private RestTemplate externalRestTemplate;

    @Qualifier("ExternalRestTemplate")
    @Autowired
    public void setExternalRestTemplate(RestTemplate externalRestTemplate) {
        this.externalRestTemplate = externalRestTemplate;
    }

    private Movie movie;

    @GetMapping("/v2/{movieId}")
    public Movie getExternalMovieInfo(@PathVariable("movieId") Integer movieId) {

        logger.info("Input Movie Id is :" + movieId);

        String externalURL = createExternalURL(movieId);

        logger.info("Calling External URL :"+externalURL);
        ExternalMovieResponse externalMovieResponse = externalRestTemplate.getForObject(externalURL, ExternalMovieResponse.class);

        logger.info("External API Response :"+externalMovieResponse.toString());
        movie = new Movie(movieId,externalMovieResponse.getTitle(),externalMovieResponse.getOverview());

        logger.info("Returning Response :"+movie.toString());
        return movie;
    }

    private String createExternalURL(Integer movieId) {
        logger.info("EXTERNAL_API_URL is :- "+EXTERNAL_API_URL +" and API_KEY is :- "+API_KEY);

        if(EXTERNAL_API_URL.contains("https")){
            return EXTERNAL_API_URL+movieId+"?api_key="+API_KEY;
        }else if(EXTERNAL_API_URL.contains("http")){
            return EXTERNAL_API_URL+API_KEY;
        }
        return null;
    }

}
