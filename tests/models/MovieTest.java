package models;

import static org.junit.Assert.*;
import static models.Fixtures.movies;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class MovieTest 
{
	Movie movie = new Movie("saving private ryan", "1998",
			"http://www.imdb.com/title/tt0120815/");

	@Test
	public void testCreate() 
	{
		assertEquals("saving private ryan", movie.title); 					
		assertEquals("1998", movie.year);									
		assertEquals("http://www.imdb.com/title/tt0120815/", movie.url);	
	}

	@Test 
	public void testMovieScore()
	{
		assertEquals(movie.totalMovieScore, 0);				
		movie.setTotalMovieScore(10);
		assertEquals(movie.totalMovieScore, 10);			
		movie.setTotalMovieScore(10);
		assertEquals(movie.totalMovieScore, 20);			
	}

	@Test
	public void testIds()
	{
		Set<Long> ids = new HashSet<>();
		for (Movie movie : movies)
		{
			ids.add(movie.movieId);
		}
		assertEquals (movies.length, ids.size());		
	}

	@Test
	public void testToString()
	{
		assertEquals (" " + "\n" 
				+ "Movie title :" + movie.title+ "\n"
				+ "release year : :" + movie.year + "\n"
				+"link :" + movie.url + "\n"
				+"movie Id: " + movie.movieId + "\n"
				+"movie score: " + movie.totalMovieScore + "\n"
				+ " " + "\n ", movie.toString());				
	}

	@Test
	public void testEquals()
	{
		Movie movie2 = new Movie("saving private ryan", "1998",
				"http://www.imdb.com/title/tt0120815/"); 
		Movie goodfellas  = new Movie ("goodfellas", "1990",""); 

		assertEquals(movie, movie);				
		assertEquals(movie, movie2);			
		assertNotEquals(movie, goodfellas);		
	}

}
