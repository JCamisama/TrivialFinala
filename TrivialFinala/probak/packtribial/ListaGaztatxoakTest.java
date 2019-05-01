package packtribial;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaGaztatxoakTest {
	ListaGaztatxoak lista;
	@Before
	public void setUp() throws Exception {
		lista= new ListaGaztatxoak();
	}

	@After
	public void tearDown() throws Exception {
		lista=null;
	}

	@Test
	public void testListaGaztatxoak() {
		lista.gehituGaztatxoa("gorria");
		assertNotNull(lista);
	}

	@Test
	public void testGehituGaztatxoa() {
		//lista hutsan gaztatxo bat sartu
		lista.gehituGaztatxoa("gorria");
		assertEquals(lista.zenbatGaztatxo(),1); 
		//beste koloreko gaztatxo bat sartu
		lista.gehituGaztatxoa("berdea");
		assertEquals(lista.zenbatGaztatxo(),2); 
		//gaztatxo gorria berriro sartzen saiatu
		lista.gehituGaztatxoa("gorria");
		assertEquals(lista.zenbatGaztatxo(),2); 
		//zuzena sartu, galdera ondo erantzunda baina ez da gaztatxorik gehitzen
		lista.gehituGaztatxoa("zuzena");
		assertEquals(lista.zenbatGaztatxo(),2); 
		//okerra sartu, galdera txarto erantzun delako
		lista.gehituGaztatxoa("okerra");
		assertEquals(lista.zenbatGaztatxo(),2); 
	}

	@Test
	public void testBadago() {
		assertFalse(lista.badago("gorria"));
		lista.gehituGaztatxoa("gorria");
		assertTrue(lista.badago("gorria"));
	}

	@Test
	public void testZenbatGaztatxo() {
		
		lista.gehituGaztatxoa("gorria");
		assertEquals(lista.zenbatGaztatxo(),1);
		
		lista.gehituGaztatxoa("berdea");
		assertEquals(lista.zenbatGaztatxo(),2); 
		
		
	}

}
