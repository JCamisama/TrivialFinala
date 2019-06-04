package packtribial;


import java.io.InputStreamReader;
import java.io.File;
import java.io.InputStream;
import java.util.Scanner;


public class Tableroa {
	//atributuak
	private Laukia[][]	lehenengoBidea;			// Barneko 6 bideetan
	private int			errenkadaKop=0;			// Sei bideetako zein
	private int			zutabeKop=0;			// Bidearen zein laukian
	private Laukia[]	bigarrenBidea;			// Kanpoko bidea, zirkulu bat
	private	int			posizioZirkuluan=0;	 	// Bidearen zein laukian		
	private static Tableroa nireTableroa=null;	

	//eraikitazilea
	private Tableroa() {
		this.lehenengoBidea= new Laukia[6][7];
		this.bigarrenBidea= new Laukia[42];
	}

	//gainotzeko metodoak
	public static synchronized Tableroa getNireTableroa() {
		if(Tableroa.nireTableroa == null) {
			Tableroa.nireTableroa = new Tableroa();
		}
		return Tableroa.nireTableroa;
	}


	
	public JokalariaAldaketak fitxaMugitu(boolean pHasierakoPasilloan, int pPosizioaErrenkada, int pPosizioaZutabea,
			ListaGaztatxoak pPuntuak, int pAteratakoa) {
		

		//Jokalariaren informazioa eguneratzeko aldagai lokalak
		
		boolean garaileaDa				= false;
		boolean hasierakoPasilloan		= pHasierakoPasilloan;
		int		egungoZutabea			= pPosizioaZutabea;
		int		egungoErrenkada			= pPosizioaErrenkada;
		String  erantzuna				= "okerra";					//ListaGaztatxoak honen balioa kudeatuko du
		int		kont					= 0;
		
		
		if(!hasierakoPasilloan){ // Zirkuluan dagoela jokalaria
			
			egungoZutabea	= this.mugituZirkuluan(egungoZutabea, pAteratakoa);
			erantzuna		= this.bigarrenBidea[egungoZutabea].galderaFormulatu();
				 
			//jokalariaren puntuak eguneratzen
			pPuntuak.gehituGaztatxoa(erantzuna);
				 
			if (pPuntuak.zenbatGaztatxo() == 6){ //6. puntua lortzerakoan pasilloaren sarreran bertan egongo da
					 
				hasierakoPasilloan	= true; // Pasilloan mugitu ahal izateko behar duen salataria
				
				//downcasting-a erabiliz, pasilloan mugitzeko behar dituen koordenatuak jasotzeko
				egungoErrenkada		= ((LaukiGaztaduna)this.bigarrenBidea[egungoZutabea]).getErrenkada();
				egungoZutabea		= ((LaukiGaztaduna)this.bigarrenBidea[egungoZutabea]).getZutabeaPasilloan();
			}
			
		}
		
		else{// Pasillo baten barruan dagoela jokalaria
			
			if (pPuntuak.zenbatGaztatxo() == 6){
				//pasilloaren barnean dago, sei puntu dituela erdialdeko laukira mugitzeko asmoarekin
				
				
				egungoZutabea	= egungoZutabea - pAteratakoa;
				
				if (egungoZutabea < 0){ //Erdialdera behar duen baino emaitza handiagoa ateratzen badu, onartuko da
					
					egungoZutabea = 0; 
				}
				erantzuna		= this.lehenengoBidea[egungoErrenkada][egungoZutabea].galderaFormulatu();
				
				//Zerogarren laukian ondo erantzuten badu, jokoa irabaziko du txanda daukan jokalariak
				if(egungoZutabea == 0 && erantzuna == "zuzena"){
					
					garaileaDa	= true;
				}
				
				else{
					
					pPuntuak.gehituGaztatxoa(erantzuna);//galdera erantzun ostean zer gertatu den esaten du
					
				}
					
			}
			
			
			else{// Pasilloaren barnean dago, zero punturekin eta zirkulura mugitzeko asmoarekin
				
				int mugitzekoFalta	=  egungoZutabea + pAteratakoa - 6;
				
				// Positiboa edo zero bada, zirkulura ailegatu dela esan nahi du
				if(mugitzekoFalta >= 0){
					egungoZutabea		=	6; // Pasilloaren azkenengo laukitxora mugitzen, bertan zirkuluaren lotura baitago
					hasierakoPasilloan	=	false;	// Zirkuluan dagoela adierazten du
					egungoZutabea		=
							((LaukiGaztaduna)this.lehenengoBidea[egungoErrenkada][egungoZutabea]).getZutabeaZirkuluan();
				
					if(mugitzekoFalta > 0){/*Zirkulura mugitzeko beharrezkoa den zenbaki handiagoa ateratzen badu
												falta zaiona zirkuluan mugitzeko balioko du */
						
						egungoZutabea		= this.mugituZirkuluan(egungoZutabea, mugitzekoFalta);
						
					}
					
				}
				
				else{ //Negatiboa da, beraz, "hasiera" eta "gaztatxo" laukien artean (0 < egungoZutabea < 6)
					
					egungoZutabea =	egungoZutabea + pAteratakoa;
				}

				
				//Mugimengua guztiz burutu dela, galdera eskatzeko momentua da
				
				if(!hasierakoPasilloan){ // Tableroaren atalaren arabera, koordenatu desberdinak behar dira galdera eskatzeko
					
					erantzuna		= this.bigarrenBidea[egungoZutabea].galderaFormulatu();
	
				}
				
				else{
					
					erantzuna		= this.lehenengoBidea[egungoErrenkada][egungoZutabea].galderaFormulatu();
				}
				
				
				//jokalariaren puntuak eguneratzen
				pPuntuak.gehituGaztatxoa(erantzuna);
				
			}
			
		}
				 
		// Txandaren emaitzak aldaketak "kutxa" batean sartuko dira		
		JokalariaAldaketak aldaketak = null;
		boolean	txandarenEmaitza = (erantzuna != "okerra");
		aldaketak	= new JokalariaAldaketak(hasierakoPasilloan, egungoErrenkada, egungoZutabea, txandarenEmaitza, garaileaDa);
																							//erantzuna ez da beharrezkoa itzuleran
		return aldaketak;
	}
		
	
	private int mugituZirkuluanSalbuespen(int pEgungoPosizioa, int pZenbatMugitu) throws MugimenduDesegokiaException{
		
		//*****************************************************************************************
		Teklatua	teklatuHau	= Teklatua.getTeklatua();
		String noraMugitu 		= teklatuHau.noraMugitu("Nora mugitu nahi duzu fitxa? (aurrera/atzera)");
		//Salbuespena gertatuko da kasu honetan****************************************************
		if (!noraMugitu.equals("aurrera") && !noraMugitu.equals("atzera")){
			throw (new MugimenduDesegokiaException());
		}
		int	posizioBerria	= pEgungoPosizioa;
		if (noraMugitu.equals("aurrera")){
			
			posizioBerria	= posizioBerria + pZenbatMugitu;
			if (posizioBerria > 41){
				
				posizioBerria	= posizioBerria - 42; //Zerotik hasi behar delako zenbaketa "ken 42 egiten da"
			}
		}
		
		
		else if  (noraMugitu.equals("atzera")){
			
			posizioBerria	= posizioBerria - pZenbatMugitu;
			if(posizioBerria < 0){
					
				posizioBerria	= posizioBerria	+ 42; //Zeroa kontuan hartzeko "gehi 42 egiten da"
			}
			
		}
			
			
		return posizioBerria;
	}
	
