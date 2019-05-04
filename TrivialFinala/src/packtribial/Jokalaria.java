package packtribial;


public class Jokalaria {
	
	//Atributuak
	private String			kolorea;
	//Ipini ahal da nick-a
	private ListaGaztatxoak	puntuak;
	private int				posizioaErrenkada;
	private int				posizioaZutabea;
	private boolean 		hasierakoPasilloan; //True 6-etako pasilloren batean badago
	//private boolean			garailea;
		
	//Eraikitzailea
	
	public Jokalaria(String pKolorea, int pPosizioaErrenkada, int pPosizioaZutabea, boolean pHasierakoPasilloa){
		this.kolorea=pKolorea;
		this.puntuak=new ListaGaztatxoak();
		this.posizioaErrenkada=pPosizioaErrenkada;
		this.posizioaZutabea=pPosizioaZutabea;
		this.hasierakoPasilloan=pHasierakoPasilloa;
		
	}
	
	
	public boolean txandaBurutu(){

		boolean garaileaDa=false;
		boolean txandarenEmaitza=false;					//Konprobatzeko ea jokalariak ondo edo txarto erantzun duen, txanda errepikatzeko
		int kont = 0;									//Jokalariaren zein txanda pasatu den jakiteko
        JokalariaAldaketak aldaketak = null;
        Tableroa tableroHau = Tableroa.getNireTableroa();
        Dadoa dadoHau = Dadoa.getNireDadoa();
        
        do{
        	kont++;
        	if (this.hasierakoPasilloan){
	        	Teklatua.getTeklatua().skipLine(kont+".txanda: Jokalari " + this.kolorea + " " + this.posizioaErrenkada + ".pasilloko " + this.posizioaZutabea +".posiziokoa, sakatu ENTER dadoa botatzeko");
	        }
        	else{
        	Teklatua.getTeklatua().skipLine("Jokalari " + this.kolorea + " zirkuluko " + this.posizioaZutabea +".posiziokoa, sakatu ENTER dadoa botatzeko");
        	}
	        dadoHau.bota();
	        int ateratakoa = dadoHau.getGoikoAldea();
	        Teklatua.getTeklatua().skipLine( "Sakatu ENTER fitxa " + ateratakoa + " posizio mugitzeko");
	
	        //Tableroa klasean fitxa mugitzeko
	        
	        /*garaileaDa=tableroHau.fitxaMugitu(this, this.pasilloa, this.posizioaErrenkada, this.posizioaZutabea
	        		, this.puntuak, ateratakoa);*/
	                //ateratakoa, this.pasilloa, this.posizioaErrenkada, this.posizioaZutabea, );
	        aldaketak=tableroHau.fitxaMugitu(this.hasierakoPasilloan, this.posizioaErrenkada, this.posizioaZutabea, 
	        								  this.puntuak, ateratakoa);
	        
	        garaileaDa=aldaketak.getPartidaAmaituDa();
	        this.setPasilloa(aldaketak.getHasierakoPasilloa());
	        this.setPosizioaErrenkada(aldaketak.getPosizioaErrenkada());
	        this.setPosizioaZutabea(aldaketak.getPosizioaZutabea());
	        txandarenEmaitza = aldaketak.getTxandarenEmaitza();
        
	        
	        System.out.println("Jokalari "+this.kolorea+" "+kont+".txanda bukatu du.");
	        if (!garaileaDa){
	        	if (this.hasierakoPasilloan){
	        		Teklatua.getTeklatua().skipLine("Jokalari "+this.kolorea+" "+this.posizioaErrenkada+".pasilloko "+this.posizioaZutabea+".kasillan bukatu du txanda.\n");
	        	}
	        	else{
	        		Teklatua.getTeklatua().skipLine("Jokalari "+this.kolorea+" "+this.posizioaZutabea+".kasillan bukatu du txanda. \n");
	        	}
	        }
	        else{
	        	Teklatua.getTeklatua().skipLine("Jokalari "+this.kolorea+" partida bukatu du. \n");
	        }
        }while(txandarenEmaitza && !garaileaDa);
        
        
        
        
        
        return garaileaDa;
	    }
	
	public String getFitxarenKolorea(){
		return this.kolorea;
	}
	public void gehituGaztatxoa(String pGaztatxoa){
		this.puntuak.gehituGaztatxoa(pGaztatxoa);
	}
	public void setPosizioaErrenkada(int pPosizioaErrenkada){
		this.posizioaErrenkada=pPosizioaErrenkada;
	}
	public void setPosizioaZutabea(int pPosizioaZutabea){
		this.posizioaZutabea=pPosizioaZutabea;
	}
	public void setPasilloa(boolean pHasierakoPasilloa){
		this.hasierakoPasilloan=pHasierakoPasilloa;
	}
}


