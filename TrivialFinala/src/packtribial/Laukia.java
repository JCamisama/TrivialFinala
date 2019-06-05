package packtribial;

public class Laukia {
	//atributuak
	
	private String	kolorea;
	

	//eraikitzailea-constructora
	
	public Laukia(String pKolorea){
		
		this.kolorea = pKolorea;
		
	}

	//gainontzeko metodoak-metodos adicionales
	
	
	public String galderaFormulatu(){ //Metodo honek galderaren erantzuna zuzena ala okerra den bueltatzen du
		
		String erantzuna = "okerra";
		boolean erantzunaBoolear = false;
	
		ListaGalderak galderaHauek = ListaGalderak.getNireListaGalderak();
		
		erantzunaBoolear	= galderaHauek.galderakFormulatu(this.kolorea);
		
		if (erantzunaBoolear){
			
			erantzuna = "zuzena";
		}
	
		return erantzuna;
		
	}
	
	protected String getKolorea(){
		
		return this.kolorea;
	}
}