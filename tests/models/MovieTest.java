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
		assertEquals ("Movie{" + movie.movieId + 
				", saving private ryan, 1998, "
				+ "http://www.imdb.com/title/tt0120815/}", movie.toString());
	}

}
