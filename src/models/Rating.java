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

	public Rating(Long movieId, int rating)
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
		return Objects.hashCode(this.rating, this.movieId);
	}

	@Override
	public boolean equals(final Object obj)
	{
		if (obj instanceof Rating)
		{
			final Rating other = (Rating) obj;
			return Objects.equal(movieId, other.movieId)
					&& Objects.equal(rating, other.rating);
					
		}
		else
		{
			return false;
		}
	}


}
