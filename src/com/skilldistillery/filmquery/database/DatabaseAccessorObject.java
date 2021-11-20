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
import com.skilldistillery.filmquery.entities.Language;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
	String user = "student";
	String pass = "student";
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Film> findFilmByKeyword(String titleKeywords) throws SQLException {
		Connection conn = DriverManager.getConnection(URL, user, pass);

		List<Film> films = new ArrayList<>();
		String sql = "SELECT film.id, film.title, film.description, film.release_year, film.language_id, film.rental_duration, ";
		sql += " film.rental_rate, film.length, film.replacement_cost, film.rating, film.special_features, "
				+ "language.name" + " FROM film join language on language.id = film.language_id "
				+ " WHERE title like ? or description like ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "%" + titleKeywords + "%");
		stmt.setString(2, "%" + titleKeywords + "%");
		ResultSet actorResult = stmt.executeQuery();
		while (actorResult.next()) {
			Film film = new Film(); // Create the object
			// Here is our mapping of query columns to our object fields:
			film.setId(actorResult.getInt(1));
			film.setTitle(actorResult.getString(2));
			film.setDescription(actorResult.getString(3));
			film.setReleaseYear(actorResult.getShort(4));
			film.setLanguageId(actorResult.getInt(5));
			film.setRentalDuration(actorResult.getInt(6));
			film.setRentalRate(actorResult.getDouble(7));
			film.setLength(actorResult.getInt(8));
			film.setReplacementCost(actorResult.getDouble(9));
			film.setRating(actorResult.getString(10));
			film.setSpecialFeature(actorResult.getString(11));
			int filmID = film.getId();
			film.setActors(findActorsByFilmId(filmID));
			film.setLanguage(actorResult.getString(12));
//			int lanID = film.getLanguageId();
//			film.setLanguageName(findLanguageByLangID(lanID));
			films.add(film);

		}
		return films;
	}

	@Override
	public Film findFilmById(int filmId) throws SQLException {
		Film film = null;

		Connection conn = DriverManager.getConnection(URL, user, pass);
		String sql = "SELECT film.id, film.title, film.description, film.release_year, film.language_id, film.rental_duration, ";
		sql += " film.rental_rate, film.length, film.replacement_cost, film.rating, film.special_features,"
				+ "language.name " + " FROM film join language on "
						+ "film.language_id = language.id " + " WHERE film.id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);
		ResultSet actorResult = stmt.executeQuery();
		if (actorResult.next() && filmId > 0) {
			film = new Film(); // Create the object
			// Here is our mapping of query columns to our object fields:
			film.setId(actorResult.getInt(1));
			film.setTitle(actorResult.getString(2));
			film.setDescription(actorResult.getString(3));
			film.setReleaseYear(actorResult.getShort(4));
			film.setLanguageId(actorResult.getInt(5));
			film.setRentalDuration(actorResult.getInt(6));
			film.setRentalRate(actorResult.getDouble(7));
			film.setLength(actorResult.getInt(8));
			film.setReplacementCost(actorResult.getDouble(9));
			film.setRating(actorResult.getString(10));
			film.setSpecialFeature(actorResult.getString(11));
			film.setActors(findActorsByFilmId(filmId));
			film.setLanguage(actorResult.getString(12));
			
//			int lanID = film.getLanguageId();
//			film.setLanguageName(findLanguageByLangID(lanID));
//  	    actor.setFilms(findFilmsByActorId(actorId)); // An Actor has Films

		}

		return film;
	}

	@Override
	public Actor findActorById(int actorId) throws SQLException {

		Connection conn = DriverManager.getConnection(URL, user, pass);
		Actor actor = null;
		// ...
		String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, actorId);
		ResultSet actorResult = stmt.executeQuery();
		if (actorResult.next()) {
			actor = new Actor(); // Create the object
			// Here is our mapping of query columns to our object fields:
			actor.setId(actorResult.getInt(1));
			actor.setFirstName(actorResult.getString(2));
			actor.setLastName(actorResult.getString(3));
//	    actor.setFilms(findFilmsByActorId(actorId)); // An Actor has Films
		}
		// ...
		return actor;
		// TODO Auto-generated method stub
	}

	@Override
	public List<Film> findFilmByActorId(int actorId) {
//	 

		List<Film> films = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT id, title, description, release_year, language_id, rental_duration, ";
			sql += " rental_rate, length, replacement_cost, rating, special_features "
					+ " FROM film JOIN film_actor ON film.id = film_actor.film_id " + " WHERE actor_id = ?";
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
//				Film film = new Film(filmId, title, desc, releaseYear, langId, rentDur, rate, length, repCost, rating,
//						features);
//				films.add(film);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;

	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actor = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "select actor.id , actor.first_name , actor.last_name,film.title  from actor "
					+ "join film_actor on actor.id = film_actor.actor_id "
					+ "join film on film_actor.film_id = film.id " + "where film.id =?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int Id = rs.getInt("actor.id");
				String firstName = rs.getString("actor.first_name");
				String lastName = rs.getString("actor.last_name");

				Actor actors = new Actor(Id, firstName, lastName);
				actor.add(actors);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actor;
	}

	public Language findLanguageByLangID(int LanID) throws SQLException {

		Connection conn = DriverManager.getConnection(URL, user, pass);
		Language Lang = null;
		// ...
		String sql = "SELECT name FROM language WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, LanID);
		ResultSet LanResult = stmt.executeQuery();
		if (LanResult.next()) {
			Lang = new Language();

			Lang.setName(LanResult.getString("name"));
		}
		return Lang;
	}
}
