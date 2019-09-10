package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import model.*;

class ClientTest {

	
	Client client;
	
	
	void setupEscenario0() {
		
		client = new Client (1006248539, "samuel", "satizabal", "26/07/2000", "Gato");
	}
	
	
	void setupEscenario1() {
		
		client = new Client (1006248539, "samuel", "satizabal", "26/07/2000", "Gato");
		
		
		Pet pet = new Pet(10098, "Tom", "08/08/2010", "Masculino", "Gato");
		client.addPet(pet);
		
		
	}
	
	@Test
	void testAddPet() {
		setupEscenario0();
		Pet pet = new Pet(10098, "Tom", "08/08/2010", "Masculino", "Gato");
		client.addPet(pet);
		
	}
	
	@Test
	void testDeletePetById() {
		setupEscenario1();
		ArrayList<Pet> pets2 = new ArrayList<Pet>();
		
		client.deletePetById(10098);
		assertEquals(client.getPets().size(), pets2.size());
		
	}
	
	@Test
	void testDeletePetByName() {
		setupEscenario1();
		ArrayList<Pet> pets2 = new ArrayList<Pet>();
		
		client.deletePetByName("Tom");
		assertEquals(client.getPets().size(), pets2.size());
		
	}

}
