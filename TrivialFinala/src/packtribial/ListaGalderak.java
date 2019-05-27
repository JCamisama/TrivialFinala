package packtribial;


import java.io.InputStreamReader;
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
		
		
		//eraikitzailea
		private ListaGalderak(){
			this.listaBerde = new ArrayList<Galdera>();
			this.listaGorri = new ArrayList<Galdera>();
			this.listaLaranja = new ArrayList<Galdera>();
			this.listaHori = new ArrayList<Galdera>();
			this.listaMore = new ArrayList<Galdera>();
			this.listaUrdi = new ArrayList<Galdera>();
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
	
}
		
/*	public void galderakKonfiguratu() {
		
		
		Galdera galderaBat=null;
		String[] zatiak=null;
		InputStream fitx=null;
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
		fitx = this.getClass().getClassLoader().getResourceAsStream("Fitxategiak/GalderaGorriaBideo-jokoak.txt");
		in= new InputStreamReader(fitx);
		sc = new Scanner(in);
		
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
			this.listaGorri.add(galderaBat);
		}
		sc.close();
		
		
		fitx = this.getClass().getClassLoader().getResourceAsStream("Fitxategiak/Galdera_berdeaBiologia.txt");
		in= new InputStreamReader(fitx);			
		sc = new Scanner(in);
		
		while(sc.hasNextLine()) {
			
			
			
			
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
			this.listaBerde.add(galderaBat);
			
			
			
			
		}
		sc.close();
		fitx = this.getClass().getClassLoader().getResourceAsStream("Fitxategiak/GalderaHoriaKirolak.txt");
		in= new InputStreamReader(fitx);			
		sc = new Scanner(in);
		
		while(sc.hasNextLine()) {
			
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
			this.listaHori.add(galderaBat);
			
		}
		sc.close();
		fitx = this.getClass().getClassLoader().getResourceAsStream("Fitxategiak/GalderaLaranjaentretenimendua.txt");
		in= new InputStreamReader(fitx);			
		sc = new Scanner(in);
		
		
		while(sc.hasNextLine()) {
			
			
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
			this.listaLaranja.add(galderaBat);
			
		}
		sc.close();
		fitx = this.getClass().getClassLoader().getResourceAsStream("Fitxategiak/Galdera_moreaOtaku.txt");
		in= new InputStreamReader(fitx);			
		sc = new Scanner(in);
		
		while(sc.hasNextLine()) {
			
			
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
			this.listaMore.add(galderaBat);
			
		}
		sc.close();
		fitx = this.getClass().getClassLoader().getResourceAsStream("Fitxategiak/Galdera_UrdinaGeografia.txt");
		in= new InputStreamReader(fitx);			
		sc = new Scanner(in);
		
		while(sc.hasNextLine()) {
			
			
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
			this.listaUrdi.add(galderaBat);
			
		}	
		sc.close();
	}
	*/
	public boolean galderakFormulatu(String kolorea){
			
			Random zenbakiRandomak=null;
			int egungoBalioa = 0;
			Galdera galderaBat = null;
			boolean erantzuna= false;
			
			
					
			switch (kolorea) {
			
			case "berdea":				
				
				zenbakiRandomak=new Random();
				int galderaKop = this.listaBerde.size(); 
			    egungoBalioa=zenbakiRandomak.nextInt(galderaKop - 1);			    
			    galderaBat = this.listaBerde.get(egungoBalioa);
			    erantzuna =  galderaBat.erantzunZuzena();
			    this.listaBerde.remove(egungoBalioa);
			    if (this.listaBerde.size()==0) {
			    	
			    	this.hasieratuGalderenZerrenda(kolorea);
			    	
			    }
				
				break;
				
			case "gorria":
				
				zenbakiRandomak=new Random();
			    egungoBalioa=zenbakiRandomak.nextInt(19);
			    galderaBat = this.listaGorri.get(egungoBalioa);
			    erantzuna =  galderaBat.erantzunZuzena();
			    this.listaGorri.remove(egungoBalioa);
			    if (this.listaGorri.size()==0) {
			    	
			    	this.hasieratuGalderenZerrenda(kolorea);
			    	
			    }
				
				break;
				
			case "horia":
				
				zenbakiRandomak=new Random();
			    egungoBalioa=zenbakiRandomak.nextInt(19);
			    galderaBat = this.listaHori.get(egungoBalioa);
			    erantzuna =  galderaBat.erantzunZuzena();
			    this.listaHori.remove(egungoBalioa);
			    if (this.listaHori.size()==0) {
			    	
			    	this.hasieratuGalderenZerrenda(kolorea);
			    	
			    }
			    
				break;
				
			case "laranja":
				
				zenbakiRandomak=new Random();
			    egungoBalioa=zenbakiRandomak.nextInt(19);
			    galderaBat = this.listaLaranja.get(egungoBalioa);
			    erantzuna =  galderaBat.erantzunZuzena();
			    this.listaLaranja.remove(egungoBalioa);
			    if (this.listaLaranja.size()==0) {
			    	
			    	this.hasieratuGalderenZerrenda(kolorea);
			    	
			    }
				
				break;
			
			case "morea":
				
				zenbakiRandomak=new Random();
			    egungoBalioa=zenbakiRandomak.nextInt(19);
			    galderaBat = this.listaMore.get(egungoBalioa);
			    erantzuna =  galderaBat.erantzunZuzena();
			    this.listaMore.remove(egungoBalioa);
			    if (this.listaMore.size()==0) {
			    	
			    	this.hasieratuGalderenZerrenda(kolorea);
			    	
			    }
				
				break;
				
			case "urdina":
				
				zenbakiRandomak=new Random();
			    egungoBalioa=zenbakiRandomak.nextInt(19);
			    galderaBat = this.listaUrdi.get(egungoBalioa);
			    erantzuna =  galderaBat.erantzunZuzena();
			    this.listaUrdi.remove(egungoBalioa);
			    if (this.listaUrdi.size()==0) {
			    	
			    	this.hasieratuGalderenZerrenda(kolorea);
			    	
			    }
				
				break;
				
			}				
			
			return erantzuna;
			
		}
	
	public void erreseteatu(){
		ListaGalderak.nireListaGalderak=null;
	}
	
	private void hasieratuGalderenZerrenda(String kolorea) {
		
		ArrayList<Galdera> zerrenda = null;
		InputStream fitx = null;
		
		switch (kolorea) {
		
			case "berdea":
			
				fitx = this.getClass().getClassLoader().getResourceAsStream("Fitxategiak/Galdera_berdeaBiologia.txt");
				zerrenda= this.listaBerde;
				break;
				
			case "gorria":
				
				fitx = this.getClass().getClassLoader().getResourceAsStream("Fitxategiak/GalderaGorriaBideo-jokoak.txt");
				zerrenda= this.listaGorri;
				break;
				
			case "laranja":
				
				fitx = this.getClass().getClassLoader().getResourceAsStream("Fitxategiak/GalderaLaranjaentretenimendua.txt");
				zerrenda= this.listaLaranja;
				break;
				
			case "horia":
				
				fitx = this.getClass().getClassLoader().getResourceAsStream("Fitxategiak/GalderaHoriaKirolak.txt");
				zerrenda= this.listaHori;
				break;
				
			case "morea":
				
				fitx = this.getClass().getClassLoader().getResourceAsStream("Fitxategiak/Galdera_moreaOtaku.txt");
				zerrenda= this.listaMore;
				break;
				
			case "urdina":
				
				fitx = this.getClass().getClassLoader().getResourceAsStream("Fitxategiak/Galdera_UrdinaGeografia.txt");
				zerrenda= this.listaUrdi;
				break;			
		}		
		
		this.hasieratuLista(zerrenda, fitx);
	}
	
	
	private void hasieratuLista(ArrayList<Galdera> zerrenda, InputStream fitx) {
		
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
		in= new InputStreamReader(fitx);
		sc = new Scanner(in);
		
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
			zerrenda.add(galderaBat);
		}
		sc.close();	
		
	}
	
	
}

