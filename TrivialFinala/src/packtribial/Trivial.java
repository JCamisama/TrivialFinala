package packtribial;

public class Trivial {
	
	private static Trivial nireTrivial;
	
	private Trivial() {
		
	}
	
	public static synchronized Trivial getNireTrivial() {
		if(Trivial.nireTrivial == null) {
			Trivial.nireTrivial = new Trivial();
		}
		return Trivial.nireTrivial;
	}
	private void partidaBatJolastu() {
		this.erreseteatu();
		//Salbuespen 2 jokalari minimo.
		int jokalariKop=Teklatua.getTeklatua().irakurriOsoa("Sartu jokalari kopurua, 2-6 jokalari");
		this.partidaHasieratu(jokalariKop);
		ListaJokalariak.getNireListaJokalariak().jokalarienTxandaKudeatu(jokalariKop);//TODO
	}
	
	private void partidaHasieratu(int pJokalariKop) {
		ListaJokalariak.getNireListaJokalariak().hasieratuJokalariak(pJokalariKop);
		Tableroa.getNireTableroa().tableroaHasieratu();
	}
	
	private void erreseteatu(){
		Tableroa.getNireTableroa().erreseteatu();
		ListaJokalariak.getNireListaJokalariak().erreseteatu();
		ListaGalderak.getNireListaGalderak().erreseteatu();
	}
	
	public static void main(String args[]){
		Trivial.getNireTrivial().partidaBatJolastu();
	}
}
