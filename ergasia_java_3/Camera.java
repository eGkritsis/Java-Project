public class Camera extends Electronics {
	private int Megapixel;
	private String Optical_zoom;
	private String Digital_zoom;
	private double Screen_size;
	
	public Camera (int serialNumber, String modelName, int modelYear, String constructor, double price, int availableItems, String Type, int Megapixel, String Optical_zoom, String Digital_zoom, double Screen_size){
		super(serialNumber, modelName, modelYear, constructor, price, availableItems, Type);
		this.Megapixel=Megapixel;
		this.Optical_zoom=Optical_zoom;
		this.Digital_zoom=Digital_zoom;
		this.Screen_size=Screen_size;
	}
	
	public int getMegapixel(){
		return Megapixel;
	}
	
	public String getOptical_zoom(){
		return Optical_zoom;
	}
	
	public String getDigital_zoom(){
		return Digital_zoom;
	}
	
	public double getScreen_size(){
		return Screen_size;
	}

	public String toString(){
		return super.toString() +
				"\nMegapixel: "+getMegapixel()+
				"\nOptical zoom: "+getOptical_zoom()+
				"\nDigital zoom: " + getDigital_zoom()+
				"\nScreen Size: " + getScreen_size();
	}
}