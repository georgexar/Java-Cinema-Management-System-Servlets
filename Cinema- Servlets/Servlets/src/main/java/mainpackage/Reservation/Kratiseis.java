package mainpackage.Reservation;

import java.io.Serializable;

public class Kratiseis implements Serializable {
	private String provoliId;
	private int theseiskratisis;
	public Kratiseis(String provoliId,int theseiskratisis) {this.provoliId=provoliId;this.theseiskratisis=theseiskratisis;}
	public void setMovieId(String Id) {this.provoliId=Id;}
	public void setTheseisKratisis(int num) {this.theseiskratisis=num;}
	public String getMovieId() {return this.provoliId;}
	public int getTheseisKratisis() {return this.theseiskratisis;}
	
	

}