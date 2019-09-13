package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import exceptions.RepeatedException;
import exceptions.RepeatedPetException;
import model.*;

class ClubTest {
	
	Club club;
	
	void setupEscenario0() {
		club = new Club(007, "Club A", "12/12/2012", "Perro");
	}
	
	void setupEscenario1() throws RepeatedException {
		club = new Club(007, "Club A", "12/12/2012", "Perro");
		
		Client client = new Client (1006248539, "samuel", "satizabal", "26/07/2000", "Gato");
		club.addClient(client);
	}
	
	void setupEscenario2() throws RepeatedException {
		club = new Club(007, "Club A", "12/12/2012", "Perro");
		
		Client client = new Client (1006248539, "samuel", "satizabal", "26/07/2000", "Gato");
		Client client1 = new Client (6154646, "pepito", "perez", "20/01/2000", "Perro");
		Client client2 = new Client (18989994, "fulano", "perencejo", "02/02/2000", "Simio albino");
		club.addClient(client);
		club.addClient(client1);
		club.addClient(client2);
	}
	
	void setupEscenario3() throws RepeatedException, RepeatedPetException {
		club = new Club(007, "Club A", "12/12/2012", "Perro");
		
		Client client = new Client (1006248539, "samuel", "satizabal", "26/07/2000", "Gato");
		Client client1 = new Client (6154646, "pepito", "perez", "20/01/2000", "Perro");
		Client client2 = new Client (18989994, "fulano", "perencejo", "02/02/2000", "Simio albino");
		club.addClient(client);
		club.addClient(client1);
		club.addClient(client2);
		
		Pet pet = new Pet(10098, "Tom", "08/08/2010", "Masculino", "Gato");
		Pet pet2 = new Pet(15266, "Cam", "08/08/2010", "Femenino", "Perro");
		Pet pet3 = new Pet(16655, "pod", "08/08/2010", "Masculino", "Pez");
		client.addPet(pet);
		client.addPet(pet3);
		client1.addPet(pet2);
	}

	@Test
	void testAddClient() throws RepeatedException {
		setupEscenario0();
		Client client = new Client (1006248539, "samuel", "satizabal", "26/07/2000", "Gato");
		club.addClient(client);
		
		assertTrue(club.getClients().size() == 1);
	}
	
	@Test
	void testSecuencialIdSearch() throws RepeatedException {
		setupEscenario2();
		Client auxClient = club.getClients().get(club.secuencialIdSearch(club.getClients(), 1006248539));
		
		assertEquals(auxClient.getName(), "samuel");
		assertTrue(auxClient.getPreferredPetType().equals("Gato"));
	}
	
	@Test
	void tesSecuencialNameSearch() throws RepeatedException {
		setupEscenario2();
		Client auxClient = club.getClients().get(club.secuencialNameSearch(club.getClients(), "pepito"));
		Client auxClient0 = club.getClients().get(club.secuencialNameSearch(club.getClients(), "samuel"));
		
		assertEquals(auxClient.getLastName(), "perez");
		assertEquals(auxClient.getId(), 6154646);
		assertEquals(auxClient0.getLastName(), "satizabal");
		assertEquals(auxClient0.getId(), 1006248539);
	}
	
	@Test
	void testDeleteById() throws RepeatedException {
		setupEscenario1();
		club.deleteById(1006248539);
		
		assertTrue(club.getClients().size()==0);
	}
	
	@Test
	void testDeleteByName() throws RepeatedException {
		setupEscenario1();
		club.deleteByName("samuel");
		
		assertTrue(club.getClients().size() == 0);
	}
	
	@Test
	void testArrangeById() throws RepeatedException {
		setupEscenario2();
		club.arrangeById();
		
		assertTrue(club.getClients().get(0).getName().equals( "pepito"));
	}
	
	@Test
	void testArrangeByName() throws RepeatedException {
		setupEscenario2();
		club.arrangeByName();
		
		assertTrue(club.getClients().get(0).getLastName().equals("perencejo"));
	}
	
	@Test
	void testArrangeByLastName() throws RepeatedException {
		setupEscenario2();
		club.arrangeByLastName();
		
		assertEquals(club.getClients().get(0).getName(), "fulano");
	}
	
	@Test
	void testArrangeByPreferredPetType() throws RepeatedException {
		setupEscenario2();
		club.arrangeByPreferredPetType();
		
		assertEquals(club.getClients().get(0).getName(), "samuel");
	}
	
	@Test
	void testArrangeByNumberOfPets() throws RepeatedException, RepeatedPetException {
		setupEscenario3();
		club.arrangeByNumberOfPets();
		
		assertEquals(club.getClients().get(0).getName(), "samuel");
		assertNotEquals(club.getClients().get(0).getName(), "pepito");
	}

}
