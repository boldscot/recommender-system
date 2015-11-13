package models;
import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Objects;

public class User 
{
  static Long counter = 0l;

  public Long userId;
  public String firstName;
  public String lastName;
  public int age;
  public String gender;
  public String occupation;
  
  public Map<Long, Movie> movie = new HashMap<>();
  
  public User()
  {
  }
  
  public User(String firstName, String lastName, int age, String gender, String occupation)
  {
	
    this.userId        = counter++;
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.gender = gender;
    this.occupation = occupation;
  }
  
  public String toString()
  {
    return toStringHelper(this).addValue(userId)
    		                   .addValue(firstName)
                               .addValue(lastName)
                               .addValue(age)
                               .addValue(gender)
                               .addValue(occupation)                            
                               .toString();
  }
  
  @Override  
  public int hashCode()  
  {  
     return Objects.hashCode(this.lastName, this.firstName, this.age, 
    		 this.gender, this.occupation);  
  }  
  
  @Override
  public boolean equals(final Object obj)
  {
    if (obj instanceof User)
    {
      final User other = (User) obj;
      return Objects.equal(firstName, other.firstName) 
          && Objects.equal(lastName,  other.lastName)
          && Objects.equal(age,     other.age)
          && Objects.equal(gender, other.gender)
          && Objects.equal(occupation,  other.occupation);
    }
    else
    {
      return false;
    }
  }
}