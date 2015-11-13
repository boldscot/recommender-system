package controllers;

import models.Movie;
import models.Rating;
import models.User;

/**
 * @author Stephen Collins
 *
 */
public interface RecommenderInterface 
{
	User createUser(String firstName, String lastName, int age,
			String gender,String occupation);
	void removeUser(Long userId);
	
	void addMovie(String title, String year, String  url);
	void addRating(Long userID, Long movieID, String rating);
	Movie getMovie(Long movieID);
	User getUserRatings(Long userID);
	//getUserRecommendations(userID)
	//getTopTenMovies()
	void load();
	void store();
}
