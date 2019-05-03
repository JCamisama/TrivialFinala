package packtribial;

public class AukeraDesegokiaException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String mezua="Sartu duzun aukera ez dago, saiatu berriz. ";
	
	public AukeraDesegokiaException(){
		super();
	}
	
	public void inprimatu(){
		System.out.println(mezua);
	}
			
	
}
