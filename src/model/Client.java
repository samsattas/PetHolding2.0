package model;
import java.io.Serializable;
import java.util.ArrayList;

public class Client implements Serializable{
	//RELATION
	ArrayList<Pet> pets = new ArrayList<Pet>();

	//ATTRIBUTES
	private int id;
	private String name;
	private String lastName;
	private Date bDate;
	private String preferredPetType;
	
	//CONSTRUCTOR
	/**
	 * @param pets
	 * @param id
	 * @param name
	 * @param lastName
	 * @param bDate
	 * @param preferredPetType
	 */
	public Client(int id, String name, String lastName, Date bDate, String preferredPetType) {
		super();
		
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.bDate = bDate;
		this.preferredPetType = preferredPetType;
	}

	/**
	 * @return the pets
	 */
	public ArrayList<Pet> getPets() {
		return pets;
	}

	/**
	 * @param pets the pets to set
	 */
	public void setPets(ArrayList<Pet> pets) {
		this.pets = pets;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the bDate
	 */
	public Date getbDate() {
		return bDate;
	}

	/**
	 * @param bDate the bDate to set
	 */
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}

	/**
	 * @return the preferredPetType
	 */
	public String getPreferredPetType() {
		return preferredPetType;
	}

	/**
	 * @param preferredPetType the preferredPetType to set
	 */
	public void setPreferredPetType(String preferredPetType) {
		this.preferredPetType = preferredPetType;
	}
	
	public void addPet(Pet pet) {
		pets.add(pet);
	}
	
	public void ordenamientoB() {
		
	}
	
	
	/**
	 * @param a
	 * @param find
	 * @return
	 */
	public Pet binaryId(ArrayList<Pet> a, int find) {
		Pet found = null;
		boolean aux = false;
		int start = 0;
		int end = a.size() -1;
		while(start <= end && aux==false) {
			int middle = (start + end)/2;
			if(a.get(middle).getId()==find) {
				found = a.get(middle);
				aux = true;
			}else if(a.get(middle).getId()>find) {
				end = middle -1;
			}else {
				start = middle + 1;
			}
		}
		
		
		return found;
	}
	
	/**
	 * @param a
	 * @param find
	 * @return
	 */
	public Pet binaryName(ArrayList<Pet> a, String find) {
		Pet found = null;
		boolean aux = false;
		int start = 0;
		int end = a.size() -1;
		while(start <= end && aux==false) {
			int middle = (start + end)/2;
			if(a.get(middle).getName().equals(find)) {
				found = a.get(middle);
				aux = true;
			}else if(a.get(middle).getName().compareTo(find)<0) {
				end = middle -1;
			}else {
				start = middle + 1;
			}
		}
		
		
		return found;
	}
	
	public void deletePetById(int pid) {
		ordenamientoB();
		try {
			pets.remove(binaryId(pets, pid));
		}catch(Exception e) {
			System.out.println("ERROR: la mascota ingresada no existe");
		}
		
	}
	
}
