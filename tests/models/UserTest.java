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
    assertEquals ("stephen", stephen.getFirstName());
    assertEquals ("collins", stephen.getLastName());
    assertEquals (28,   stephen.getAge()); 
    assertEquals ("M",	stephen.getGender());
    assertEquals ("student", stephen.getOccupation());   
  }

  @Test
  public void testIds()
  {
    Set<Long> ids = new HashSet<>();
    for (User user : users)
    {
      ids.add(user.getUserId());
    }
    assertEquals (users.length, ids.size());
  }

  @Test
  public void testToString()
  {
    assertEquals ("User{" + stephen.getUserId() + 
    		", stephen, collins, 28, M, student}", stephen.toString());
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