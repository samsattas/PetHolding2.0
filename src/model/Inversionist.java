package model;
import java.util.ArrayList;

public class Inversionist {
	//RELATION
	ArrayList<Club> clubs = new ArrayList<Club>();
	
	//CONSTRUCTOR
	/**
	 * @param clubs
	 */
	public Inversionist() {
		super();
		
	}
	
	
	
	/**
	 * @return the clubs
	 */
	public ArrayList<Club> getClubs() {
		return clubs;
	}



	/**
	 * @param clubs the clubs to set
	 */
	public void setClubs(ArrayList<Club> clubs) {
		this.clubs = clubs;
	}



	public void addClub(Club club) {
		clubs.add(club);
	}
	
	public void deleteClubById(int id) {
		
	}
	
	public void deleteClubByName(String name) {
		
	}
	
	
}
