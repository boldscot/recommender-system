/**
 * 
 */
package models;

import static org.junit.Assert.*;

import org.junit.Test;


public class RatingTest 
{
	Rating rating = new Rating(5, "skyfall");
	
	@Test
	public void testCreate() 
	{
		assertEquals(5, rating.rating);
		assertEquals("skyfall", rating.movieTitle);
	}
	
	@Test
	  public void testEquals()
	  {
	    Rating rating2 = new Rating(5, "skyfall"); 
	    Rating spectreRating  = new Rating (4, "spectre"); 

	    assertEquals(rating, rating);
	    assertEquals(rating, rating2);
	    assertNotEquals(rating, spectreRating);
	  }

}
