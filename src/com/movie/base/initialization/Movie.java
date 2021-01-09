package com.movie.base.initialization;

public class Movie {

    String movieName;
    String movieDuration;
    String movieReleaseYear;

    public Movie(String movieName, String movieDuration, String movieReleaseYear) {
        this.movieName = movieName;
        this.movieDuration = movieDuration;
        this.movieReleaseYear = movieReleaseYear;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDuration() {
        return movieDuration;
    }

    public void setMovieDuration(String movieDuration) {
        this.movieDuration = movieDuration;
    }

    public String getMovieReleaseYear() {
        return movieReleaseYear;
    }

    public void setMovieReleaseYear(String movieReleaseYear) {
        this.movieReleaseYear = movieReleaseYear;
    }
}
