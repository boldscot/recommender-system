package models;

import static models.Fixtures.users;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controllers.RecommenderAPI;

public class RecommenderAPITest 
{
	private RecommenderAPI recommender;

	@Before
	public void setUp() 
	{
		recommender = new RecommenderAPI();
		for (User user : users)
		{
			recommender.createUser(user.firstName, user.lastName,
					user.age, user.gender,user.occupation);
		}
	}

	@After
	public void tearDown()  
	{
		recommender = null;
	}

	@Test
	public void getUser()
	{	
		long counter = 00;

		for(int i = 0; i < users.length; i++ )
		{
			User thisuser = users[i];
			recommender.usersIndex.put(counter, thisuser);
			User thatuser = recommender.usersIndex.get(counter);
			assertEquals(thisuser, thatuser );
		}

	}
	
	@Test
	public void deleteUser()
	{
		
	}


}
