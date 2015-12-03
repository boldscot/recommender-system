package controllers;

import java.io.File;
import java.util.Collection;

import javax.xml.crypto.Data;

import models.Movie;
import models.Rating;
import models.User;
import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import asg.cliche.ShellFactory;
import utils.ReadInData;
import utils.Serializer;
import utils.XMLSerializer;
import edu.princeton.cs.introcs.In;

public class Main 
{
	public RecommenderAPI recoApi;
	public ReadInData data;

	public Main() throws Exception 
	{
		File usersFile = new File("users.xml");
		Serializer serializer = new XMLSerializer(usersFile);

		recoApi = new RecommenderAPI(serializer);
		if (usersFile.isFile())
		{
			recoApi.load();
		}
	}

	@Command(description="Add a new User")
	public void addUser (@Param(name="first name") String firstName, 
			@Param(name="last name") String lastName,
			@Param(name="age") int age, @Param(name="gender") String gender,
			@Param(name="occupation") String occupation)
	{
		recoApi.createUser(firstName, lastName, age, gender, occupation);
	}

	@Command(description="Delete a User")
	public void removeUser (@Param(name="id") Long id)
	{
		recoApi.removeUser(id);
	}
	@Command(description="Add a Movie")
	public void addMovie (@Param(name="title") String title, 
			@Param(name="year") String year, @Param(name="url") String url)
	{
		recoApi.addMovie(title, year, url);
	}
	@Command(description="Get all users details")
	public void getUsers ()
	{
		Collection<User> users = recoApi.getUsers();
		System.out.println(users);
	}
	@Command(description="Add a Rating")
	public void addRating (@Param(name="user id") Long id, 
			@Param(name="movie id") String movieTitle, @Param(name="rating") int rating)
	{
		recoApi.addRating(id, movieTitle, rating);
	}
	@Command(description = "Check rated movies")
	public void getUserRatings (@Param(name="user id") Long id)
	{
		Collection<Rating> ratings = recoApi.getUserRatings(id);
		System.out.println(ratings);
	}
	
	@Command(description = "Delete users")
	public void deleteUsers ()
	{
		recoApi.deleteUsers();

	}


	public static void main(String[] args) throws Exception
	{
		Main main = new Main();
		Shell shell = ShellFactory.createConsoleShell
				("lm", "Welcome to likemovie - ?help for instructions", main);
		shell.commandLoop();
		main.recoApi.store();
	}

}



