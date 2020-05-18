package com.java.java8;

public class Movie {
	private String movieName;
	private long duration;
	private String genre;

	public Movie(String movieName, long duration) {
		super();
		this.movieName = movieName;
		this.duration = duration;
	}

	public Movie(String movieName, String genre) {
		this.movieName = movieName;
		this.genre = genre;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Movie [movieName=" + movieName + ", duration=" + duration + ", genre=" + genre + "]";
	}

}
