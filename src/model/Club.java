package model;
import java.util.ArrayList;
import exceptions.*;

public class Club {
	//RELATION
	ArrayList<Client> clients = new ArrayList<Client>();
	
	//ATTRIBUTES
	private int id;
	private String name;
	private String creationDate;
	private String petType;
	
	//CONSTRUCTOR
	/**
	 * @param clients
	 * @param creationDate
	 * @param id
	 * @param name
	 * @param petType
	 */
	public Club(  int id, String name,String creationDate, String petType) {
		
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

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
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
	
	public void arrangeById() {		
		for (int i = clients.size(); i > 0; i-- ) {
			for (int j=0; j<i-1; j++) {
				if (clients.get(j).getId() > clients.get(j+1).getId() ) {
					Client tmp=clients.get(j);
					clients.set(j, clients.get(j+1));
					clients.set(j+1, tmp);					
				}
			}
		}		
	}
	
	
	
	public void arrangeByName() {
		for (int i = clients.size(); i > 0; i-- ) {
			for (int j=0; j<i-1; j++) {
				if (clients.get(j).getName().compareTo(clients.get(j+1).getName()) >=  1) {
					Client tmp=clients.get(j);
					clients.set(j, clients.get(j+1));
					clients.set(j+1, tmp);					
				}
			}
		}	
	}

	public void arrangeByLastName() {
		for (int i = clients.size(); i > 0; i-- ) {
			for (int j=0; j<i-1; j++) {
				if (clients.get(j).getLastName().compareTo(clients.get(j+1).getLastName()) >=  1) {
					Client tmp=clients.get(j);
					clients.set(j, clients.get(j+1));
					clients.set(j+1, tmp);					
				}
			}
		}
	}
	
	public void arrangeByPreferredPetType() {
		for (int i = clients.size(); i > 0; i-- ) {
			for (int j=0; j<i-1; j++) {
				if (clients.get(j).getPreferredPetType().compareTo(clients.get(j+1).getPreferredPetType()) >=  1) {
					Client tmp=clients.get(j);
					clients.set(j, clients.get(j+1));
					clients.set(j+1, tmp);					
				}
			}
		}
	}
	
	
	
	
	public void addClient (Client client) throws RepeatedException{
		boolean rep = false;
		for(int i = 0; i<clients.size();i++) {
			if(clients.get(i).getId() == client.getId()) {
				rep = true;
			}
		}
		
		if(rep == false) {
			clients.add(client);
		}else {
			throw new RepeatedException();
		}
	}
	
	public Client secuencialIdSearch(int cid) {
		Client client = null;
		boolean found = false;
		
		for(int i =0; i < clients.size()-1 && found == false;i++) {
			if(clients.get(i).getId() == cid) {
				client = clients.get(i);
				found = true;
			}
		}
		
		return client;
	}
	
	public Client secuencialNameSearch(String cid) {
		Client client = null;
		boolean found = false;
		
		for(int i =0; i < clients.size()-1 && found == false;i++) {
			if(clients.get(i).getName().equals(cid)) {
				client = clients.get(i);
				found = true;
			}
		}
		
		return client;
	}
	
	public void deleteById(int cid) {
		clients.remove(secuencialIdSearch(cid));
	}
	
	public void deleteByName(String cid) {
		clients.remove(secuencialNameSearch(cid));
	}
	
}
