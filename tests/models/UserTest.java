package models;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

import static models.Fixtures.users;

public class UserTest
{
	User stephen = new User ("stephen", "collins", 28, "M",  "student");

	@Test
	public void testCreate()
	{
		assertEquals ("stephen", stephen.firstName);
		assertEquals ("collins", stephen.lastName);
		assertEquals (28,   stephen.age); 
		assertEquals ("M",	stephen.gender);
		assertEquals ("student", stephen.occupation);   
	}

	@Test
	public void testIds()
	{
		Set<Long> ids = new HashSet<>();
		for (User user : users)
		{
			ids.add(user.id);
		}
		assertEquals (users.length, ids.size());
	}

	@Test
	public void testToString()
	{
		assertEquals ("User{" + stephen.id + 
				", stephen, collins, M, 28, student}", stephen.toString());
	}

	@Test
	public void testEquals()
	{
		User stephen2 = new User ("stephen", "collins", 28, "M",  "student"); 
		User geralt  = new User ("geralt", "ofRivia", 100, "M",  "witcher"); 

		assertEquals(stephen, stephen);
		assertEquals(stephen, stephen2);
		assertNotEquals(stephen, geralt);
	} 

}