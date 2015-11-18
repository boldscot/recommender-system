package controllers;

import java.io.File;

import utils.Serializer;
import utils.XMLSerializer;
import edu.princeton.cs.introcs.In;

public class Main 
{
	public static RecommenderAPI recoApi;
	
	public static void main(String[] args) throws Exception 
	{
		File usersFile = new File("users.xml");
		Serializer serializer = new XMLSerializer(usersFile);
		
		recoApi = new RecommenderAPI(serializer);
		
		//File usersFile = new File("data/users5.dat");

		In inUsers = new In("data/users5.dat");
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
				recoApi.createUser(userTokens[1],userTokens[2], 
						Integer.parseInt(userTokens[3]), userTokens[4], userTokens[5]);
			}
			else
			{
				throw new Exception("Invalid member length: "+userTokens.length);
			}
		}
		recoApi.store();
		
		
	}

}
