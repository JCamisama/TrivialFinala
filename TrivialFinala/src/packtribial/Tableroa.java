package packtribial;

import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Random;
import java.util.Scanner;

public class Tableroa {
	//atributuak
	private Laukia[][]	lehenengoBidea;// Barneko 6 bideetan
	private int			errenkadaKop=0;
	private int			zutabeKop=0;
	private Laukia[]	bigarrenBidea;// Kanpoko bidea, zirkulu bat
	private	int			posizioZirkuluan=0; 		
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
		
		//Kontuz posizioaErrenkadarekin
		
		//Jokalariaren informazioa eguneratzeko aldagai lokalak
		
		boolean garaileaDa				= false;
		boolean hasierakoPasilloan		= pHasierakoPasilloan;
		int		egungoZutabea			= pPosizioaZutabea;
		int		egungoErrenkada			= pPosizioaErrenkada;
		String  erantzuna				= "okerra";					//jokalariaren puntuak kontrolatzeko
		int		kont					= 0;
		
		
		if(!hasierakoPasilloan){
			
			egungoZutabea	= this.mugituZirkuluan(egungoZutabea, pAteratakoa);
			erantzuna		= this.bigarrenBidea[egungoZutabea].galderaFormulatu();
				 
			//jokalariaren puntuak eguneratzen
			pPuntuak.gehituGaztatxoa(erantzuna);
				 
			if (pPuntuak.zenbatGaztatxo() == 6){
					 
				hasierakoPasilloan	= true;
				
				//downcasting-a erabiliz
				egungoErrenkada		= ((LaukiGaztaduna)this.bigarrenBidea[egungoZutabea]).getErrenkada();
				egungoZutabea		= ((LaukiGaztaduna)this.bigarrenBidea[egungoZutabea]).getZutabeaPasilloan();
			}
			
		}
		
		else{
			
			if (pPuntuak.zenbatGaztatxo() == 6){
				//pasilloaren barnean dago eta jadanik sartu da
				
				
				egungoZutabea	= egungoZutabea - pAteratakoa;
				
				if (egungoZutabea < 0){
					
					egungoZutabea = 0;
				}
				erantzuna		= this.bigarrenBidea[egungoZutabea].galderaFormulatu();
				
				//Zerogarren laukira heltzeko behar baino gehiago ateratzen bada dadoan, onartuko dugu
				if(egungoZutabea == 0 && erantzuna == "zuzena"){
					
					garaileaDa	= true;
				}
				
				else{
					
					pPuntuak.gehituGaztatxoa(erantzuna);//galdera erantzun ostean zer gertatu den esaten du
					
				}
					
			}
			
			
			else{
				
				while (kont < pAteratakoa && hasierakoPasilloan){
				
					kont++;
					egungoZutabea++;
					if( this.lehenengoBidea[egungoErrenkada][egungoZutabea] instanceof LaukiGaztaduna){
						
						hasierakoPasilloan	= false;
						//downcasting-a erabiliz
						egungoZutabea		= 
								((LaukiGaztaduna)this.lehenengoBidea[egungoErrenkada][egungoZutabea]).getZutabeaZirkuluan();
					}
				}
				
				if (kont < pAteratakoa){ //zirkulura pasatu da eta oraindik mugitu behar da
					int zenbatMugitu	= pAteratakoa - kont;
					egungoZutabea		= this.mugituZirkuluan(egungoZutabea,zenbatMugitu);
					
				}
				
				//Mugimengua guztiz burutu dela, galdera eskatzeko momentua da
				
				if(!hasierakoPasilloan){
					
					erantzuna		= this.bigarrenBidea[egungoZutabea].galderaFormulatu();
	
				}
				
				else{
					
					erantzuna		= this.lehenengoBidea[egungoErrenkada][egungoZutabea].galderaFormulatu();
				}
				
				
				//jokalariaren puntuak eguneratzen
				pPuntuak.gehituGaztatxoa(erantzuna);
				
			}
			
		}
				 
				
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
		if (noraMugitu!="aurrera" || noraMugitu!="atzera"){
			throw (new MugimenduDesegokiaException());
		}
		int	posizioBerria	= pEgungoPosizioa;
		switch (noraMugitu){
		case "aurrera":
			// ponerlo en el powerpoint el fallo del if y no en case
			posizioBerria	= posizioBerria + pZenbatMugitu;
			if (posizioBerria > 41){
				
				posizioBerria	= posizioBerria - 42; //Zerotik hasi behar delako zenbaketa "ken 42 egiten da"
			}
			break;
		
		
		case "atzera":
			
			posizioBerria	= posizioBerria - pZenbatMugitu;
			if(posizioBerria < 0){
					
				posizioBerria	= posizioBerria	+ 42; //Zeroa kontuan hartzeko "gehi 42 egiten da"
			}
			break;
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
	
	
		/*public void setErrenkadaKop(int pErrenkadaKop){
	        this.errenkadaKop=pErrenkadaKop;
	    }
	    public void setZutabeKop(int pZutabeKop){
	        this.zutabeKop=pZutabeKop;
	    }
	    public void setPosizioZirkuluan(int pPosizioZirkuluan){
	        this.posizioZirkuluan=pPosizioZirkuluan;
	    }*/
	
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
	        this.posizioZirkuluan++;//TODO
	    }
	    public void tableroaHasieratu(){
	    	//LaukiGaztaduna(String pKolorea, int pErrenkada, int pZutabeaZirkuluan){
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
			
			fitx = this.getClass().getClassLoader().getResourceAsStream("Fitxategiak/BarrukoTablero.txt");
			in = new InputStreamReader(fitx);			
			sc = new Scanner(in);
			
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

				this.gehituHasieranLaukia(laukiBat);
				
				kont++;
			}
			
			kont=0;
			fitx = this.getClass().getClassLoader().getResourceAsStream("Fitxategiak/KanpokoTablero.txt");
			in = new InputStreamReader(fitx);			
			sc = new Scanner(in);
			
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
	    }
	    public void erreseteatu(){
	    	Tableroa.nireTableroa=null;
	    }

}
	

