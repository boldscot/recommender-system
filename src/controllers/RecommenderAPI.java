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

		movies      	 = (Map<Long, Movie>)    serializer.pop();
		movieNames       = (Map<String, Movie>)  serializer.pop();
		usersIndex       = (Map<Long, User>)     serializer.pop();  
		Long userCounter = (Long) serializer.pop(); 
		User.setCounter(userCounter);
	}

	public void store() throws Exception
	{
		serializer.push(User.getCounter());
		serializer.push(usersIndex);
		serializer.push(movieNames);
		serializer.push(movies);
		
		serializer.write(); 
	}

	public void createUserFromFixture(User user)
	{
		usersIndex.put(user.id, user);
	}
	
	@Override
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
	
	public void deleteUsers() 
	{
		usersIndex.clear();
	}

	@Override
	public Collection<User> getUsers ()
	{
		return usersIndex.values();
	}
	
	public Collection<Movie> getMovies ()
	{
		return movies.values();
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
		movies.put(movie.movieId, movie);
		movieNames.put(movie.title, movie);
		return movie;
	}
	
	public void addMovieFromFixture(Movie movie)
	{
		movies.put(movie.movieId, movie);
		movieNames.put(movie.title, movie);
	}
	
	
	//add the rating for a movie to the users Arraylist of rated movies.
	@Override
	public void addRating(Long userID, Long movieId, int rating) 
	{
		User userRatingMovie = usersIndex.get(userID);
		Rating ratingForMovie = new Rating(movieId, rating);
		userRatingMovie.moviesRated.add(ratingForMovie);  
	}
	
	public void addRatingFromFixture(Long userID, Rating rating) 
	{
		User userRatingMovie = usersIndex.get(userID);
		userRatingMovie.moviesRated.add(rating);  
	}

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

