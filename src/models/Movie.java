package models;

import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Objects;

public class Movie 
{
	static Long   movieCounter = 0l;

	public Long movieId;
	public String title;
	public String year;
	public String url;

	public Map<Long, Rating> ratings = new HashMap<>();

	public Movie()
	{
	}

	public Movie(String title, String year, String url)
	{
		this.movieId = movieCounter++;
		this.title = title;
		this.year = year;
		this.url = url;
	}

	public String toString()
	{
		return toStringHelper(this).addValue(movieId)
				.addValue(title)
				.addValue(year)
				.addValue(url)                            
				.toString();
	}
	
	@Override  
	  public int hashCode()  
	  {  
	     return Objects.hashCode(this.title, this.year, this.url);  
	  } 

	@Override
	public boolean equals(final Object obj)
	{
		if (obj instanceof Movie)
		{
			final Movie other = (Movie) obj;
			return Objects.equal(title, other.title) 
					&& Objects.equal(year,  other.year)
					&& Objects.equal(url,     other.url);
		}
		else
		{
			return false;
		}
	}
}
