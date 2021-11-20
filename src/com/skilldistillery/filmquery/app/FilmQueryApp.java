package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {
  
  DatabaseAccessor db = new DatabaseAccessorObject();

  public static void main(String[] args) throws SQLException {
    FilmQueryApp app = new FilmQueryApp();
//    app.test();
    app.launch();
  }

  private void test() throws SQLException {
	   
//    Film film = db.findFilmById(1);
//    System.out.println(film);
//    Actor actor = db.findActorById(1);
//    System.out.println(actor);
//    System.out.println(db.findActorsByFilmId(3));
//    System.out.println(db.findFilmByActorId(3));
	  System.out.println(db.findFilmByKeyword("composer" ));
    
  }

  private void launch() throws SQLException {
    Scanner input = new Scanner(System.in);
    
    
    startUserInterface(input);
    
    
    input.close();
  }

  private void startUserInterface(Scanner input) throws SQLException {
	  System.out.println("------------------------------------------");
	  System.out.println("Please Choose the following option:");
	  System.out.println("1. You can look up a film by it's ID:");
	  System.out.println("2. You can look up a film by it's keyword");
	  System.out.println("3. Exit");
	  System.out.println("------------------------------------------");
	  boolean keepdoing = true;
	  while(keepdoing==true) {
		  
		  int userChoice = input.nextInt();
		  switch(userChoice) {
		  case 1:
			  System.out.println("Please enter the film ID");
			  int filmId = input.nextInt();
			  if(db.findFilmById(filmId)!=null) {
			  Film film = db.findFilmById(filmId);
			  System.out.println(film);
			  }else {
				  System.out.println("Please provide correct film ID");
				  System.out.println("Try again....");
			  }
			  break;
		  case 2:
			  System.out.println("Please enter the Title Keyword or DescriptionK keyword");
			  String filmKeyword = input.nextLine();
			  if(db.findFilmByKeyword(filmKeyword)!=null) {
				  System.out.println(db.findFilmByKeyword(filmKeyword));
			  }else {
				  System.out.println("Please give me the correct keywords");
				  System.out.println("Try again....");
			  }
			  break;
		  case 3:
			  
			  System.out.println("Exiting......");
			  keepdoing = false;
			  break;
		  }
	  }
	  
	  
  }

}
