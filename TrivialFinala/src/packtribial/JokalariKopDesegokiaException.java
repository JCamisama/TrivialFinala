package packtribial;

public class JokalariKopDesegokiaException extends Exception {
	
	String mezua="Jokalari kopuru desegokia. ";
	
	JokalariKopDesegokiaException(){
		super();
	}
	public void inprimatu(){
		System.out.println(mezua);
	}
}
