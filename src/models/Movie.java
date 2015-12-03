package models;

import utils.ToJsonString;
import com.google.common.base.Objects;

public class Movie
{
	static Long movieCounter = 0l;

	public Long movieId;

	public String title;
	public String year;
	public String url;
	
	
	public Movie(String title, String year, String url)
	{
		this.movieId = movieCounter ++;
		this.title = title;
		this.year = year;
		this.url = url;
	}

	@Override
	public String toString()
	{
		return new ToJsonString(getClass(), this).toString();
	}

	@Override
	public int hashCode()
	{
		return Objects.hashCode(this.movieId, this.title, this.year, this.url);
	}

	@Override
	public boolean equals(final Object obj)
	{
		if (obj instanceof Movie)
		{
			final Movie other = (Movie) obj;
			return Objects.equal(title, other.title)
					&& Objects.equal(year, other.year)
					&& Objects.equal(url, other.url);
		}
		else
		{
			return false;
		}
	}
}
