public class Tv extends Electronics {
	private int diastasi_othonis;
	private String analysi;
	private static String Thyres;
	
	
	public Tv (int serialNumber, String modelName, int modelYear, String constructor, double price, int availableItems, String Type, int diastasi_othonis,String analysi,String Thyres){
		super(serialNumber, modelName, modelYear, constructor, price, availableItems, Type);
		this.diastasi_othonis= diastasi_othonis;
		this.analysi = analysi;
		this.Thyres = Thyres;
	}


	public String getThyres(){
		return Thyres;
	}
	public String getAnalysi(){
		return analysi;
	}
	public int getDiastasi_othonis(){
		return diastasi_othonis;
	}


	public String toString(){
		return super.toString()+
				"\nScreen Dimension:"+getDiastasi_othonis() +
				"\nAnalysis: "+getAnalysi()+
				"\nUsb Hubs: "+getThyres();
	}
}	