package controllers;

import java.io.File;

import edu.princeton.cs.introcs.In;

public class Main 
{

	public static void main(String[] args) throws Exception 
	{
		RecommenderAPI recommender = new RecommenderAPI();
		
		File usersFile = new File("data/users5.dat");

		In inUsers = new In(usersFile);
		//each field is separated(delimited) by a '|'
		String delims = "[|]";
		while (!inUsers.isEmpty()) 
		{
			// get user and rating from data source
			String userDetails = inUsers.readLine();

			// parse user details string
			String[] userTokens = userDetails.split(delims);

			// output user data to console.
			if (userTokens.length == 7) 
			{
				recommender.createUser(userTokens[1],userTokens[2], 
						Integer.parseInt(userTokens[3]), userTokens[4], userTokens[5]);
			}
			else
			{
				throw new Exception("Invalid member length: "+userTokens.length);
			}
		}
		
		System.out.println(recommender.userIndex);

	}

}
