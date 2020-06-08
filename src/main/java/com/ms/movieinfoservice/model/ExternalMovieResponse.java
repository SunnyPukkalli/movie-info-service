package com.ms.movieinfoservice.model;

public class ExternalMovieResponse {

    private String title;
    private String overview;

    public ExternalMovieResponse() {
    }

    public ExternalMovieResponse(String title, String overview) {
        this.title = title;
        this.overview = overview;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
