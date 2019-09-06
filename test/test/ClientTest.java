package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import model.*;

class ClientTest {

	
	Client client;
	
	@Test
	void setupEscenario0() {
		Date bDate = new Date(26,7,2000);
		client = new Client (1006248539, "samuel", "satizabal", bDate, "Gato");
	}
	
	
	void setupEscenario1() {
		Date bDate = new Date(26,7,2000);
		client = new Client (1006248539, "samuel", "satizabal", bDate, "Gato");
		
		Date petDate = new Date(23, 9, 2001);
		Pet pet = new Pet(10098, "Tom", petDate, 'M', "Gato");
		client.addPet(pet);
		
		
	}
	
	@Test
	void testAddPet() {
		setupEscenario0();
		Date petDate = new Date(23, 9, 2001);
		Pet pet = new Pet(10098, "Tom", petDate, 'M', "Gato");
		client.addPet(pet);
	}
	
	@Test
	void testDeletePet() {
		setupEscenario1();
		ArrayList<Pet> pets2 = new ArrayList<Pet>();
		
		client.deletePetById(10098);
		assertEquals(client.getPets().size(), pets2.size());
		
	}

}
