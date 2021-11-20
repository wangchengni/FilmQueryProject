package com.skilldistillery.filmquery.entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import com.skilldistillery.filmquery.database.DatabaseAccessor;

public class Actor implements DatabaseAccessor{
	 
	private int id;
	  private String firstName;
	  private String lastName;
	  private List<Film> films;
	  
	  public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	  public Actor() {}
	  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Actor(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "Actor [id=" + id + ", \nfirstName=" + firstName + ", lastName=" + lastName   + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(films, firstName, id, lastName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		return Objects.equals(films, other.films) && Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(lastName, other.lastName);
	}
	
	
	@Override
	public Film findFilmById(int filmId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Actor findActorById(int actorId) {
		 return null;
		// TODO Auto-generated method stub
	}
	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void add(Actor actors) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Film> findFilmByActorId(int actorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Film> findFilmByKeyword(String filmKeywords ) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

//	 
	  
	
	
}
