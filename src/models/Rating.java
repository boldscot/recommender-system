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

	public Long getMovieId()
	{
		return movieId;

	}

	@Override
	public String toString()
	{
		return " " + "\n" +
				"Movie Id:" + movieId+ "\n"
				+ "rating :" + rating + "\n"
				+" " + "\n";
	}

	@Override
	public int hashCode()
	{
		return Objects.hashCode(this.movieId, this.rating);
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
