package model;
import java.util.ArrayList;

public class Club {
	//RELATION
	ArrayList<Client> clients = new ArrayList<Client>();
	private Date creationDate;
	
	
	//ATTRIBUTES
	private int id;
	private String name;
	private String petType;
	
	//CONSTRUCTOR
	/**
	 * @param clients
	 * @param creationDate
	 * @param id
	 * @param name
	 * @param petType
	 */
	public Club(ArrayList<Client> clients, Date creationDate, int id, String name, String petType) {
		this.clients = clients;
		this.creationDate = creationDate;
		this.id = id;
		this.name = name;
		this.petType = petType;
	}

	//GETTERS & SETTERS
	public ArrayList<Client> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPetType() {
		return petType;
	}

	public void setPetType(String petType) {
		this.petType = petType;
	}
	
	
}
