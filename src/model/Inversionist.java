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
	
	public Club secuencialIdSearch(int cid) {
		Club auxClub = null;
		boolean found = false;
		
		for(int i =0; i < clubs.size() && found == false;i++) {
			if(clubs.get(i).getId() == cid) {
				auxClub = clubs.get(i);
				found = true;
			}
		}
		
		return auxClub;
	}
	
	public Club secuencialNameSearch(String cname) {
		Club auxClub = null;
		boolean found = false;
		
		for(int i =0; i < clubs.size() && found == false;i++) {
			if(clubs.get(i).getName().equals(cname)) {
				auxClub = clubs.get(i);
				found = true;
			}
		}		
		return auxClub;
	}
	
	public void arrangeById() {
		for (int i=0; i < clubs.size(); i++ ) {
			for (int j=i; j>0 && clubs.get(j-1).getId() > clubs.get(j).getId() ; j--) {
				Club tmp=clubs.get(j);
				clubs.set(j, clubs.get(j-1));
				clubs.set(j-1, tmp);
			}
		}
	}
	
	public void arrangeByName() {
		for (int i=1; i < clubs.size(); i++ ) {
			for (int j=i; j>0 && clubs.get(j-1).getName().compareTo(clubs.get(j).getName()) > 0 ; j--) {
				Club tmp = clubs.get(j);
				clubs.set(j, clubs.get(j-1));
				clubs.set(j-1, tmp);
			}
		}
	}
	
	public void arrangeByCreationDate() {
		for (int i=1; i < clubs.size(); i++ ) {
			for (int j=i; j>0 && clubs.get(j-1).getCreationDate().compareTo(clubs.get(j).getCreationDate()) > 0 ; j--) {
				Club tmp = clubs.get(j);
				clubs.set(j, clubs.get(j-1));
				clubs.set(j-1, tmp);
			}
		}
	}
	
	public void arrangeByPetType() {
		for (int i=1; i < clubs.size(); i++ ) {
			for (int j=i; j>0 && clubs.get(j-1).getPetType().compareTo(clubs.get(j).getPetType()) > 0 ; j--) {
				Club tmp = clubs.get(j);
				clubs.set(j, clubs.get(j-1));
				clubs.set(j-1, tmp);
			}
		}
	}
	
	public void deleteClubById(int cid) {
		arrangeById();
		clubs.remove(secuencialIdSearch(cid));
	}
	
	public void deleteClubByName(String cname) {
		arrangeByName();
		clubs.remove(secuencialNameSearch(cname));
	}
	
	
}
