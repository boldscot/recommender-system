package controllers;
import java.io.File;

import utils.Serializer;
import utils.XMLSerializer;
import models.User;
import models.Movie;
import models.Rating;
import static models.Fixtures.movies;
import static models.Fixtures.ratings;
import static models.Fixtures.users;

import org.junit.Test;

import static org.junit.Assert.*;
import controllers.RecommenderAPI;

public class PersistanceTest 
{
	RecommenderAPI recommender;
	
	
	void populate(RecommenderAPI recommender)
	{
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
	

	@Test
	public void testPopulate()
	{
		recommender = new RecommenderAPI(null);
		assertEquals(0, recommender.getUsers().size());
		
		populate(recommender);
		assertEquals(users.length, recommender.getUsers().size());
		assertEquals(movies.length, recommender.getMovies().size());
		assertEquals(3, recommender.getUser(users[0].id).moviesRated.size());
		assertEquals(3, recommender.getUser(users[1].id).moviesRated.size());
		
	}
	
	void deleteFile(String fileName)
	{
		File datastore = new File ("testdatastore.xml");
		if (datastore.exists())
		{
			datastore.delete();
		}
	}
	
	@Test
	public void testXMLSerializer() throws Exception
	{ 
		String datastoreFile = "testdatastore.xml";
		deleteFile (datastoreFile);

		Serializer serializer = new XMLSerializer(new File (datastoreFile));

		recommender = new RecommenderAPI(serializer); 
		populate(recommender);
		recommender.store();

		RecommenderAPI recommender2 =  new RecommenderAPI(serializer);
		recommender2.load();

		assertEquals (recommender.getUsers().size(), recommender2.getUsers().size());
		for (User user : recommender.getUsers())
		{
			assertTrue (recommender2.getUsers().contains(user));
		}
		deleteFile ("testdatastore.xml");
	}



}
