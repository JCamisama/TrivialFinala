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
		//Hasierako pasilloan eta hasierako pasilloan jarraitu, lauki gaztadunean
		tableroBat.fitxaMugitu(true, 0, 4, lista, 5);
	}
	
	

	@Test
	public void testTableroaHasieratu() {
		assertNotNull(tableroBat);
	}

	@Test
	public void testErreseteatu() {
		//ni idea
	}

}
