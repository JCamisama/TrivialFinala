package packtribial;

public class MugimenduDesegokiaException extends Exception {
	
	String mezua="Mugimendu desegokia sartu duzu, saiatu berriz. ";
	
	public MugimenduDesegokiaException(){
		super();
	}
	
	public void inprimatu(){
		System.out.println(mezua);
	}
}
