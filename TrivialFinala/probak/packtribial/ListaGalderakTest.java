package packtribial;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaGalderakTest {
	
	ListaGalderak pListaGaldera;
	
	

	@Before
	public void setUp() throws Exception {
		
		pListaGaldera = ListaGalderak.getNireListaGalderak();
		
	}

	@After
	public void tearDown() throws Exception {
		
		pListaGaldera.erreseteatu();
		
	}

	@Test
	public void testGetNireListaGalderak() {
		assertNotNull(pListaGaldera);
	}

	@Test
	public void testGalderakKonfiguratu() {
		
		assertNotNull(pListaGaldera);
		
	}

	@Test
	public void testGalderakFormulatu() {
		
		pListaGaldera.galderakKonfiguratu();		
		pListaGaldera.galderakFormulatu("gorria");
		pListaGaldera.galderakFormulatu("berdea");
		pListaGaldera.galderakFormulatu("horia");
		pListaGaldera.galderakFormulatu("laranja");
		pListaGaldera.galderakFormulatu("morea");
		pListaGaldera.galderakFormulatu("urdina");
	}

}
