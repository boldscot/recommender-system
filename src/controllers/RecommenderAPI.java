package controllers;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import utils.Serializer;
import models.Movie;
import models.User;
import edu.princeton.cs.introcs.In;

public class RecommenderAPI implements RecommenderInterface
{
	private Serializer serializer;

	public static Map<Long, User> usersIndex = new HashMap<>();
	public static Map<Long, Movie> movies = new HashMap<>();

	public RecommenderAPI()
	{

	}

	public void createUser(String firstName, String lastName, 
			int age, String gender, String occupation) 
	{
		User user = new User (firstName, lastName, age, gender, occupation);
		usersIndex.put(user.userId, user);
	}
	
	@Override
	public User getUser(Long userId) 
	{
		return usersIndex.get(userId);
	}
	
	@Override
	public void removeUser(Long userId) 
	{
		usersIndex.remove(userId);
	}

	@Override
	public void addMovie(String title, String year, String url) 
	{
		Movie movie = new Movie (title, year, url);
		movies.put(movie.movieId, movie);
	}

	@Override
	public void addRating(Long userID, Long movieId, int rating) 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public Movie getMovie(Long movieId) 
	{
		return movies.get(movieId);
	}

	@Override
	public User getUserRatings(Long userID)
	{
		// TODO Auto-generated method stub
		return null;
	}
	

	public RecommenderAPI(Serializer serializer)
	{
		this.serializer = serializer;
	}

	@SuppressWarnings("unchecked")
	public void load() throws Exception
	{
		serializer.read();
		usersIndex = (Map<Long, User>) serializer.pop();
	}

	@Override
	public void store() 
	{
		serializer.push(usersIndex);
	}

}

