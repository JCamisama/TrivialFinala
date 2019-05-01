package packtribial;

public class JokalariaAldaketak {
	private boolean hasierakoPasilloan;
	private int posizioaErrenkada;
	private int posizioaZutabea;
	private boolean txandarenEmaitza;
	private boolean partidaAmaituDa;
	
	public JokalariaAldaketak(boolean pHasierakoPasilloan, int pPosizioaErrenkada, int pPosizioaZutabea, boolean pTxandarenEmaitza,
			boolean pPartidaAmaituDa){
		this.hasierakoPasilloan=pHasierakoPasilloan;
		this.posizioaErrenkada=pPosizioaErrenkada;
		this.posizioaZutabea=pPosizioaZutabea;
		this.txandarenEmaitza=pTxandarenEmaitza;
		this.partidaAmaituDa=pPartidaAmaituDa;
	}
	public boolean getHasierakoPasilloa(){
		return this.hasierakoPasilloan;
	}
	public int getPosizioaErrenkada(){
		return this.posizioaErrenkada;
	}
	public int getPosizioaZutabea(){
		return this.posizioaZutabea;
	}
	public boolean getTxandarenEmaitza(){
		return this.txandarenEmaitza;
	}
	public boolean getPartidaAmaituDa(){
		return this.partidaAmaituDa;
	}
}
