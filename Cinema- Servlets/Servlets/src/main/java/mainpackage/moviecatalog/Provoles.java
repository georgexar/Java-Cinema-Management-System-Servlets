package mainpackage.moviecatalog;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Provoles implements Serializable{

	private int provoliID;
	private Films provoliFilm;
	private Cinemas provoliCinema;
	private LocalDateTime provoliStartDate; 
	private LocalDateTime provoliEndDate;
	private int provoliNumberOfReservations;
	private boolean provoliIsAvailable;
	
	
	
	public int getProvoliID() {return this.provoliID;}
	public Films getProvoliFilm() {return this.provoliFilm;}
	public Cinemas getProvoliCinema() {return this.provoliCinema;}
	public LocalDateTime getProvoliStartDate() {return this.provoliStartDate;}
	public LocalDateTime getProvoliEndDate() {return this.provoliEndDate;}
	public int  getProvoliNumberOfReservations() {return this.provoliNumberOfReservations;}
	public boolean getProvoliIsAvailable() {return this.provoliIsAvailable;}
	public void setprovoliID(int provoliID) {this.provoliID = provoliID; }
	public void setprovoliFilm(Films provoliFilm) {this.provoliFilm = provoliFilm;}
	public void setprovoliCinema(Cinemas  provoliCinema ) {this. provoliCinema =  provoliCinema;}
	public void setprovoliStartDate(LocalDateTime provoliStartDate) {this.provoliStartDate = provoliStartDate; }
	public void setprovoliEndDate(LocalDateTime provoliEndDate) {this.provoliEndDate = provoliEndDate;}
	public void setprovoliNumberOfReservations(int provoliNumberOfReservations ) {this.provoliNumberOfReservations = provoliNumberOfReservations;}
	public void setprovoliIsAvailable(boolean provoliIsAvailable ) {this.provoliIsAvailable = provoliIsAvailable;}
	public Provoles(int provoliID,Films provoliFilm,Cinemas provoliCinema,LocalDateTime provoliStartDate,LocalDateTime provoliEndDate,int provoliNumberOfReservations,boolean provoliIsAvailable) {this.provoliID = provoliID;this.provoliFilm = provoliFilm;this. provoliCinema =  provoliCinema;this.provoliStartDate = provoliStartDate;this.provoliEndDate = provoliEndDate;this.provoliNumberOfReservations = provoliNumberOfReservations;this.provoliIsAvailable = provoliIsAvailable;}
	
	
	
	
}
