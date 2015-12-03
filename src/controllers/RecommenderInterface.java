package controllers;

import java.util.Collection;
import java.util.List;
import models.Movie;
import models.Rating;
import models.User;

/**
 * @author Stephen Collins
 *
 */
public interface RecommenderInterface 
{
	User createUser(String firstName, String lastName, 
			int age, String gender, String occupation);
	User getUser(Long userId);
	Collection<User> getUsers();
	void removeUser(Long userId);
	Movie addMovie(String title, String year, String  url);
	void addRating(Long userID, String movieTitle, int rating);
	Movie getMovie(Long movieID);
	Movie getMovieByName(String movieName);
	List<Rating> getUserRatings(Long userID);
	//getUserRecommendations(userID)
	//getTopTenMovies()
	void load() throws Exception;
	void store() throws Exception;
}
