/**
 * 
 */
package models;

import static org.junit.Assert.*;

import org.junit.Test;


public class RatingTest 
{
	Rating rating = new Rating("skyfall", 5);
	
	@Test
	public void testCreate() 
	{
		assertEquals(5, rating.rating);
		assertEquals("skyfall", rating.movieTitle);
	}
	
	@Test
	  public void testEquals()
	  {
	    Rating rating2 = new Rating("skyfall", 5); 
	    Rating spectreRating  = new Rating ("spectre", 4); 

	    assertEquals(rating, rating);
	    assertEquals(rating, rating2);
	    assertNotEquals(rating, spectreRating);
	  }

}
