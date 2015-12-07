package controllers;

import static models.Fixtures.users;
import static models.Fixtures.movies;
import static models.Fixtures.ratings;
import static org.junit.Assert.*;
import models.Movie;
import models.User;

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
		
		recommender.addRating(users[0].id, movies[0].movieId, 10);
		recommender.addRating(users[0].id, movies[1].movieId, 8);
		recommender.addRating(users[0].id, movies[2].movieId, 10);
		
		recommender.addRating(users[1].id, movies[0].movieId, 10);
		recommender.addRating(users[1].id, movies[1].movieId, 8);
		recommender.addRating(users[1].id, movies[2].movieId, 10);
		
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
		recommender.addRating((long) 2, movies[0].movieId, 8);
		assertEquals(1 , recommender.getUser((long) 2).moviesRated.size());
	}
	
	@Test
	public void getUsersRatings()
	{
		User newUser = recommender.createUser("steve", "collins", 28, "M", "student");
		recommender.addRating(newUser.id, movies[0].movieId, 8);
		assertEquals(recommender.getUserRatings((long) 2), recommender.getUserRatings(newUser.id));
	}
	
	@Test
	public void getSimilarityAndRecommedations()
	{
		User newUser =  recommender.createUser("steve", "collins", 28, "M", "student");
		User otherNewUser = recommender.createUser("clint", "eatwood", 72, "M", "director");
		
		Movie movie1 = recommender.addMovie("The Rock", "1999", "www.therock.com");
		Movie movie2 = recommender.addMovie("Con Air", "1998", "www.conAir.com");
		Movie movie3 = recommender.addMovie("Rocky", "1985", "www.rocky.com");
		Movie movie4 = recommender.addMovie("The Good The Bad and The Ugly", "1966", "www.TGTBATU.com");
		
		recommender.addRating(newUser.id, movie1.movieId, 10);
		recommender.addRating(newUser.id, movie2.movieId, 20);
		recommender.addRating(newUser.id, movie3.movieId, 8);
		recommender.addRating(newUser.id, movie4.movieId, 10);
		
		recommender.addRating(otherNewUser.id, movie1.movieId, 10);
		recommender.addRating(otherNewUser.id, movie2.movieId, 20);
		
		assertEquals(recommender.getUserRatings(otherNewUser.id).size(), 2);
		assertEquals(recommender.getUserRatings(newUser.id).size(), 4);
		assertEquals(recommender.getSimilarity(newUser.id, otherNewUser.id), 500);
		assertNotEquals(movie1.movieId, movie4.movieId);
		assertEquals(recommender.getUserRecommendations(otherNewUser.id).size(), 2);
		
	}
	

	
	
	

}




