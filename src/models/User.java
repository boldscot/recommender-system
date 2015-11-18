package models;

import static com.google.common.base.MoreObjects.toStringHelper;
import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Objects;

public class User 
{
	

	static Long counter = 0l;
	
	private Map<Long, Movie> moviesRated;
	private Long userId;
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private String occupation;

	

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
		this.moviesRated = new HashMap<>();
		
	}
	
	/**
	 * @return the counter
	 */
	public static Long getCounter() 
	{
		return counter;
	}

	/**
	 * @param counter the counter to set
	 */
	public static void setCounter(Long counter) 
	{
		User.counter = counter;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() 
	{
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) 
	{
		this.userId = userId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() 
	{
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() 
	{
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	/**
	 * @return the age
	 */
	public int getAge() 
	{
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) 
	{
		this.age = age;
	}

	/**
	 * @return the gender
	 */
	public String getGender() 
	{
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender)
	{
		this.gender = gender;
	}

	/**
	 * @return the occupation
	 */
	public String getOccupation() 
	{
		return occupation;
	}

	/**
	 * @param occupation the occupation to set
	 */
	public void setOccupation(String occupation) 
	{
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