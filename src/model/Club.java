package model;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import exceptions.*;

public class Club {
	//RELATION
	private  ArrayList<Client> clients = new ArrayList<Client>();
	
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
				if (clients.get(j).getName().compareTo(clients.get(j+1).getName()) >  0) {
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
				if (clients.get(j).getLastName().compareTo(clients.get(j+1).getLastName()) >  0) {
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
				if (clients.get(j).getPreferredPetType().compareTo(clients.get(j+1).getPreferredPetType()) >  0) {
					Client tmp=clients.get(j);
					clients.set(j, clients.get(j+1));
					clients.set(j+1, tmp);					
				}
			}
		}
	}
	
	public void arrangeByNumberOfPets() {
		for (int i = clients.size(); i > 0; i-- ) {
			for (int j=0; j<i-1; j++) {
				if (clients.get(j).getPets().size() < clients.get(j+1).getPets().size()) {
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
	
	public int secuencialIdSearch(ArrayList<Client> c, int cid) {
		
		int pos = -1;
		boolean found = false;
		
		for(int i =0; i < c.size() && found == false;i++) {
			if(c.get(i).getId() == cid) {
				pos = i;
				found = true;
			}
		}
		
		return pos;
	}
	
	public int secuencialNameSearch(ArrayList<Client> c,String cname) {
		int pos = -1;
		boolean found = false;
		
		for(int i =0; i < c.size() && found == false;i++) {
			if(c.get(i).getName().equals(cname)) {
				pos = i;
				found = true;
			}
		}
		
		return pos;
	}
	
	public void deleteById(int cid) {
		arrangeById();
		try {
			clients.remove(secuencialIdSearch(clients, cid));
		}catch(NullPointerException e) {
			System.out.println("ERROR: el usuario ingresado no existe");
		}
	}
	
	public void deleteByName(String cname) {
		arrangeByName();
		try {
			clients.remove(secuencialNameSearch(clients, cname));
		} catch (NullPointerException e) {
			System.out.println("ERROR: el usuario ingresado no existe");
		}
	}
	
	public static void Guarda(String file) throws Exception {
		ArrayList<Client> clientClone = clients;
		File archivo = new File(file);
		if (archivo.exists()) {
			// the file does exist, so it upload it
			try {
				boolean noMore = false;
				while(!noMore){
					FileInputStream fs = new FileInputStream(archivo);
					ObjectInputStream ois = new ObjectInputStream(fs);
					Client cli = (Client) ois.readObject();
					System.out.println(cli.toString());
					
					ois.close();
				}
				
				System.out.println("Archivo fue cargado exitosamente");
			} catch (Exception e) {
				// Se atrapan en este bloque todos los tipos de excepción
				System.out.println("Error ... ");

			}
		} else {
			// El archivo no existe: es la primera vez que se ejecuta el programa
			try {
				for(int i=0; i<clientClone.size();i++) {
					FileOutputStream fo = new FileOutputStream(archivo);
					ObjectOutputStream oos = new ObjectOutputStream(fo);

					oos.writeObject(clientClone.get(i));
					oos.close();

					System.out.println("Archivo fue creado ... ");
				}

			
			} catch (IOException e) {
				System.out.println("Error ... ");
			} catch (NullPointerException e) {
				System.out.println("No hay clientes registrados");
			} catch (IndexOutOfBoundsException e) {
				System.out.println("No hay mas Clientes");
			}
		}
	}
	
}
