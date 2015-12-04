/**
 * 
 */
package models;

import static org.junit.Assert.*;
import static models.Fixtures.ratings;
import static models.Fixtures.movies;

import org.junit.Test;


public class RatingTest 
{
	Rating ratedMovie = new Rating(movies[0].movieId, 9);
	
	@Test
	public void testCreate()
	{
		assertEquals(9, ratedMovie.rating);
		assertEquals(movies[0].movieId, ratedMovie.movieId);
	}
	
	@Test
	  public void testEquals()
	  {
	    Rating rating2 = new Rating(movies[0].movieId, 9); 
	    Rating spectreRating  = new Rating (ratings[0].movieId, 4); 

	    assertEquals(ratedMovie, ratedMovie);
	    assertEquals(ratedMovie, rating2);
	    assertNotEquals(ratedMovie, spectreRating);
	  }

}
