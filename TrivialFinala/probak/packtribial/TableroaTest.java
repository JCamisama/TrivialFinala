package packtribial;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TableroaTest {
	Tableroa tableroBat;
	ListaGaztatxoak lista;
	@Before
	public void setUp() throws Exception {
		tableroBat=Tableroa.getNireTableroa();
		tableroBat.tableroaHasieratu();
		lista= new ListaGaztatxoak();
		ListaGalderak.getNireListaGalderak().galderakKonfiguratu();
	}

	@After
	public void tearDown() throws Exception {
		tableroBat.erreseteatu();
		lista=null;
	}

	@Test
	public void testGetNireTableroa() {
		assertNotNull(tableroBat);
	}

	
	@Test
	public void testFitxaMugituTxandaJarraitu() {
		//Hasierako pasilloan eta hasierako pasilloan jarraitu, lauki normalan
		JokalariaAldaketak jokalaria=null;
		jokalaria=tableroBat.fitxaMugitu(true, 0, 0, lista, 3);
		assertTrue(jokalaria.getTxandarenEmaitza());
		jokalaria=tableroBat.fitxaMugitu(true, 0, 0, lista, 3);
		assertFalse(jokalaria.getTxandarenEmaitza());
		
	}
	
	@Test
	public void testFitxaMugituZerogarrenPasilloa() {
		//Hasierako pasilloan eta hasierako pasilloan jarraitu, lauki normalan
		tableroBat.fitxaMugitu(true, 0, 0, lista, 3);
	}
	
	@Test
	public void testFitxaMugituZerogarrenPasilloa2() {
		//Hasierako pasilloan eta hasierako pasilloan jarraitu, lauki gaztadunean
		tableroBat.fitxaMugitu(true, 0, 3, lista, 3);
	}
	
	@Test
	public void testFitxaMugituZerogarrenPasilloa3() {
		//Hasierako pasilloan eta zirkuluan amaitu, lauki normalean
		tableroBat.fitxaMugitu(true, 0, 4, lista, 5);
	}
	
	@Test
	public void testFitxaMugituLehenengoPasilloa() {
		//Hasierako pasilloan eta hasierako pasilloan jarraitu, lauki normalan
		tableroBat.fitxaMugitu(true, 1, 0, lista, 3);
	}
	
	@Test
	public void testFitxaMugituLehenengoPasilloa2() {
		//Hasierako pasilloan eta hasierako pasilloan jarraitu, lauki gaztadunean
		tableroBat.fitxaMugitu(true, 1, 3, lista, 3);
	}
	
	@Test
	public void testFitxaMugituLehenengoPasilloa3() {
		//Hasierako pasilloan eta zirkuluan amaitu, lauki normalean
		tableroBat.fitxaMugitu(true, 1, 4, lista, 5);
	}
	@Test
	public void testFitxaMugituBigarrenPasilloa() {
		//Hasierako pasilloan eta hasierako pasilloan jarraitu, lauki normalan
		tableroBat.fitxaMugitu(true, 2, 0, lista, 3);
	}
	
	@Test
	public void testFitxaMugituBigarrenPasilloa2() {
		//Hasierako pasilloan eta hasierako pasilloan jarraitu, lauki gaztadunean
		tableroBat.fitxaMugitu(true, 2, 3, lista, 3);
	}
	
	@Test
	public void testFitxaMugituBigarrenPasilloa3() {
		//Hasierako pasilloan eta zirkuluan amaitu, lauki normalean
		tableroBat.fitxaMugitu(true, 2, 4, lista, 5);
	}
	@Test
	public void testFitxaMugituHirugarrenPasilloa() {
		//Hasierako pasilloan eta hasierako pasilloan jarraitu, lauki normalan
		tableroBat.fitxaMugitu(true, 3, 0, lista, 3);
	}
	
	@Test
	public void testFitxaMugituHirugarrenPasilloa2() {
		//Hasierako pasilloan eta hasierako pasilloan jarraitu, lauki gaztadunean
		tableroBat.fitxaMugitu(true, 3, 3, lista, 3);
	}
	
	@Test
	public void testFitxaMugituHirugarrenPasilloa3() {
		//Hasierako pasilloan eta zirkuluan amaitu, lauki normalean
		tableroBat.fitxaMugitu(true, 3, 4, lista, 5);
	}
	@Test
	public void testFitxaMugituLaugarrenPasilloa() {
		//Hasierako pasilloan eta hasierako pasilloan jarraitu, lauki normalan
		tableroBat.fitxaMugitu(true, 4, 0, lista, 3);
	}
	
	@Test
	public void testFitxaMugituLaugarrenPasilloa2() {
		//Hasierako pasilloan eta hasierako pasilloan jarraitu, lauki gaztadunean
		tableroBat.fitxaMugitu(true, 4, 3, lista, 3);
	}
	
	@Test
	public void testFitxaMugituLaugarrenPasilloa3() {
		//Hasierako pasilloan eta zirkuluan amaitu, lauki normalean
		tableroBat.fitxaMugitu(true, 4, 4, lista, 5);
	}
	@Test
	public void testFitxaMugituBostgarrenPasilloa() {
		//Hasierako pasilloan eta hasierako pasilloan jarraitu, lauki normalan
		tableroBat.fitxaMugitu(true, 5, 0, lista, 3);
	}
	
	@Test
	public void testFitxaMugituBostgarrenPasilloa2() {
		//Hasierako pasilloan eta hasierako pasilloan jarraitu, lauki gaztadunean
		tableroBat.fitxaMugitu(true, 5, 3, lista, 3);
	}
	
	@Test
	public void testFitxaMugituBostgarrenPasilloa3() {
		//Hasierako pasilloan eta zirkuluan amaitu, lauki normalean
		tableroBat.fitxaMugitu(true, 5, 4, lista, 5);
	}
	
	
	@Test
	public void testFitxaMugituZirkuluan() {
		//Zirkuluan eta zirkuluan jarraitu, lauki normalean
		tableroBat.fitxaMugitu(false, 0, 4, lista, 5);
	}
	@Test
	public void testFitxaMugituZirkuluan2() {
		
		JokalariaAldaketak jokalaria=null;
		
		lista.gehituGaztatxoa("gorria");
		lista.gehituGaztatxoa("laranja");
		lista.gehituGaztatxoa("urdina");
		lista.gehituGaztatxoa("horia");
		lista.gehituGaztatxoa("morea");
		//Zirkuluan eta 1. pasilloan sartu, lauki normalean
		jokalaria=tableroBat.fitxaMugitu(false, 0, 5, lista, 1);
		assertTrue(jokalaria.getHasierakoPasilloa());
		assertEquals(jokalaria.getPosizioaZutabea(),6);
		assertEquals(jokalaria.getPosizioaErrenkada(),1);
	}
	
	@Test
	public void testFitxaMugituZerogarrenAmaiera() {
		
		JokalariaAldaketak jokalaria=null;
		
		lista.gehituGaztatxoa("gorria");
		lista.gehituGaztatxoa("laranja");
		lista.gehituGaztatxoa("urdina");
		lista.gehituGaztatxoa("horia");
		lista.gehituGaztatxoa("morea");
		lista.gehituGaztatxoa("berdea");
		//0. pasilloan eta 0. pasilloan jarraitu, lauki normalean
		jokalaria=tableroBat.fitxaMugitu(true, 0, 6, lista, 1);
		assertTrue(jokalaria.getHasierakoPasilloa());
		assertEquals(jokalaria.getPosizioaZutabea(),5);
		assertEquals(jokalaria.getPosizioaErrenkada(),0);
	}

	@Test
	public void testFitxaMugituZerogarrenAmaieraKasilla() {
		
		JokalariaAldaketak jokalaria=null;
		
		lista.gehituGaztatxoa("gorria");
		lista.gehituGaztatxoa("laranja");
		lista.gehituGaztatxoa("urdina");
		lista.gehituGaztatxoa("horia");
		lista.gehituGaztatxoa("morea");
		lista.gehituGaztatxoa("berdea");
		//0. pasilloan eta 0. pasilloan jarraitu, lauki normalean
		jokalaria=tableroBat.fitxaMugitu(true, 0, 6, lista, 6);
		assertTrue(jokalaria.getHasierakoPasilloa());
		assertEquals(jokalaria.getPosizioaZutabea(),0);
		assertEquals(jokalaria.getPosizioaErrenkada(),0);
		assertTrue(jokalaria.getPartidaAmaituDa());
		}
	
	@Test
	public void testFitxaMugituLehenengoAmaiera() {
		
		JokalariaAldaketak jokalaria=null;
		
		lista.gehituGaztatxoa("gorria");
		lista.gehituGaztatxoa("laranja");
		lista.gehituGaztatxoa("urdina");
		lista.gehituGaztatxoa("horia");
		lista.gehituGaztatxoa("morea");
		lista.gehituGaztatxoa("berdea");
		//0. pasilloan eta 0. pasilloan jarraitu, lauki normalean
		jokalaria=tableroBat.fitxaMugitu(true, 1, 6, lista, 1);
		assertTrue(jokalaria.getHasierakoPasilloa());
		assertEquals(jokalaria.getPosizioaZutabea(),5);
		assertEquals(jokalaria.getPosizioaErrenkada(),1);
	}
	
	@Test
	public void testFitxaMugituLehenengoAmaieraKasilla() {
		
		JokalariaAldaketak jokalaria=null;
		
		lista.gehituGaztatxoa("gorria");
		lista.gehituGaztatxoa("laranja");
		lista.gehituGaztatxoa("urdina");
		lista.gehituGaztatxoa("horia");
		lista.gehituGaztatxoa("morea");
		lista.gehituGaztatxoa("berdea");
		//0. pasilloan eta 0. pasilloan jarraitu, lauki normalean
		jokalaria=tableroBat.fitxaMugitu(true, 1, 6, lista, 6);
		assertTrue(jokalaria.getHasierakoPasilloa());
		assertEquals(jokalaria.getPosizioaZutabea(),0);
		assertEquals(jokalaria.getPosizioaErrenkada(),1);
		assertTrue(jokalaria.getPartidaAmaituDa());
	}
	
	@Test
	public void testFitxaMugituBigarrenAmaiera() {
		
		JokalariaAldaketak jokalaria=null;
		
		lista.gehituGaztatxoa("gorria");
		lista.gehituGaztatxoa("laranja");
		lista.gehituGaztatxoa("urdina");
		lista.gehituGaztatxoa("horia");
		lista.gehituGaztatxoa("morea");
		lista.gehituGaztatxoa("berdea");
		//0. pasilloan eta 0. pasilloan jarraitu, lauki normalean
		jokalaria=tableroBat.fitxaMugitu(true, 2, 6, lista, 1);
		assertTrue(jokalaria.getHasierakoPasilloa());
		assertEquals(jokalaria.getPosizioaZutabea(),5);
		assertEquals(jokalaria.getPosizioaErrenkada(),2);
	}
	
	@Test
	public void testFitxaMugituBigarrenAmaieraKasilla() {
		
		JokalariaAldaketak jokalaria=null;
		
		lista.gehituGaztatxoa("gorria");
		lista.gehituGaztatxoa("laranja");
		lista.gehituGaztatxoa("urdina");
		lista.gehituGaztatxoa("horia");
		lista.gehituGaztatxoa("morea");
		lista.gehituGaztatxoa("berdea");
		//0. pasilloan eta 0. pasilloan jarraitu, lauki normalean
		jokalaria=tableroBat.fitxaMugitu(true, 2, 6, lista, 6);
		assertTrue(jokalaria.getHasierakoPasilloa());
		assertEquals(jokalaria.getPosizioaZutabea(),0);
		assertEquals(jokalaria.getPosizioaErrenkada(),2);
		assertTrue(jokalaria.getPartidaAmaituDa());
	}
	
	@Test
	public void testFitxaMugituHirugarrenAmaiera() {
		
		JokalariaAldaketak jokalaria=null;
		
		lista.gehituGaztatxoa("gorria");
		lista.gehituGaztatxoa("laranja");
		lista.gehituGaztatxoa("urdina");
		lista.gehituGaztatxoa("horia");
		lista.gehituGaztatxoa("morea");
		lista.gehituGaztatxoa("berdea");
		//0. pasilloan eta 0. pasilloan jarraitu, lauki normalean
		jokalaria=tableroBat.fitxaMugitu(true, 3, 6, lista, 1);
		assertTrue(jokalaria.getHasierakoPasilloa());
		assertEquals(jokalaria.getPosizioaZutabea(),5);
		assertEquals(jokalaria.getPosizioaErrenkada(),3);
	}
	
	@Test
	public void testFitxaMugituHirugarrenAmaieraKasilla() {
		
		JokalariaAldaketak jokalaria=null;
		
		lista.gehituGaztatxoa("gorria");
		lista.gehituGaztatxoa("laranja");
		lista.gehituGaztatxoa("urdina");
		lista.gehituGaztatxoa("horia");
		lista.gehituGaztatxoa("morea");
		lista.gehituGaztatxoa("berdea");
		//0. pasilloan eta 0. pasilloan jarraitu, lauki normalean
		jokalaria=tableroBat.fitxaMugitu(true, 3, 6, lista, 6);
		assertTrue(jokalaria.getHasierakoPasilloa());
		assertEquals(jokalaria.getPosizioaZutabea(),0);
		assertEquals(jokalaria.getPosizioaErrenkada(),3);
		assertTrue(jokalaria.getPartidaAmaituDa());
	}
	
	@Test
	public void testFitxaMugituLaugarrenAmaiera() {
		
		JokalariaAldaketak jokalaria=null;
		
		lista.gehituGaztatxoa("gorria");
		lista.gehituGaztatxoa("laranja");
		lista.gehituGaztatxoa("urdina");
		lista.gehituGaztatxoa("horia");
		lista.gehituGaztatxoa("morea");
		lista.gehituGaztatxoa("berdea");
		//0. pasilloan eta 0. pasilloan jarraitu, lauki normalean
		jokalaria=tableroBat.fitxaMugitu(true, 4, 6, lista, 1);
		assertTrue(jokalaria.getHasierakoPasilloa());
		assertEquals(jokalaria.getPosizioaZutabea(),5);
		assertEquals(jokalaria.getPosizioaErrenkada(),4);
	}
	
	@Test
	public void testFitxaMugituLaugarrenAmaieraKasilla() {
		
		JokalariaAldaketak jokalaria=null;
		
		lista.gehituGaztatxoa("gorria");
		lista.gehituGaztatxoa("laranja");
		lista.gehituGaztatxoa("urdina");
		lista.gehituGaztatxoa("horia");
		lista.gehituGaztatxoa("morea");
		lista.gehituGaztatxoa("berdea");
		//0. pasilloan eta 0. pasilloan jarraitu, lauki normalean
		jokalaria=tableroBat.fitxaMugitu(true, 4, 6, lista, 6);
		assertTrue(jokalaria.getHasierakoPasilloa());
		assertEquals(jokalaria.getPosizioaZutabea(),0);
		assertEquals(jokalaria.getPosizioaErrenkada(),4);
		assertTrue(jokalaria.getPartidaAmaituDa());
	}
	
	
	@Test
	public void testFitxaMugituBostgarrenAmaiera() {
		
		JokalariaAldaketak jokalaria=null;
		
		lista.gehituGaztatxoa("gorria");
		lista.gehituGaztatxoa("laranja");
		lista.gehituGaztatxoa("urdina");
		lista.gehituGaztatxoa("horia");
		lista.gehituGaztatxoa("morea");
		lista.gehituGaztatxoa("berdea");
		//0. pasilloan eta 0. pasilloan jarraitu, lauki normalean
		jokalaria=tableroBat.fitxaMugitu(true, 5, 6, lista, 1);
		assertTrue(jokalaria.getHasierakoPasilloa());
		assertEquals(jokalaria.getPosizioaZutabea(),5);
		assertEquals(jokalaria.getPosizioaErrenkada(),5);
	}
	
	@Test
	public void testFitxaMugituBostgarrenAmaieraKasilla() {
		
		JokalariaAldaketak jokalaria=null;
		
		lista.gehituGaztatxoa("gorria");
		lista.gehituGaztatxoa("laranja");
		lista.gehituGaztatxoa("urdina");
		lista.gehituGaztatxoa("horia");
		lista.gehituGaztatxoa("morea");
		lista.gehituGaztatxoa("berdea");
		//0. pasilloan eta 0. pasilloan jarraitu, lauki normalean
		jokalaria=tableroBat.fitxaMugitu(true, 5, 6, lista, 6);
		assertTrue(jokalaria.getHasierakoPasilloa());
		assertEquals(jokalaria.getPosizioaZutabea(),0);
		assertEquals(jokalaria.getPosizioaErrenkada(),5);
		assertTrue(jokalaria.getPartidaAmaituDa());
	}
	
	
	@Test
	public void testTableroaHasieratu() {
		assertNotNull(tableroBat);
	}

}
