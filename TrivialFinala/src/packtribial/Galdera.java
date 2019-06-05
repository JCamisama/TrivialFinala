package packtribial;


public class Galdera {
	
	private String galdera;
	private String eranPosible1;
	private String eranPosible2;
	private String eranPosible3;
	private String eranPosible4;
	private int zuzena;
	
	
	public Galdera (String pGaldera, String pEranPosible1, String pEranPosible2, String pEranPosible3, String pEranPosible4, int pZuzena) {
	
		this.galdera = pGaldera;
		this.eranPosible1 = pEranPosible1;
		this.eranPosible2 = pEranPosible2;
		this.eranPosible3 = pEranPosible3;
		this.eranPosible4 = pEranPosible4;
		this.zuzena = pZuzena;	
	
	}
	
	private void imprimatuGaldera() {
	
		System.out.println(this.galdera);

		System.out.println(this.eranPosible1);
		System.out.println(this.eranPosible2);
		System.out.println(this.eranPosible3);
		System.out.println(this.eranPosible4);		
	
	}

	private boolean erantzunZuzenaSalbuespen() throws AukeraDesegokiaException {
	
		Galdera galdera1 = new Galdera(galdera, eranPosible1, eranPosible2, eranPosible3, eranPosible4, zuzena);
		
		System.out.println("15 segundu dituzu erantzuna emateko");
		System.out.println("");
		
		//Kronometroaren hasierakoeta.
		Kronometroa kron = Kronometroa.getNireKronometroa();
		
		//Kronometroa 0an jarri, 0 tik kontatzen hasteko.
		kron.zeroanJarri();
		
		int krono  = 0;
	
		galdera1.imprimatuGaldera();
		System.out.println("");
	
		boolean erantzunaOndo = false;			
	
		Teklatua teklatua;

		teklatua = Teklatua.getTeklatua();		
		
		int emandErantzuna;			
		
		emandErantzuna = teklatua.irakurriOsoa("Sartu zure erantzuna zenbaki moduan (1-4)");
		
		//krono aldagaian gordeko dugu kronometroa 0an jarri denetik galdera
		//erantzun denenerako pasatu diren segunduak
		
		krono = kron.pasaDirenSegunduakLortu();
	
		if(emandErantzuna<1 || emandErantzuna>4){//Erantzuna ez bada espero zena salbuespen bat
			throw (new AukeraDesegokiaException());
		}		
	
			if (krono<16 && this.zuzena == emandErantzuna) {//Erantzuna denboran eta ondo badago mezu bat.
		
				erantzunaOndo = true;			
				
			}
			else if (krono<16 && this.zuzena != emandErantzuna){//Erantzuna denboran baina txarto badago beste mezu bat.
				System.out.println("Txarto erantzun duzu galdera.");
			}
			else{//Erantzuna denboraz kanpo eman bada beste mezu bat.
				System.out.println("Denboraz kanpo erantzun duzu galdera ");
			}
	
		kron.zeroanJarri();
		
		return erantzunaOndo;
	}
	
	public boolean erantzunZuzena(){
		
		boolean kontrolpean=false;
		boolean erantzuna=false;
		do{
			try{
				erantzuna=this.erantzunZuzenaSalbuespen();
				kontrolpean=true;
		}
			catch (AukeraDesegokiaException e){
				e.inprimatu();
			}
	}while (!kontrolpean);
		
		return erantzuna;
		
	}

	

}
