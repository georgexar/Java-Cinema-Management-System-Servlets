package mainpackage.moviecatalog;

import java.io.Serializable;

public class Cinemas implements Serializable{
	
	private int cinemaId;
	private boolean cinemaIs3D;
	private int cinemaNumberOfSeats;
	
	
	public int getCinemaId() {return this.cinemaId;}
	public boolean getCinemaIs3D() {return this.cinemaIs3D;}
	public int getCinemaNumberOfSeats() {return this.cinemaNumberOfSeats;}
	public void setCinemaId(int cinemaId) {this.cinemaId = cinemaId; }
	public void setCinemaIs3D(boolean cinemaIs3D) {this.cinemaIs3D = cinemaIs3D;}
	public void setCinemaNumberOfSeats(int cinemaNumberOfSeats ) {this.cinemaNumberOfSeats = cinemaNumberOfSeats;}
	public Cinemas(int cinemaId,boolean cinemaIs3D,int cinemaNumberOfSeats) {this.cinemaId = cinemaId;this.cinemaIs3D = cinemaIs3D;this.cinemaNumberOfSeats = cinemaNumberOfSeats;}
	
	
}
