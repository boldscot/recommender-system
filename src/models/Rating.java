package models;

import utils.ToJsonString;

import com.google.common.base.Objects;

public class Rating 
{
	public int rating;
	public Long movieId;
	
	public Rating()
	{
	}

	public Rating(int rating, Long movieId)
	{
		this.rating = rating;
		this.movieId = movieId;
	}
	
	@Override
	public String toString()
	{
		return new ToJsonString(getClass(), this).toString();
	}

	@Override
	public int hashCode()
	{
		return Objects.hashCode(this.rating);
	}

	@Override
	public boolean equals(final Object obj)
	{
		if (obj instanceof Movie)
		{
			final Rating other = (Rating) obj;
			return Objects.equal(rating, other.rating);
					
		}
		else
		{
			return false;
		}
	}


}
