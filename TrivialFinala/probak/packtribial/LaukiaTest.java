package packtribial;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

 
public class LaukiaTest {
	
	 Laukia laukiGorria, laukiBerdea, laukiMorea, laukiUrdina, laukiHoria, laukiLaranja;
	 
	@Before
	public void setUp() throws Exception {
		laukiGorria=new Laukia("gorria");
		laukiBerdea=new Laukia("berdea");
		laukiMorea=new Laukia("morea");
		laukiUrdina=new Laukia("urdina");
		laukiHoria=new Laukia("horia");
		laukiLaranja=new Laukia("laranja");
	}

	@After
	public void tearDown() throws Exception {
		laukiGorria=null;
		laukiBerdea=null;
		laukiMorea=null;
		laukiUrdina=null;
		laukiHoria=null;
		laukiLaranja=null;
		ListaGalderak.getNireListaGalderak().erreseteatu();
	}

	@Test
	public void testLaukia() {
		assertNotNull(laukiGorria);
		assertNotNull(laukiBerdea);
		assertNotNull(laukiMorea);
		assertNotNull(laukiUrdina);
		assertNotNull(laukiHoria);
		assertNotNull(laukiLaranja);
	}

	@Test
	public void testGalderaFormulatu() {
		ListaGalderak.getNireListaGalderak().galderakKonfiguratu();
		laukiGorria.galderaFormulatu();
		laukiBerdea.galderaFormulatu();
		laukiMorea.galderaFormulatu();
		laukiUrdina.galderaFormulatu();
		laukiHoria.galderaFormulatu();
		laukiLaranja.galderaFormulatu();
	}
}
