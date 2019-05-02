package packtribial;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JokalariaTest {
	Jokalaria jokalari1,jokalari2;
	@Before
	public void setUp() throws Exception {
		//public Jokalaria(String pKolorea, int pPosizioaErrenkada, int pPosizioaZutabea, boolean pHasierakoPasilloa){
		jokalari1=new Jokalaria("gorria",3,0,true);
		jokalari2=new Jokalaria("berdea",0,0,true);
		Tableroa.getNireTableroa().tableroaHasieratu();
		ListaGalderak.getNireListaGalderak().galderakKonfiguratu();
	}

	@After
	public void tearDown() throws Exception {
		jokalari1=null;
		jokalari2=null;
		Tableroa.getNireTableroa().erreseteatu();
		ListaGalderak.getNireListaGalderak().erreseteatu();
	}

	@Test
	public void testJokalaria() {
		assertNotNull(jokalari1);
		assertNotNull(jokalari2);
	}

	@Test
	public void testTxandaBurutu() {
		jokalari1.txandaBurutu();
	}

	@Test
	public void testGetFitxarenKolorea() {
		assertEquals(jokalari1.getFitxarenKolorea(),"gorria");
		assertEquals(jokalari2.getFitxarenKolorea(),"berdea");
	}

	@Test
	public void testGehituGaztatxoa() {
		jokalari1.gehituGaztatxoa("gorria");
	}


}
