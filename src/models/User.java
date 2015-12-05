package models;

import static com.google.common.base.MoreObjects.toStringHelper;









import java.util.ArrayList;
import java.util.List;

import utils.ToJsonString;

import com.google.common.base.Objects;

public class User
{
	public static Long counter = 01l;
	public Long id;
	public String firstName;
	public String lastName;
	public String gender;
	public int age;
	public String occupation;

	public List<Rating> moviesRated = new ArrayList<>();

	public User(String firstName, String lastName, int age, String gender, String occupation)
	{
		this.id = counter++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.occupation = occupation;
	}
	
	public static Long getCounter() 
	{
		return counter;
	}

	public static void setCounter(Long counter) 
	{
		User.counter = counter;
	}

	@Override
	public String toString()
	{
		return new ToJsonString(getClass(), this).toString();
	}

	@Override
	public int hashCode()
	{
		return Objects.hashCode(this.firstName, this.lastName, this.age, this.gender, this.occupation);
	}

	@Override
	public boolean equals(final Object obj)
	{
		if (obj instanceof User)
		{
			final User other = (User) obj;
			return Objects.equal(firstName, other.firstName)
					&& Objects.equal(lastName, other.lastName)
					&& Objects.equal(gender, other.gender)
					&& Objects.equal(age, other.age)
					&& Objects.equal(occupation, other.occupation)
					&& Objects.equal(moviesRated, other.moviesRated);
		}
		else
		{
			return false;
		}
	}



}