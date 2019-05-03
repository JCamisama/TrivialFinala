package packtribial;

public class MugimenduDesegokiaException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String mezua="Mugimendu desegokia sartu duzu, saiatu berriz. ";
	
	public MugimenduDesegokiaException(){
		super();
	}
	
	public void inprimatu(){
		System.out.println(mezua);
	}
}
