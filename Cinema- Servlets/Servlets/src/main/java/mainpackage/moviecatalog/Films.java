package mainpackage.moviecatalog;

import java.io.Serializable;

public class Films implements Serializable{

	private int filmId;
	private String filmTitle;
	private String filmCategory;
	private String filmDescription;
	public Films(int filmId,String filmTitle,String filmCategory,String filmDescription) {this.filmId=filmId;this.filmTitle=filmTitle;this.filmCategory=filmCategory;this.filmDescription=filmDescription;}
	
	
	
	public String getFilmTitle() {return this.filmTitle;}
	public String getFilmCategory() {return this.filmCategory;}
	public String getFilmDescription() {return this.filmDescription;}
	public int getFilmId() {return this.filmId;}
	public void setFilmTitle(String filmTitle) {this.filmTitle = filmTitle; }
	public void setFilmCategory(String FilmCategory) {this.filmCategory = FilmCategory;}
	public void setFilmDescription(String filmDescription) {this.filmDescription = filmDescription;}
	public void setFilmId(int filmId) {this.filmId=filmId;}
	
	
	
	
	
}