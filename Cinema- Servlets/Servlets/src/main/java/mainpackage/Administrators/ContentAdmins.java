package mainpackage.Administrators;

import java.io.File;
import java.io.Serializable;

import mainpackage.Clients.Users;
import mainpackage.implementation.Mainclass;
import mainpackage.moviecatalog.Films;
import mainpackage.moviecatalog.Provoles;
import mainpackage.moviecatalog.Cinemas;

public class ContentAdmins extends Users implements Serializable{
	
	//ΠΡΟΣ ΥΛΟΠΟΙΗΣΗ
	public void insertFilm(Films film) {}
	
	public void insertCinema(Cinemas aithousa){}
		
	
	public void deleteFilm(int filmid , boolean delete) {}
	
	
	public void assignFilmToCinema(Provoles provoli) {}
	
	
	public ContentAdmins(String name,String username,String password) {super(name,username,password);}
}
