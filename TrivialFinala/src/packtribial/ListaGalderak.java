package packtribial;


import java.io.InputStreamReader;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


public class ListaGalderak {	
		
		//atributuak
		private ArrayList<Galdera> listaBerde;
		private static ListaGalderak nireListaGalderak = null;
		private ArrayList<Galdera> listaGorri;
		private ArrayList<Galdera> listaLaranja;
		private ArrayList<Galdera> listaHori;
		private ArrayList<Galdera> listaMore;
		private ArrayList<Galdera> listaUrdi;
		private ArrayList<Galdera> listaBerezi;
		
		
		//eraikitzailea
		private ListaGalderak(){
			this.listaBerde = new ArrayList<Galdera>();
			this.listaGorri = new ArrayList<Galdera>();
			this.listaLaranja = new ArrayList<Galdera>();
			this.listaHori = new ArrayList<Galdera>();
			this.listaMore = new ArrayList<Galdera>();
			this.listaUrdi = new ArrayList<Galdera>();
			this.listaBerezi= new ArrayList<Galdera>();
		}
		
		
		
		
		//gainontzeko metodoak
		public static synchronized ListaGalderak getNireListaGalderak(){
			if(ListaGalderak.nireListaGalderak == null){
				ListaGalderak.nireListaGalderak = new ListaGalderak();
			}
			return ListaGalderak.nireListaGalderak;
		}

public void galderakKonfiguratu(){
	
	hasieratuGalderenZerrenda("berdea");
	hasieratuGalderenZerrenda("gorria");
	hasieratuGalderenZerrenda("horia");
	hasieratuGalderenZerrenda("laranja");
	hasieratuGalderenZerrenda("morea");
	hasieratuGalderenZerrenda("urdina");
	hasieratuGalderenZerrenda("zuria");
	
}
		

	public boolean galderakFormulatu(String pKolorea){
			
		//Galdera ateratzeko aldagai lokalak
			Random zenbakiRandomak=null;
			int egungoBalioa = 0;
			Galdera galderaBat = null;
			boolean erantzuna= false;
			int galderaKop;
			
					
			switch (pKolorea) {
			
			case "berdea":		
				
				//Listak duen galdera kopuruen arteko balio bat aterako dugu(gure kasuan 0-19 artekoa).
				//Listaren tamaina 0 bada fitxategia berriz hasieratuko dugu.
				
				zenbakiRandomak=new Random();
				galderaKop = this.listaBerde.size(); 
			    egungoBalioa=zenbakiRandomak.nextInt(galderaKop - 1);			    
			    galderaBat = this.listaBerde.get(egungoBalioa);
			    erantzuna =  galderaBat.erantzunZuzena();
			    this.listaBerde.remove(egungoBalioa);
			    if (this.listaBerde.size()==0) {
			    	
			    	this.hasieratuGalderenZerrenda(pKolorea);
			    	
			    }
				
				break;
				
			case "gorria":
				
				zenbakiRandomak=new Random();
				galderaKop = this.listaGorri.size(); 
			    egungoBalioa=zenbakiRandomak.nextInt(galderaKop - 1);
			    galderaBat = this.listaGorri.get(egungoBalioa);
			    erantzuna =  galderaBat.erantzunZuzena();
			    this.listaGorri.remove(egungoBalioa);
			    if (this.listaGorri.size()==0) {
			    	
			    	this.hasieratuGalderenZerrenda(pKolorea);
			    	
			    }
				
				break;
				
			case "horia":
				
				zenbakiRandomak=new Random();
				galderaKop = this.listaHori.size(); 
			    egungoBalioa=zenbakiRandomak.nextInt(galderaKop - 1);
			    galderaBat = this.listaHori.get(egungoBalioa);
			    erantzuna =  galderaBat.erantzunZuzena();
			    this.listaHori.remove(egungoBalioa);
			    if (this.listaHori.size()==0) {
			    	
			    	this.hasieratuGalderenZerrenda(pKolorea);
			    	
			    }
			    
				break;
				
			case "laranja":
				
				zenbakiRandomak=new Random();
				galderaKop = this.listaLaranja.size(); 
			    egungoBalioa=zenbakiRandomak.nextInt(galderaKop - 1);
			    galderaBat = this.listaLaranja.get(egungoBalioa);
			    erantzuna =  galderaBat.erantzunZuzena();
			    this.listaLaranja.remove(egungoBalioa);
			    if (this.listaLaranja.size()==0) {
			    	
			    	this.hasieratuGalderenZerrenda(pKolorea);
			    	
			    }
				
				break;
			
			case "morea":
				
				zenbakiRandomak=new Random();
				galderaKop = this.listaMore.size();
			    egungoBalioa=zenbakiRandomak.nextInt(galderaKop - 1);
			    galderaBat = this.listaMore.get(egungoBalioa);
			    erantzuna =  galderaBat.erantzunZuzena();
			    this.listaMore.remove(egungoBalioa);
			    if (this.listaMore.size()==0) {
			    	
			    	this.hasieratuGalderenZerrenda(pKolorea);
			    	
			    }
				
				break;
				
			case "urdina":
				
				zenbakiRandomak=new Random();
				galderaKop = this.listaUrdi.size(); 
			    egungoBalioa=zenbakiRandomak.nextInt(galderaKop - 1);
			    galderaBat = this.listaUrdi.get(egungoBalioa);
			    erantzuna =  galderaBat.erantzunZuzena();
			    this.listaUrdi.remove(egungoBalioa);
			    if (this.listaUrdi.size()==0) {
			    	
			    	this.hasieratuGalderenZerrenda(pKolorea);
			    	
			    }
				
				break;
				
			case "zuria":
				
				zenbakiRandomak=new Random();
				galderaKop = this.listaBerezi.size(); 
			    egungoBalioa=zenbakiRandomak.nextInt(galderaKop - 1);
			    galderaBat = this.listaBerezi.get(egungoBalioa);
			    erantzuna =  galderaBat.erantzunZuzena();
			    this.listaBerezi.remove(egungoBalioa);
			    if (this.listaBerezi.size()==0) {
			    	
			    	this.hasieratuGalderenZerrenda(pKolorea);
			    	
			    }
			    
				break;
				
				
			}				
			
			
			return erantzuna;
			
		}
	
