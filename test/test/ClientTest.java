package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import exceptions.RepeatedPetException;
import model.*;

class ClientTest {

	
	Client client;
	
	
	void setupEscenario0() {
		
		client = new Client (1006248539, "samuel", "satizabal", "26/07/2000", "Gato");
	}
	
	
	void setupEscenario1() throws RepeatedPetException {
		
		client = new Client (1006248539, "samuel", "satizabal", "26/07/2000", "Gato");
	
		Pet pet = new Pet(10098, "Tom", "08/08/2010", "Masculino", "Gato");
		client.addPet(pet);
	}
	
	void setupEscenario2() throws RepeatedPetException {
		
		client = new Client (1006248539, "samuel", "satizabal", "26/07/2000", "Gato");
	
		Pet pet = new Pet(10098, "Tom", "08/08/2010", "Masculino", "Gato");
		Pet pet2 = new Pet(15266, "Cam", "08/08/2010", "Femenino", "Perro");
		Pet pet3 = new Pet(16655, "pod", "08/08/2010", "Masculino", "Pez");
		client.addPet(pet);
		client.addPet(pet3);
		client.addPet(pet2);
		
	}
	
	@Test
	void testAddPet() throws RepeatedPetException {
		setupEscenario0();
		Pet pet = new Pet(10098, "Tom", "08/08/2010", "Masculino", "Gato");
		client.addPet(pet);
		
		assertTrue(client.getPets().size() == 1);
		
		
	}
	
	@Test
	void testDeletePetById() throws RepeatedPetException {
		setupEscenario1();
		ArrayList<Pet> pets2 = new ArrayList<Pet>();
		
		client.deletePetById(10098);
		assertEquals(client.getPets().size(), pets2.size());
		
	}
	
	@Test
	void testDeletePetByName() throws RepeatedPetException {
		setupEscenario1();
		ArrayList<Pet> pets2 = new ArrayList<Pet>();
		
		client.deletePetByName("Tom");
		assertEquals(client.getPets().size(), pets2.size());
		
	}
	
	@Test
	void testArrangeById() throws RepeatedPetException {
		setupEscenario2();
		client.arrangeById();
		
		assertEquals(client.getPets().get(0).getId(), 10098);
		assertNotEquals(client.getPets().get(0).getId(), 99998);
		assertEquals(client.getPets().get(1).getId(), 15266);
	}
	
	@Test
	void testArrangeByname() throws RepeatedPetException {
		setupEscenario2();
		client.arrangeByName();
		
		assertEquals(client.getPets().get(0).getName(), "Cam");
		assertEquals(client.getPets().get(1).getName(), "Tom");
		assertEquals(client.getPets().get(2).getName(), "pod");
	}
	
	@Test
	void testArrangeByGender() throws RepeatedPetException {
		setupEscenario2();
		client.arrangeByGender();
		
		assertEquals(client.getPets().get(0).getGender(), "Femenino");
		assertEquals(client.getPets().get(1).getGender(), "Masculino");
		assertEquals(client.getPets().get(2).getGender(), "Masculino");
	}
	
	@Test
	void testArrangeByType() throws RepeatedPetException {
		setupEscenario2();
		client.arrangeByType();
		
		assertTrue(client.getPets().get(0).getType().equals("Gato"));
		assertTrue(client.getPets().get(1).getType().equals("Perro"));
		assertTrue(client.getPets().get(2).getType().equals("Pez"));
	}
	
	@Test
	void testBinaryId() throws RepeatedPetException {
		setupEscenario2();
		client.arrangeById();
		Pet auxPet = client.binaryId(client.getPets(), 15266);
		
		assertEquals(auxPet.getName(), "Cam");
		assertEquals(auxPet.getType(), "Perro");
	}
	
	@Test
	void testBinaryName() throws RepeatedPetException {
		setupEscenario2();
		client.arrangeByName();
		Pet auxPet = client.binaryName(client.getPets(), "Tom");
		
		assertEquals(auxPet.getId(), 10098);
		assertEquals(auxPet.getType(), "Gato");
	}
	
}
