public class Blueray_dvd extends Electronics{
	private String Analysi;
	private String Format;
	
	public Blueray_dvd(int serialNumber, String modelName, int modelYear, String constructor, double price, int availableItems, String Type, String Analysi, String Format){
		super(serialNumber, modelName, modelYear, constructor, price, availableItems, Type);
		this.Analysi=Analysi;
		this.Format= Format;
	}


	public String getFormat(){
		return Format;
	}
	
	public String getAnalysi(){
		return Analysi;
	}
	
	public String toString(){
		return super.toString()+
				"\nResolution: "+getAnalysi()+
				"\nFormat: "+getFormat() ;
	}
}