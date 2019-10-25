package com.skilldistillery.filmquery.database;

import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {

  @Override
  public Film findFilmById(int filmId) {
    return null;
  }

}

//TODO 
//public Actor findActorById(int actorId) { }

//public List<Actor> findActorsByFilmId(int filmId) {  }

//public Actor findActorById(int actorId) {
//	  Actor actor = null;
//	  //...
//	  String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
//	  PreparedStatement stmt = conn.prepareStatement(sql);
//	  stmt.setInt(1,actorId);
//	  ResultSet actorResult = stmt.executeQuery();
//	  if (actorResult.next()) {
//	    actor = new Actor(); // Create the object
//	    // Here is our mapping of query columns to our object fields:
//	    actor.setId(actorResult.getInt(1));
//	    actor.setFirstName(actorResult.getString(2));
//	    actor.setLastName(actorResult.getString(3));
//	    actor.setFilms(findFilmsByActorId(actorId)); // An Actor has Films
//	  }
//	  //...
//	  return actor;
//	}
//
//	public List<Film> findFilmsByActorId(int actorId) {
//	  List<Film> films = new ArrayList<>();
//	  try {
//	    Connection conn = DriverManager.getConnection(url, user, pass);
//	    String sql = "SELECT id, title, description, release_year, language_id, rental_duration, ";
//	                sql += " rental_rate, length, replacement_cost, rating, special_features "
//	               +  " FROM film JOIN film_actor ON film.id = film_actor.film_id "
//	               + " WHERE actor_id = ?";
//	    PreparedStatement stmt = conn.prepareStatement(sql);
//	    stmt.setInt(1, actorId);
//	    ResultSet rs = stmt.executeQuery();
//	    while (rs.next()) {
//	      int filmId = rs.getInt(1);
//	      String title = rs.getString(2);
//	      String desc = rs.getString(3);
//	      short releaseYear = rs.getShort(4);
//	      int langId = rs.getInt(5);
//	      int rentDur = rs.getInt(6);
//	      double rate = rs.getDouble(7);
//	      int length = rs.getInt(8);
//	      double repCost = rs.getDouble(9);
//	      String rating = rs.getString(10);
//	      String features = rs.getString(11);
//	      Film film = new Film(filmId, title, desc, releaseYear, langId,
//	                           rentDur, rate, length, repCost, rating, features);
//	      films.add(film);
//	    }
//	    rs.close();
//	    stmt.close();
//	    conn.close();
//	  } catch (SQLException e) {
//	    e.printStackTrace();
//	  }
//	  return films;
//	}