package packtribial;
import java.util.Random;
import java.util.Scanner;

public class Dadoa {
    //atributuak
	private int goikoAldea;
    private static int aldeKopurua = 6;
    private static Dadoa nireDadoa = null;
    
    //metodo eraikitzaileak
    private Dadoa(){}
    
    //getters && setters
   
    private void setGoikoAldea(int pGoikoAldea){
    	this.goikoAldea=pGoikoAldea;
    }
    
    public int getGoikoAldea(){
    	return this.goikoAldea;
    }
    
    public static synchronized Dadoa getNireDadoa(){
    	if(Dadoa.nireDadoa == null){
    		Dadoa.nireDadoa = new Dadoa();
    	}
    	return Dadoa.nireDadoa;
    }
    
    public void bota(){
    	Random zenbakiRandomak=new Random();
    	int egungoBalioa;
    	egungoBalioa=zenbakiRandomak.nextInt(Dadoa.aldeKopurua) + 1;
    	this.setGoikoAldea(egungoBalioa);   	
    }
    
    /*
    public void sartuNahiDuzunPuntuazioa() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Sartu nahi duzun puntuazioa:");
    	int punt = sc.nextInt();
    	this.setGoikoAldea(punt);
    }
    */
}