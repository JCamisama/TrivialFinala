package packtribial;

import java.io.InputStreamReader;
import java.util.Scanner;

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
	
	private void ImprimatuGaldera() {
	
		System.out.println(this.galdera);

		System.out.println(this.eranPosible1);
		System.out.println(this.eranPosible2);
		System.out.println(this.eranPosible3);
		System.out.println(this.eranPosible4);		
	
	}

	private boolean erantzunZuzenaSalbuespen() throws AukeraDesegokiaException {
	
		Galdera galdera1 = new Galdera(galdera, eranPosible1, eranPosible2, eranPosible3, eranPosible4, zuzena);
	
		galdera1.ImprimatuGaldera();
	
		boolean erantzunaOndo = false;
	
		System.out.println("Sartu zure erantzuna zenbaki moduan");	
	
		Scanner sc; 

		sc = new Scanner(System.in);
	
		int emandErantzuna;
	
		emandErantzuna = sc.nextInt();
	
		if(emandErantzuna<1 || emandErantzuna>4){
		throw (new AukeraDesegokiaException());
		}
	
		if (this.zuzena == emandErantzuna) {
		
			erantzunaOndo = true;
			System.out.println("Zure erantzuna ondo dago");
			System.out.println("Oso ondo, segi horrela");
			System.out.println("\n");
		
		}
		
		else {
			
			System.out.println("Zure erantzuna gaizki dago");
			System.out.println("Ooooo, pena bat da, baina hurrengoan ondo egingo duzu. Animo!");
			System.out.println("\n");
		
			}
	
	
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
