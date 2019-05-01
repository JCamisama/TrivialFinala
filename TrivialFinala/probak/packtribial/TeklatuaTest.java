package packtribial;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TeklatuaTest {
	Teklatua teklatuBat;
	@Before
	public void setUp() throws Exception {
		teklatuBat=Teklatua.getTeklatua();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetTeklatua() {
		assertNotNull(teklatuBat);
	}

	@Test
	public void testSkipLine() {
		teklatuBat.skipLine("Sakatu ENTER jarraitzeko: ");
	}

	@Test
	public void testIrakurriOsoa() {
		assertEquals(teklatuBat.irakurriOsoa("Sartu zenbaki oso bat: "),5);
	}

	@Test
	public void testIrakurriString() {
		//no creo que se utilice
	}

	@Test
	public void testNoraMugitu() {
		assertEquals(teklatuBat.noraMugitu("Nora mugitu?"),"eskuinera");
	}

}
