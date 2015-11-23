package controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.Serializer;
import models.Movie;
import models.Rating;
import models.User;

public class RecommenderAPI implements RecommenderInterface
{
	private Serializer serializer;

	private Map<Long, User> usersIndex = new HashMap<>();
	private Map<String, Movie> movieNames = new HashMap<>();
	private Map<Long, Movie> movies = new HashMap<>();

	public RecommenderAPI()
	{

	}

	public RecommenderAPI(Serializer serializer)
	{
		this.serializer = serializer;
	}
	
	@SuppressWarnings("unchecked")
	public void load() throws Exception
	{
		serializer.read();
		usersIndex       = (Map<Long, User>)     serializer.pop();
	}

	public void store() throws Exception
	{
		serializer.push(usersIndex);
		serializer.write(); 
	}
	
	/**
	 * @return the usersIndex
	 */
	public Map<Long, User> getUsersIndex() 
	{
		return usersIndex;
	}

	/**
	 * @return the movies
	 */
	public Map<Long, Movie> getMovies() 
	{
		return movies;
	}

	public User createUser(String firstName, String lastName, int age , String gender, String occupation) 
	{
		User user = new User (firstName, lastName, age, gender, occupation);
		usersIndex.put(user.id, user);
		return user;
	}

	@Override
	public User getUser(Long userId) 
	{
		return usersIndex.get(userId);
	}

	@Override
	public Collection<User> getUsers ()
	{
		return usersIndex.values();
	}

	@Override
	public void removeUser(Long userId) 
	{
		usersIndex.remove(userId);
	}

	@Override
	public Movie addMovie(String title, String year, String url) 
	{
		Movie movie = new Movie (title, year, url);
		movies.put(movie.id, movie);
		movieNames.put(movie.title, movie);
		return movie;
	}

	@Override
	public void addRating(Long userID, Long movieId, int rating) 
	{
		User userRatingMovie = usersIndex.get(userID);
		Rating ratingForMovie = new Rating(rating, movieId);
		userRatingMovie.moviesRated.add(ratingForMovie);  			//add the rating for a movie to the
	}																//users Arraylist of rated movies.

	@Override
	public Movie getMovie(Long movieId) 
	{
		return movies.get(movieId);
	}
	

	@Override
	public Movie getMovieByName(String movieName) 
	{
		return movieNames.get(movieName);
	}

	@Override
	public List<Rating> getUserRatings(Long userID)
	{
		User usersRatings = usersIndex.get(userID);
		return usersRatings.moviesRated;
	}

}

