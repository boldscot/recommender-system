package models;

import static models.Fixtures.users;
import static models.Fixtures.movies;
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

			recommender.createUserFromFile(users[i]);
			
		}
		System.out.println(recommender.getUsersIndex());
		
		
		for (int i = 0; i <movies.length; i++)
		{
			recommender.addMovieFromFile(movies[i]);
		}
		System.out.println(recommender.getMovies());
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
		assertEquals(recommender.getUsersIndex().size(), users.length);
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
		assertEquals (users.length-1, recommender.getUsersIndex().size() );
	}
	
	@Test
	public void testDeleteUsers()
	{
		recommender.deleteUsers();
		assertEquals(recommender.getUsersIndex().size(), 0);
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
		assertEquals(users.length+1, recommender.getUsersIndex().size());
	}
	
	@Test
	public void addMovie()
	{
		recommender.addMovie("thisMovie", "2015", "www.movie.com");
		assertEquals(movies.length+1, recommender.getMovies().size());
	}
	
	

}




