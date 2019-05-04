package packtribial;

import java.util.ArrayList;


public class ListaGaztatxoak {
	
	private ArrayList<String> lista; //Kolorezko gaztatxoak gordetzeko
	
	public ListaGaztatxoak(){
		
		lista = new ArrayList<String>();
	}
	
	public void gehituGaztatxoa(String pGaztatxoa){
		
		// Metodo hau pantailan galderen erantzunaren emaitzak inprimatzeko aukera daukagu!!!

        if(!this.badago(pGaztatxoa) && pGaztatxoa!="zuzena" && pGaztatxoa!="okerra"){

            this.lista.add(pGaztatxoa);
            System.out.println("Gazta "+pGaztatxoa+" lortu duzu, zorionak! \n");
        }

        else if(pGaztatxoa == "zuzena"){
        	
        	System.out.println("Ondo erantzun duzu galdera, baina ez duzu gazta berririk lortu, lauki normala delako. \n");
        		
        }
        
        else if(pGaztatxoa == "okerra"){
        	
        	System.out.println("Txarto erantzun duzu galdera edo denbora pasatu da. \n");
        	
        }
        
        else{

            System.out.print("Gaztaxo "+ pGaztatxoa + " jadanik lortu duzu! \n");
            
        }
    }


    public boolean badago(String pGaztatxoa){

        return this.lista.contains(pGaztatxoa);

    }

    public int zenbatGaztatxo(){

        return this.lista.size();
    }
	

}
