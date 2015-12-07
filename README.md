# recommender-system
The program loads information from files(users, movies and ratings) and stores them in an XML file. 
The program allows the user to add users, movies and ratings to the stored data aswell as removing them.
The user can get a list of the top ten movies in the data, this is calculated by adding the total rating values for each movie 
and comparing the values of each movie. The ten highest scoring movies are returned to the user. 
The user can check for any users recommended movies, movies are suggested to a user based on their similarity with other users, 
this is calculated by comparing the ratings of movies that 2 users have rated and getting the dot product of those values.
If 2 users have a high similarity any movie the user hasn't rated but the other has will be added to an arraylist of recommended movies
to be returned to the user, the list is sorted in descending order and a sublist of the top 15 is returned to the user.
