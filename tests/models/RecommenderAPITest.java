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
					user.age, user.gender, user.occupation);
			
		}
		System.out.println(recommender.getUsersIndex());
	
	}

	@After
	public void tearDown()  
	{
		recommender = null;
	}

	@Test
	public void testGetUser()
	{	
		assertEquals(recommender.getUser((long) 04), users[0] );
		
	}
	
	

}