	public void erreseteatu(){
		ListaGalderak.nireListaGalderak=null;
	}
	
	private void hasieratuGalderenZerrenda(String pKolorea) {
		
		ArrayList<Galdera> zerrenda = null;
		InputStream fitx = null;
		
		String fitxategia=null;
		
		switch (pKolorea) {
		
			case "berdea":
				fitxategia="Fitxategiak"+File.separator+"Galdera_berdeaBiologia.txt";
				fitx = this.getClass().getClassLoader().getResourceAsStream(fitxategia);
				zerrenda= this.listaBerde;
				break;
				
			case "gorria":
				
				fitxategia="Fitxategiak"+File.separator+"GalderaGorriaBideo-jokoak.txt";
				fitx = this.getClass().getClassLoader().getResourceAsStream(fitxategia);
				zerrenda= this.listaGorri;
				break;
				
			case "laranja":
				
				fitxategia="Fitxategiak"+File.separator+"GalderaLaranjaentretenimendua.txt";
				fitx = this.getClass().getClassLoader().getResourceAsStream(fitxategia);
				zerrenda= this.listaLaranja;
				break;
				
			case "horia":
				
				fitxategia="Fitxategiak"+File.separator+"GalderaHoriaKirolak.txt";
				fitx = this.getClass().getClassLoader().getResourceAsStream(fitxategia);
				zerrenda= this.listaHori;
				break;
				
			case "morea":
				
				fitxategia="Fitxategiak"+File.separator+"Galdera_moreaOtaku.txt";
				fitx = this.getClass().getClassLoader().getResourceAsStream(fitxategia);
				zerrenda= this.listaMore;
				break;
				
			case "urdina":
				
				fitxategia="Fitxategiak"+File.separator+"Galdera_UrdinaGeografia.txt";
				fitx = this.getClass().getClassLoader().getResourceAsStream(fitxategia);
				zerrenda= this.listaUrdi;
				break;		
				
			case "zuria":
				fitxategia="Fitxategiak"+File.separator+"GalderaFinalak.txt";
				fitx = this.getClass().getClassLoader().getResourceAsStream(fitxategia);
				zerrenda= this.listaBerezi;
				break;
		}		
		
		this.hasieratuLista(zerrenda, fitx);
	}
	
	
	private void hasieratuLista(ArrayList<Galdera> pZerrenda, InputStream pFitx) {
		
		//Galderak hasieratzeko aldagai lokalak
		
		Galdera galderaBat=null;
		String[] zatiak=null;		
		InputStreamReader in=null;
		Scanner sc = null;
		String galderaErantzuna=null;
		String galdera=null;
		String eranPosible1=null;
		String eranPosible2=null;
		String eranPosible3=null;
		String eranPosible4=null;
		String zuzena=null;
		int eranEgokia=0;	

		zatiak= new String[6];		
		in= new InputStreamReader(pFitx);
		sc = new Scanner(in);
		
		
		//Galderen lista joango gara errekorritzen eta fitxategiko datuak lehen definitutako
		//aldagaietan gordetzen, gero galdera klasearen eraikitzaileari deia egiteko.
		
		
		while(sc.hasNextLine()) {
			
			//salbuespen
			galderaErantzuna = sc.nextLine();
			zatiak= galderaErantzuna.split("#");
			galdera = zatiak[0];
			eranPosible1 = zatiak[1];
			eranPosible2 = zatiak[2];
			eranPosible3 = zatiak[3];
			eranPosible4 = zatiak[4];
			zuzena = zatiak[5];
			eranEgokia = Integer.parseInt(zuzena);				
			
			galderaBat=new Galdera(galdera, eranPosible1, eranPosible2, eranPosible3, eranPosible4, eranEgokia);
			pZerrenda.add(galderaBat);
		}
		sc.close();	
		
	}
	
	
}

