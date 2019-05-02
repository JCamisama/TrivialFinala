package packtribial;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaJokalariakTest {
	ListaJokalariak lista;
	@Before
	public void setUp() throws Exception {
		lista=ListaJokalariak.getNireListaJokalariak();
		lista.hasieratuJokalariak();
		ListaGalderak.getNireListaGalderak().galderakKonfiguratu();
		Tableroa.getNireTableroa().tableroaHasieratu();
	}

	@After
	public void tearDown() throws Exception {
		ListaGalderak.getNireListaGalderak().erreseteatu();
		ListaJokalariak.getNireListaJokalariak().erreseteatu();
		Tableroa.getNireTableroa().erreseteatu();
	}

	@Test
	public void testGetNireListaJokalariak() {
		assertNotNull(lista);
	}

	@Test
	public void testJokalarienTxandaKudeatu() {
		lista.jokalarienTxandaKudeatu();
	}
	
	@Test
	public void testJokalarienTxandaKudeatuAmaitu() {
		ListaJokalariak.getNireListaJokalariak().erreseteatu();
		lista=ListaJokalariak.getNireListaJokalariak();
		Jokalaria jokalari1= new Jokalaria ("berdea",4,1,true);
		jokalari1.gehituGaztatxoa("gorria");
		jokalari1.gehituGaztatxoa("berdea");
		jokalari1.gehituGaztatxoa("laranja");
		jokalari1.gehituGaztatxoa("horia");
		jokalari1.gehituGaztatxoa("morea");
		jokalari1.gehituGaztatxoa("urdina");
		lista.gehituJokalaria(jokalari1);
		lista.jokalarienTxandaKudeatu();
	}

	@Test
	public void testPartidaBukatu() {
		lista.partidaBukatu("gorria");
		lista.partidaBukatu("horia");
	}
	@Test
	public void testHasieratuJokalariak(){
		ListaJokalariak.getNireListaJokalariak().hasieratuJokalariak();
	}
}
