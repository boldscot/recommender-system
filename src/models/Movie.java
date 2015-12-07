package models;

import utils.ToJsonString;

import com.google.common.base.Objects;

public class Movie implements Comparable<Movie>
{
	public static Long movieCounter = 01l;

	public Long movieId;

	public String title;
	public String year;
	public String url;
	public int totalMovieScore;
	
	
	public Movie(String title, String year, String url)
	{
		this.movieId = movieCounter ++;
		this.totalMovieScore = 0;
		this.title = title;
		this.year = year;
		this.url = url;
		this.totalMovieScore = 0;
		
	}
	
	public static Long getCounter() 
	{
		return movieCounter;
	}

	public static void setCounter(Long counter) 
	{
		Movie.movieCounter = counter;
	}
	
	public int getTotalMovieScore()
	{
		return totalMovieScore;
	}
	
	public void setTotalMovieScore(int num)
	{
		this.totalMovieScore+=num;
	}
	
	//The compareTo method will return a negative number if current value is less than the other value, 
	//positive number if current value is greater than the other value and zero if both values 
	//are equal.
	@Override
	public int compareTo(Movie compareMov) 
	{
		int compareTotalMovieScore = compareMov.getTotalMovieScore();
		return compareTotalMovieScore-this.totalMovieScore;
	}


	@Override
	public String toString()
	{
		return " " + "\n" +
				"Movie title :" + title+ "\n"
				+ "release year : :" + year + "\n"
				+"link :" + url + "\n"
				+"movie Id: " + movieId + "\n"
				+"movie score: " + totalMovieScore + "\n"
				+ " " + "\n ";
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
					&& Objects.equal(url, other.url)
					&& Objects.equal(totalMovieScore, other.totalMovieScore);
		}
		else
		{
			return false;
		}
	}


}
