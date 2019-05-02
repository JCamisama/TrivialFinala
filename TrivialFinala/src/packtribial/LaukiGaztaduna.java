package packtribial;

public class LaukiGaztaduna extends Laukia{

	private int 		errenkada;
	//private static int 	zutabeaPasilloan = 6;
	private int			zutabeaPasilloan = 6;
	private int			zutabeaZirkuluan;
	
	LaukiGaztaduna(String pKolorea, int pErrenkada, int pZutabeaZirkuluan){
		
		super(pKolorea);
		
		this.errenkada			= pErrenkada;
		this.zutabeaZirkuluan	= pZutabeaZirkuluan;
	}
	
	public int getErrenkada(){
		
		return this.errenkada;
	}
	
	public int getZutabeaPasilloan(){
		
		return this.zutabeaPasilloan;
	}
	
	public int getZutabeaZirkuluan(){
		
		return this.zutabeaZirkuluan;
	}
	
	public String galderaFormulatu(){
			
			String erantzuna = super.galderaFormulatu();
		
			if (erantzuna == "zuzena"){
				
				erantzuna = super.getKolorea();
			}
			
			return erantzuna;
			
		}
}
