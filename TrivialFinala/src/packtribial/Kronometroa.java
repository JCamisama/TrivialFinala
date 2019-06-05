package packtribial;

public class Kronometroa {
	
	//atributuak
	private static Kronometroa nireKronometroa = null;
	
	//eraikitazilea
		private Kronometroa() {			
		}
			
	//gainotzeko metodoak
		public static synchronized Kronometroa getNireKronometroa() {
			if(Kronometroa.nireKronometroa == null) {
				Kronometroa.nireKronometroa = new Kronometroa();
			}
			return Kronometroa.nireKronometroa;		
		}
		
		
		private long zeroMomentua;
		public void zeroanJarri()
		{
		 zeroMomentua = System.currentTimeMillis();
		}
		public int pasaDirenSegunduakLortu()
		{
		 return (int) (System.currentTimeMillis() - zeroMomentua) / 1000;
		}		
}