	private int mugituZirkuluan(int pEgungoPosizioa, int pZenbatMugitu){
		boolean kontrolpean=false;
		int erantzuna=0;
		do{
			try{
				erantzuna=this.mugituZirkuluanSalbuespen(pEgungoPosizioa, pZenbatMugitu);
				kontrolpean=true;
		}
			catch (MugimenduDesegokiaException e){
				e.inprimatu();
			}
		}while (!kontrolpean);
		
		return erantzuna;
	}
	
	
	private void gehituHasieranLaukia(Laukia pLaukia) {
	 //Salbuespen if jokalari kop 6 edo 2
	    this.lehenengoBidea[this.errenkadaKop][this.zutabeKop]=pLaukia;
	    if(this.zutabeKop==6){
	       this.errenkadaKop++;
	       this.zutabeKop=0;
	    }
	    else{
	    	
	    	this.zutabeKop++;}//TODO
	    }
	private void gehituZirkuluanLaukia(Laukia pLaukia) {
		//Salbuespen if jokalari kop 6 edo 2
		this.bigarrenBidea[this.posizioZirkuluan]=pLaukia;
		this.posizioZirkuluan++;
		
	}
	
    public void tableroaHasieratu(){
    
    	int kont = 0;
    	String[] zatiak=new String[3];
    	String koloreaGaztatxo=null;
    	String errenkada=null;
    	String zutabeaZirkulua=null;
    	int errenkadaInt=0;
    	int zutabeaZirkuluanInt=0;
		Laukia laukiBat=null;
		InputStream fitx=null;
		InputStreamReader in=null;
		Scanner sc = null;
		String kolorea=null;
		
		String fitxategia="Fitxategiak"+File.separator+"BarrukoTablero.txt";
				
		fitx = this.getClass().getClassLoader().getResourceAsStream(fitxategia);
		in = new InputStreamReader(fitx);			
		sc = new Scanner(in);
		// Pasilloak/Matrizea hasieratzen
		while (sc.hasNextLine()){
			
			kolorea = sc.nextLine();
			// LaukiGaztadunak badira
			if (kont==6 || kont==13 || kont==20 || kont==27 || kont==34 || kont==41){
				zatiak=kolorea.split("#");
				koloreaGaztatxo = zatiak[0];
				errenkada = zatiak[1];
				zutabeaZirkulua=zatiak[2];
				errenkadaInt = Integer.parseInt(errenkada);
				zutabeaZirkuluanInt = Integer.parseInt(zutabeaZirkulua);
				laukiBat= new LaukiGaztaduna(koloreaGaztatxo,errenkadaInt,zutabeaZirkuluanInt);
			}
			// Lauki normalak badira
			else{
			
			laukiBat=new Laukia(kolorea);
			
			}

			this.gehituHasieranLaukia(laukiBat);
			
			kont++;
		}
		sc.close();
		kont=0;
		fitxategia="Fitxategiak"+File.separator+"KanpokoTablero.txt";
		
		fitx = this.getClass().getClassLoader().getResourceAsStream(fitxategia);
		in = new InputStreamReader(fitx);			
		sc = new Scanner(in);
		
		// Zirkulua/Arraya hasieratzen
		while (sc.hasNextLine()){
			
			kolorea = sc.nextLine();
			
			if (kont==6 || kont==13 || kont==20 || kont==27 || kont==34 || kont==41){
				
				zatiak=kolorea.split("#");
				koloreaGaztatxo = zatiak[0];
				errenkada = zatiak[1];
				zutabeaZirkulua=zatiak[2];
				errenkadaInt = Integer.parseInt(errenkada);
				zutabeaZirkuluanInt = Integer.parseInt(zutabeaZirkulua);
				laukiBat= new LaukiGaztaduna(koloreaGaztatxo,errenkadaInt,zutabeaZirkuluanInt);
				
			}
			else{
			
			laukiBat=new Laukia(kolorea);
			
			
			}
			
			this.gehituZirkuluanLaukia(laukiBat);
			
			kont++;
		}
		sc.close();
    }
    public void erreseteatu(){
    	Tableroa.nireTableroa=null;
    }

}
	

