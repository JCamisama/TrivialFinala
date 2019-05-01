package packtribial;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaString {
	private ArrayList<String> lista;
	
	public ListaString(){
		this.lista=new ArrayList<String>();
	}
	
	private Iterator<String> getIteradorea(){
		return this.lista.iterator();
	}
	
	public void gehituString(String pString){
		this.lista.add(pString);
	}
	
	public void inprimatu() {
		Iterator<String> itr=this.getIteradorea();
		String stringBat;
		while (itr.hasNext()){
			stringBat=itr.next();
			System.out.println("\n");
			System.out.println(stringBat);
		}
	}
}
