package packtribial;

public class JokalariKopDesegokiaException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String mezua="Jokalari kopuru desegokia. ";
	
	JokalariKopDesegokiaException(){
		super();
	}
	public void inprimatu(){
		System.out.println(mezua);
	}
}
