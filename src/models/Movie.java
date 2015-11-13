package models;

import java.util.HashMap;
import java.util.Map;

public class Movie 
{
	static Long   counter = 0l;

	public Long movieId;
	public String title;
	public String year;
	public String url;

	public Map<Long, Rating> ratings = new HashMap<>();

	public Movie()
	{
	}
	
	public Movie(String title, String year, String url)
	{
		this.movieId = counter++;
		this.title = title;
		this.year = year;
		this.url = url;
	}

}
