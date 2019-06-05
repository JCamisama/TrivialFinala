package packtribial;

import java.io.InputStreamReader;
import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class ListaJokalariak {
	//atributuak
	private Jokalaria[] lista;
	private static ListaJokalariak nireListaJokalariak = null;
    private int jokalariKop=2;//defektuz 2 jokalari 
    private int luzera=0;
	//eraikitazilea
	private ListaJokalariak() {
		this.setJokalariKop();
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
		luzera++;

	}
	
	public void jokalarienTxandaKudeatu() {
		int txanda=-1;
		boolean garailea=false;
		while(!garailea){
			txanda++;
			if (txanda==this.jokalariKop){
				txanda=0;
			}
			garailea=lista[txanda].txandaBurutu(); 
		}
		this.partidaBukatu(lista[txanda].getFitxarenKolorea());
	}
	
	public void partidaBukatu(String pFitxarenKolorea) {
		System.out.println("Zorionak " + pFitxarenKolorea + " partida irabazi egin du!!!");
	}
	private void setJokalariKopSalbuespen() throws JokalariKopDesegokiaException{
		int jokalariKopurua=Teklatua.getTeklatua().irakurriOsoa("Sartu jokalari kopurua, 2-6 jokalari");
		if(jokalariKopurua<2 || jokalariKopurua>6){
			throw (new JokalariKopDesegokiaException());
		}
		this.jokalariKop=jokalariKopurua;
	}
	
	private void setJokalariKop(){
		
			boolean kontrolpean=false;
			do{
				try{
					this.setJokalariKopSalbuespen();
					kontrolpean=true;
			}
				catch (JokalariKopDesegokiaException e){
					e.inprimatu();
				}
		}while (!kontrolpean);
		

	}
	
	public void erreseteatu(){
		ListaJokalariak.nireListaJokalariak=null;
	}
	
	public void hasieratuJokalariak(){
		
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
		int kont=0;
		
		String fitxategia="Fitxategiak"+File.separator+"JokalariFitxategi.txt";
		fitx = this.getClass().getClassLoader().getResourceAsStream(fitxategia);
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
		sc.close();
	}
}
