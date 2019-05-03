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
		try{
		this.partidaHasieratu();
			ListaJokalariak.getNireListaJokalariak().jokalarienTxandaKudeatu();
		}
		catch (NullPointerException e){
			System.out.println("Fitxategiren bat txarto jarrita dago, aldatu ezazu berriro jolastu baino lehen. ");
		}
		//TODO
	}
	
	private void partidaHasieratu() {
		ListaJokalariak.getNireListaJokalariak().hasieratuJokalariak();
		Tableroa.getNireTableroa().tableroaHasieratu();
		ListaGalderak.getNireListaGalderak().galderakKonfiguratu();
	}
	
	private void erreseteatu(){
		Tableroa.getNireTableroa().erreseteatu();
		ListaGalderak.getNireListaGalderak().erreseteatu();
	}
	
	public static void main(String args[]){
		Trivial.getNireTrivial().partidaBatJolastu();
	}
}
