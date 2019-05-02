package packtribial;

import java.io.InputStreamReader;

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

public class ListaJokalariak {
	//atributuak
	private Jokalaria[] lista;
	private static ListaJokalariak nireListaJokalariak = null;
    private int jokalariKop=2;//defektuz 2 jokalari (1 Array-ak 0-an hasten direlako).
    private int luzera=0;
	//eraikitazilea
	private ListaJokalariak() {
		this.jokalariKop=Teklatua.getTeklatua().irakurriOsoa("Sartu jokalari kopurua, 2-6 jokalari");
		this.lista = new Jokalaria[this.jokalariKop];
	}

	//gainotzeko metodoak
	public static synchronized ListaJokalariak getNireListaJokalariak() {
		if(ListaJokalariak.nireListaJokalariak == null) {
			ListaJokalariak.nireListaJokalariak = new ListaJokalariak();
		}
		return ListaJokalariak.nireListaJokalariak;
	}
	
	public void gehituJokalaria(Jokalaria pJokalaria) {
		//Salbuespen if jokalari kop 6 edo 2
		this.lista[this.luzera]=pJokalaria;
		luzera++;//TODO

	}
	
	public void jokalarienTxandaKudeatu() {
		int txanda=-1;
		boolean garailea=false;
		while(!garailea){ //txanda kopuru limitatua ipini denbora badago
			txanda++;
			if (txanda==this.jokalariKop){// arrayaren indizea eta kopurua ez direlako berdinak!!!
				txanda=0;
			}
			garailea=lista[txanda].txandaBurutu(); //boolean o int no se sabe aún
			//TODO
		}
		this.partidaBukatu(lista[txanda].getFitxarenKolorea());//nick-a ipini diateke
	}
	
	public void partidaBukatu(String pFitxarenKolorea) {
		System.out.println("Zorionak " + pFitxarenKolorea + " partida irabazi egin du!!!");
	}
	
	public void erreseteatu(){
		ListaJokalariak.nireListaJokalariak=null;
	}
	
	public void hasieratuJokalariak(){
		//public Jokalaria(String pKolorea, int pPosizioaErrenkada, int pPosizioaZutabea, boolean pHasierakoPasilloa){
		int kont=0;
		Jokalaria jokalariBat=null;
		String[] zatiak=new String[4];
		InputStream fitx=null;
		InputStreamReader in=null;
		Scanner sc = null;
		String kolorea=null;
		String posizioaE=null;
		String posizioaZ=null;
		String hasierakoP=null;
		String jokalaria=null;
		int posizioaErrenkada=0;
		int posizioaZutabea=0;
		boolean hasierakoPasilloan=true;
		
		fitx = this.getClass().getClassLoader().getResourceAsStream("Fitxategiak/JokalariFitxategi.txt");
		in = new InputStreamReader(fitx);			
		sc = new Scanner(in);
		
		while (kont<this.jokalariKop){
			kont++;
			jokalaria = sc.nextLine();
			zatiak= jokalaria.split("#");
			kolorea = zatiak[0];
			posizioaE = zatiak[1];
			posizioaZ = zatiak[2];
			hasierakoP = zatiak[3];
			posizioaErrenkada = Integer.parseInt(posizioaE);
			posizioaZutabea = Integer.parseInt(posizioaZ);				
			hasierakoPasilloan = Boolean.parseBoolean(hasierakoP);
			jokalariBat=new Jokalaria(kolorea, posizioaErrenkada, posizioaZutabea, hasierakoPasilloan);
			this.gehituJokalaria(jokalariBat);
			
		}
	}
}
