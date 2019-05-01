package packtribial;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LaukiGaztadunaTest {
	
	LaukiGaztaduna laukiGorriaP, laukiBerdeaP, laukiMoreaP, laukiUrdinaP, laukiHoriaP, laukiLaranjaP;
	
	
	@Before
	public void setUp() throws Exception {
		// LaukiGaztaduna(String pKolorea, int pErrenkada, int pZutabeaZirkuluan){
		laukiGorriaP=new LaukiGaztaduna("gorria",4,27);
		laukiBerdeaP=new LaukiGaztaduna("berdea",1,6);
		laukiMoreaP=new LaukiGaztaduna("morea",2,13);
		laukiUrdinaP=new LaukiGaztaduna("urdina",3,20);
		laukiHoriaP=new LaukiGaztaduna("horia",5,34);
		laukiLaranjaP=new LaukiGaztaduna("laranja",0,41);
		
		ListaGalderak.getNireListaGalderak().galderakKonfiguratu();
	}

	@After
	public void tearDown() throws Exception {
		
		laukiGorriaP=null;
		laukiBerdeaP=null;
		laukiMoreaP=null;
		laukiUrdinaP=null;
		laukiHoriaP=null;
		laukiLaranjaP=null;
		
		
		ListaGalderak.getNireListaGalderak().erreseteatu();
	}


	@Test
	public void testLaukiGaztaduna() {
		
		assertNotNull(laukiGorriaP);
		assertNotNull(laukiBerdeaP);
		assertNotNull(laukiMoreaP);
		assertNotNull(laukiUrdinaP);
		assertNotNull(laukiHoriaP);
		assertNotNull(laukiLaranjaP);
		
	}

	@Test
	public void testGetErrenkada() {
		
		assertEquals(laukiGorriaP.getErrenkada(),4);
		assertEquals(laukiBerdeaP.getErrenkada(),1);
		assertEquals(laukiMoreaP.getErrenkada(),2);
		assertEquals(laukiUrdinaP.getErrenkada(),3);
		assertEquals(laukiHoriaP.getErrenkada(),5);
		assertEquals(laukiLaranjaP.getErrenkada(),0);
		
		
	}

	@Test
	public void testGetZutabeaPasilloan() {
		
		assertEquals(laukiGorriaP.getZutabeaPasilloan(),7);
		assertEquals(laukiBerdeaP.getZutabeaPasilloan(),7);
		assertEquals(laukiMoreaP.getZutabeaPasilloan(),7);
		assertEquals(laukiUrdinaP.getZutabeaPasilloan(),7);
		assertEquals(laukiHoriaP.getZutabeaPasilloan(),7);
		assertEquals(laukiLaranjaP.getZutabeaPasilloan(),7);
		
		
		
	}

	@Test
	public void testGetZutabeaZirkuluan() {
		
		assertEquals(laukiGorriaP.getZutabeaZirkuluan(),27);
		assertEquals(laukiBerdeaP.getZutabeaZirkuluan(),6);
		assertEquals(laukiMoreaP.getZutabeaZirkuluan(),13);
		assertEquals(laukiUrdinaP.getZutabeaZirkuluan(),20);
		assertEquals(laukiHoriaP.getZutabeaZirkuluan(),34);
		assertEquals(laukiLaranjaP.getZutabeaZirkuluan(),41);
		
		
		
	}

	@Test
	public void testGalderaFormulatu() {
		
		laukiGorriaP.galderaFormulatu();
		laukiBerdeaP.galderaFormulatu();
		laukiMoreaP.galderaFormulatu();
		laukiUrdinaP.galderaFormulatu();
		laukiHoriaP.galderaFormulatu();
		laukiLaranjaP.galderaFormulatu();
		
		
		
	}
	
	@Test
	public void testGetKolorea() {
		
		assertEquals(laukiGorriaP.getKolorea(),"gorria");
		assertEquals(laukiBerdeaP.getKolorea(),"berdea");
		assertEquals(laukiMoreaP.getKolorea(),"morea");
		assertEquals(laukiUrdinaP.getKolorea(),"urdina");
		assertEquals(laukiHoriaP.getKolorea(),"horia");
		assertEquals(laukiLaranjaP.getKolorea(),"laranja");
		
		
		
	}

}
