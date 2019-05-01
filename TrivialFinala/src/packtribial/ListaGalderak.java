package packtribial;

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


		
	public void galderakKonfiguratu() {
		
		
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
	}
	
	public boolean galderakFormulatu(String kolorea){
			
			Random zenbakiRandomak=null;
			int egungoBalioa = 0;
			Galdera galderaBat = null;
			Galdera galderaBi = null;
			boolean erantzuna= false;
			
					
			switch (kolorea) {
			
			case "berdea":				
				
			    zenbakiRandomak=new Random();
			    egungoBalioa=zenbakiRandomak.nextInt(19);			    
			    galderaBat = this.listaBerde.get(egungoBalioa);
			    erantzuna =  galderaBat.erantzunZuzena();
				
				break;
				
			case "gorria":
				
				zenbakiRandomak=new Random();
			    egungoBalioa=zenbakiRandomak.nextInt(19);
			    galderaBat = this.listaGorri.get(egungoBalioa);
			    erantzuna =  galderaBat.erantzunZuzena();
				
				
				break;
				
			case "horia":
				
				zenbakiRandomak=new Random();
			    egungoBalioa=zenbakiRandomak.nextInt(19);
			    galderaBat = this.listaHori.get(egungoBalioa);
			    erantzuna =  galderaBat.erantzunZuzena();
				
				break;
				
			case "laranja":
				
				zenbakiRandomak=new Random();
			    egungoBalioa=zenbakiRandomak.nextInt(19);
			    galderaBat = this.listaLaranja.get(egungoBalioa);
			    erantzuna =  galderaBat.erantzunZuzena();
				
				
				break;
			
			case "morea":
				
				zenbakiRandomak=new Random();
			    egungoBalioa=zenbakiRandomak.nextInt(19);
			    galderaBat = this.listaMore.get(egungoBalioa);
			    erantzuna =  galderaBat.erantzunZuzena();
				
				
				break;
				
			case "urdina":
				
				zenbakiRandomak=new Random();
			    egungoBalioa=zenbakiRandomak.nextInt(19);
			    galderaBat = this.listaUrdi.get(egungoBalioa);
			    erantzuna =  galderaBat.erantzunZuzena();
				
				
				break;
				
			}				
			
			return erantzuna;
			
		}
	
	public void erreseteatu(){
		ListaGalderak.nireListaGalderak=null;
	}
}

