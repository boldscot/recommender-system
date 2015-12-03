package models;

import utils.ToJsonString;

import com.google.common.base.Objects;

public class Rating 
{
	public int rating;
	public String movieTitle;
	
	public Rating()
	{
	}

	public Rating(String movieTitle, int rating)
	{
		this.rating = rating;
		this.movieTitle = movieTitle;
	}
	
	@Override
	public String toString()
	{
		return new ToJsonString(getClass(), this).toString();
	}

	@Override
	public int hashCode()
	{
		return Objects.hashCode(this.rating, this.movieTitle);
	}

	@Override
	public boolean equals(final Object obj)
	{
		if (obj instanceof Movie)
		{
			final Rating other = (Rating) obj;
			return Objects.equal(rating, other.rating)
					&& Objects.equal(movieTitle, other.movieTitle);
					
		}
		else
		{
			return false;
		}
	}


}
