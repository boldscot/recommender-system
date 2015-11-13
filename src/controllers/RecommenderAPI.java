package controllers;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import utils.Serializer;
import models.Movie;
import models.User;
import edu.princeton.cs.introcs.In;

public class RecommenderAPI implements RecommenderInterface
{
	private Serializer serializer;

	public static Map<Long, User> userIndex = new HashMap<>();
	public static Map<Long, Movie> movieIndex = new HashMap<>();

	public void createUser(String firstName, String lastName, 
			int age, String gender, String occupation) 
	{
		User user = new User (firstName, lastName, age, gender, occupation);
		userIndex.put(user.userId, user);
	}

	@Override
	public void removeUser(Long userId) 
	{
		userIndex.remove(userId);
	}

	@Override
	public void addMovie(String title, String year, String url) 
	{
		Movie movie = new Movie (title, year, url);
		movieIndex.put(movie.movieId, movie);
	}

	@Override
	public void addRating(Long userID, Long movieId, String rating) 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public Movie getMovie(Long movieId) 
	{
		return movieIndex.get(movieId);
	}

	@Override
	public User getUserRatings(Long userID)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void load() throws Exception
	{
		serializer.read();
		userIndex = (Map<Long, User>) serializer.pop();
	}

	@Override
	public void store() 
	{
		serializer.push(userIndex);
	}
}

