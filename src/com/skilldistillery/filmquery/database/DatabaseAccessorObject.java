package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
	static {
		try {
		  Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

  @Override
  public Film findFilmById(int filmId) throws SQLException {
	  String user = "student";
	    String pass = "student";
	    Connection conn = DriverManager.getConnection(URL, user, pass);
		Film film = null;
		String sql = "SELECT id, title, description, release_year, language_id, rental_duration, ";
        sql += " rental_rate, length, replacement_cost, rating, special_features "
       +  " FROM film  "
       + " WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
  	  stmt.setInt(1,filmId);
  	  ResultSet actorResult = stmt.executeQuery();
  	  if (actorResult.next()) {
  		film = new Film(); // Create the object
  	    // Here is our mapping of query columns to our object fields:
  		film.setFilmId(actorResult.getInt(1));
  		film.setFilmTitle(actorResult.getString(2));
  		film.setFilmDescription(actorResult.getString(3));
  		film.setFilmRelsYear(actorResult.getShort(4));
  		film.setFilmLangId(actorResult.getInt(5));
  		film.setFilmRentDur(actorResult.getInt(6));
  		film.setFilmRate(actorResult.getDouble(7));
  		film.setFilmLength(actorResult.getInt(8));
  		film.setFilmRepCost(actorResult.getDouble(9));
  		film.setFilmRating(actorResult.getString(10));
  		film.setFilmFeature(actorResult.getString(11));
//  	    actor.setFilms(findFilmsByActorId(actorId)); // An Actor has Films
  	  }
	  
	  
	  return film;
  }

@Override
public Actor findActorById(int actorId) throws SQLException {
	
	String user = "student";
    String pass = "student";
    Connection conn = DriverManager.getConnection(URL, user, pass);
	Actor actor = null;
	  //...
	  String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
	  PreparedStatement stmt = conn.prepareStatement(sql);
	  stmt.setInt(1,actorId);
	  ResultSet actorResult = stmt.executeQuery();
	  if (actorResult.next()) {
	    actor = new Actor(); // Create the object
	    // Here is our mapping of query columns to our object fields:
	    actor.setId(actorResult.getInt(1));
	    actor.setFirstName(actorResult.getString(2));
	    actor.setLastName(actorResult.getString(3));
//	    actor.setFilms(findFilmsByActorId(actorId)); // An Actor has Films
	  }
	  //...
	  return actor;
	// TODO Auto-generated method stub
}

@Override
public List<Film> findActorsByFilmId(int actorId) {
//	// TODO Auto-generated method stub
//	String user = "student";
//    String pass = "student";
//	List<Actor> actor = new ArrayList<>();
//	  try {
//	    Connection conn = DriverManager.getConnection(URL, user, pass);
//	    String sql = "select actor.id , actor.first_name , actor.last_name  from actor "
//	   + "join film_actor on actor.id = film_actor.actor_id " 
//	   + "join film on film_actor.film_id = film.id "
//	   + "where film.id =?";
////	    String sql = "SELECT actor.id, title,first_name, last_name"
////	                 
////	               +  " FROM film JOIN film_actor ON film.id = film_actor.film_id "
////	               +  " join actor on film_actor.actor_id = actor.id"
////	               + " WHERE film.id = ?";
//	    PreparedStatement stmt = conn.prepareStatement(sql);
//	    stmt.setInt(1, filmId);
//	    ResultSet rs = stmt.executeQuery();
//	    while (rs.next()) {
//	      int Id = rs.getInt("actor.id");
//	      String firstName = rs.getString("actor.first_name");
//	      String lastName = rs.getString("actor.last_name");
//	       
//	      Actor actors = new Actor(Id, firstName,lastName);
//	      Actor.add(actors);
//	    }
//	    rs.close();
//	    stmt.close();
//	    conn.close();
//	  } catch (SQLException e) {
//	    e.printStackTrace();
//	  }
//	  return actor;
	String user = "student";
  String pass = "student";
	List<Film> films = new ArrayList<>();
	  try {
	    Connection conn = DriverManager.getConnection(URL, user, pass);
	    String sql = "SELECT id, title, description, release_year, language_id, rental_duration, ";
	                sql += " rental_rate, length, replacement_cost, rating, special_features "
	               +  " FROM film JOIN film_actor ON film.id = film_actor.film_id "
	               + " WHERE actor_id = ?";
	    PreparedStatement stmt = conn.prepareStatement(sql);
	    stmt.setInt(1, actorId);
	    ResultSet rs = stmt.executeQuery();
	    while (rs.next()) {
	      int filmId = rs.getInt(1);
	      String title = rs.getString(2);
	      String desc = rs.getString(3);
	      short releaseYear = rs.getShort(4);
	      int langId = rs.getInt(5);
	      int rentDur = rs.getInt(6);
	      double rate = rs.getDouble(7);
	      int length = rs.getInt(8);
	      double repCost = rs.getDouble(9);
	      String rating = rs.getString(10);
	      String features = rs.getString(11);
	      Film film = new Film(filmId, title, desc, releaseYear, langId,
	                           rentDur, rate, length, repCost, rating, features);
	      films.add(film);
	    }
	    rs.close();
	    stmt.close();
	    conn.close();
	  } catch (SQLException e) {
	    e.printStackTrace();
	  }
	  return films;
	
	
}
	

}
