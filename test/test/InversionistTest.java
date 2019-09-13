package test;

import static org.junit.jupiter.api.Assertions.*;
import model.*;

import org.junit.jupiter.api.Test;

import exceptions.RepeatedException;

class InversionistTest {
	Inversionist inv;
	
	void setupEscenario0() {
		 inv = new Inversionist();
	}
	
	void setupEscenario1() {
		inv = new Inversionist();
		Club club = new Club(15616, "Picardia Club", "01/01/2001", "Simios");
		Club club1 = new Club(654864, "Chozo Club", "07/01/2010", "Focas");
		Club club2 = new Club(59989, "Main Club", "02/12/2008", "Hormigas");
		
		inv.addClub(club);
		inv.addClub(club1);
		inv.addClub(club2);
	}
	
	void setupEscenario2() {
		inv = new Inversionist();
		
		Club club = new Club(15616, "Picardia Club", "01/01/2001", "Simios");
		inv.addClub(club);
	}

	@Test
	void testAddClub() {
		setupEscenario0();
		Club club = new Club(15616, "Picardia Club", "01/01/2001", "Simios");
		inv.addClub(club);
		
		assertEquals(inv.getClubs().size(), 1);
		assertEquals(inv.getClubs().get(0).getName(), "Picardia Club");
	}
	
	@Test
	void testSecuencialIdSearch() {
		setupEscenario1();
		Club auxClub = inv.secuencialIdSearch(654864);
		
		assertEquals(auxClub.getName(), "Chozo Club");
		assertEquals(auxClub.getPetType(), "Focas");
	}
	
	@Test
	void testSecuencialNameSearch() {
		setupEscenario1();
		Club auxClub = inv.secuencialNameSearch("Main Club");
		
		assertEquals(auxClub.getId(), 59989);
		assertEquals(auxClub.getPetType(), "Hormigas");
	}
	
	@Test
	void testArrangeById() {
		setupEscenario1();
		inv.arrangeById();
		
		assertTrue(inv.getClubs().get(0).getId() == 15616);
	}
	
	@Test
	void testArrangeByName() {
		setupEscenario1();
		inv.arrangeByName();
		
		assertTrue(inv.getClubs().get(0).getId() == 654864);
	}
	
	@Test
	void testArrangeByCreationDate() {
		setupEscenario1();
		inv.arrangeByCreationDate();
		
		assertTrue(inv.getClubs().get(0).getId() == 15616);
	}
	
	@Test
	void testDeleteClubById() {
		setupEscenario2();
		inv.deleteClubById(15616);
		
		assertTrue(inv.getClubs().size() == 0);
	}
	
	@Test
	void testDeleteClubByName() {
		setupEscenario2();
		inv.deleteClubByName("Picardia Club");
		
		assertTrue(inv.getClubs().size() == 0);
	}

}
