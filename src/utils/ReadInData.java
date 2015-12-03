package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import controllers.Main;
import controllers.RecommenderAPI;
import edu.princeton.cs.introcs.In;
import models.User;

public class ReadInData 
{

	public ReadInData() throws Exception
	{
		loadUsers();
		loadMovies();
	}

	public void loadUsers() throws Exception
	{
		File userData = new File("data/users5.dat");
		In inUsers = new In(userData);
		
		//each field is separated(delimited) by a '|'
		String delims = "[|]";
		while (!inUsers.isEmpty()) 
		{
			// get user and rating from data source
			String userDetails = inUsers.readLine();

			// parse user details string
			String[] userTokens = userDetails.split(delims);

			//create users from dat file
			if (userTokens.length == 7) 
			{
				Main.recoApi.createUser(userTokens[1], 
						userTokens[2], Integer.parseInt(userTokens[3]), userTokens[4], userTokens[5]);
			}
			else
			{
				throw new Exception("Invalid member length: "+userTokens.length);
			}
		}
	}
	
	public void loadMovies() throws Exception
	{
		File movieData = new File("data/items5.dat");
		In inMovies = new In(movieData);
		
		//each field is separated(delimited) by a '|'
		String delims = "[|]";
		while (!inMovies.isEmpty()) 
		{
			// get user and rating from data source
			String movieDetails = inMovies.readLine();

			// parse user details string
			String[] movieTokens = movieDetails.split(delims);

			//create users from dat file
			if (movieTokens.length == 23) 
			{
				Main.recoApi.addMovie(movieTokens[1], 
						movieTokens[2],movieTokens[3]);
				
			}
			else
			{
				throw new Exception("Invalid member length: "+movieTokens.length);
			}
		}
	}

}
