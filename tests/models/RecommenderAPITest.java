package models;

import static models.Fixtures.users;
import static models.Fixtures.movies;
import static models.Fixtures.ratings;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controllers.RecommenderAPI;

public class RecommenderAPITest 
{
	private RecommenderAPI recommender;
	
	@Before
	public void setUp() 
	{
		recommender = new RecommenderAPI();
		
		for (int i = 0; i <users.length; i++)
		{

			recommender.createUserFromFixture(users[i]);
			
		}
		
		for (int i = 0; i <movies.length; i++)
		{
			recommender.addMovieFromFixture(movies[i]);
		}
		
		for (int i = 0; i < ratings.length; i++)
		{
			recommender.addRatingFromFixture((long)1, ratings[i]);
		}
		
	}

	@After
	public void tearDown()  
	{
		recommender = null;
	}

	@Test
	public void testGetUser()
	{	
		assertEquals(recommender.getUser((long) 01), users[0] );
		
	}
	
	@Test
	public void testGetUsersIndex()
	{
		assertEquals(recommender.getUsers().size(), users.length);
	}
	
	@Test
	public void testGetMovies()
	{
		assertEquals(recommender.getMovies().size(), movies.length);
	}
	
	
	@Test
	public void testRemoveUser()
	{
		User thisUser = recommender.getUser((long) 01);
		recommender.removeUser(thisUser.id);
		assertEquals (users.length-1, recommender.getUsers().size() );
	}
	
	@Test
	public void testDeleteUsers()
	{
		recommender.deleteUsers();
		assertEquals(recommender.getUsers().size(), 0);
	}
	
	@Test
	public void testGetMovie()
	{
		Movie skyfall = recommender.getMovieByName("skyfall");
		assertEquals(recommender.getMovie(skyfall.movieId), skyfall );
				
	}
	
	@Test
	public void createUser()
	{
		recommender.createUser("stephen", "collins", 28 ,"M" , "student");
		assertEquals(users.length+1, recommender.getUsers().size());
	}
	
	@Test
	public void addMovie()
	{
		recommender.addMovie("thisMovie", "2015", "www.movie.com");
		assertEquals(movies.length+1, recommender.getMovies().size());
	}
	
	@Test
	public void addRating()
	{
		recommender.addRating((long) 2, "spectre", 8);
		assertEquals(1 , recommender.getUser((long) 2).moviesRated.size());
	}
	
	@Test
	public void getUsersRatings()
	{
		User newUser = recommender.createUser("steve", "collins", 28, "M", "student");
		recommender.addRating(newUser.id, "spectre", 8);
		assertEquals(recommender.getUser((long) 2).moviesRated, newUser.moviesRated );
	}
	
	
	

}




