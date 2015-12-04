package models;

public class Fixtures
{
	public static User[] users =
		{
			new User ("nathan", "drake",  40, "M", "thief"),
			new User ("big",  "boss", 50, "M", "legendary soldier"),
			new User ("geralt", "ofRivia", 100, "M", "witcher"),
			new User ("john","marston", 47, "M", "cowboy")
		};

	public static Movie[] movies =
		{
			new Movie ("spectre",  "2015",  "http://www.imdb.com/title/tt2379713/?ref_=nv_sr_1"),
			new Movie("hitman",  "2007", "http://www.imdb.com/title/tt0465494/?ref_=nv_sr_2"),
			new Movie ("skyfall", "2012", "http://www.imdb.com/title/tt1074638/?ref_=nv_sr_1"),
			new Movie("unforgiven",  "1992", "http://www.imdb.com/title/tt1074638/?ref_=nv_sr_1")
		};
	
	public static Rating [] ratings = 
		{
			new Rating(movies[0].movieId , 10),
			new Rating(movies[1].movieId ,  5),
			new Rating(movies[2].movieId ,  7)
		};

}