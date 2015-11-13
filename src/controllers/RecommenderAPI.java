package controllers;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import models.Movie;
import models.User;
import edu.princeton.cs.introcs.In;

public class RecommenderAPI implements RecommenderInterface
{
	public static Map<Long, User> userIndex = new HashMap<>();
	
	public User createUser(String firstName, String lastName, 
			int age, String gender, String occupation) 
	  {
	    User user = new User (firstName, lastName, age, gender, occupation);
	    userIndex.put(user.userId, user);
	    return user;
	  }

	@Override
	public void removeUser(Long userId) 
	{
		 userIndex.remove(userId);
	}

	@Override
	public void addMovie(String title, String year, String url) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addRating(Long userID, Long movieID, String rating) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public Movie getMovie(Long movieID) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserRatings(Long userID)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void load() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void store() 
	{
		// TODO Auto-generated method stub
		
	}
}

