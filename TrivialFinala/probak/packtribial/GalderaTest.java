package packtribial;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class GalderaTest {
	
	Galdera pGal1, pGal2, pGal3, pGal4;
	ListaGalderak pListaGaldera;
	

	@Before
	public void setUp() throws Exception {
		
		
		
		pGal1 = new Galdera ("Zein da Espainiaren kapitala?",  "1) Bartzelona",  "2) Bilbao", "3) Extremadura", "4) Madril", 4);
		pGal2 = new Galdera ("Zein da F1an korrika egiten duen Alonsoren izena?",  "1) Jon",  "2) Fernando", "3) Camilo", "4) Paco", 2);
		pGal3 = new Galdera ("Zein da Frantziaren kapitala?",  "1) Bartzelona",  "2) Luxenburgo", "3) Paris", "4) Notre Dame", 3);
		pGal4 = new Galdera ("Nork da Cars filmaren protagonista?",  "1) Rayo McQueen",  "2) Mate", "3) Rayo McKing", "4) Espidi Gonzalez", 1);
		
	}

	@After
	public void tearDown() throws Exception {
		
		pGal1=null;
		pGal2=null;
		pGal3=null;
		pGal4=null;
		
		
	}

	@Test
	public void testGaldera() {
		
		assertNotNull(pGal1);
		assertNotNull(pGal2);
		assertNotNull(pGal3);
		assertNotNull(pGal4);
	}

	@Test
	public void testImprimatuGaldera() {
		
		assertNotNull(pGal1);
		assertNotNull(pGal2);
		assertNotNull(pGal3);
		assertNotNull(pGal4);
	}

	@Test
	public void testErantzunZuzena() {
		
		assertTrue(pGal1.erantzunZuzena());
		assertFalse(pGal1.erantzunZuzena());
		assertTrue(pGal2.erantzunZuzena());
		assertFalse(pGal2.erantzunZuzena());
		assertTrue(pGal3.erantzunZuzena());
		assertFalse(pGal3.erantzunZuzena());
		assertTrue(pGal4.erantzunZuzena());
		assertFalse(pGal4.erantzunZuzena());
		
	}

}
