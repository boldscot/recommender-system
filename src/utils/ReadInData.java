package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import controllers.RecommenderAPI;
import edu.princeton.cs.introcs.In;
import models.User;

public class ReadInData 
{
	public RecommenderAPI reco;
	public ArrayList<User> DATusers;
	//public File thisFile;

	public ReadInData() throws Exception
	{
		reco = new RecommenderAPI();
		loadUsers();
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
				DATusers.add(reco.createUser(userTokens[1], 
						userTokens[2], Integer.parseInt(userTokens[3]), userTokens[4], userTokens[5]));
			}
			else
			{
				throw new Exception("Invalid member length: "+userTokens.length);
			}
		}
	}

	/**
	 * @return the dATusers
	 */
	public ArrayList<User> getDATusers() 
	{
		return DATusers;
	}

}
