import java.util.ArrayList;
import java.util.Date;

public class Sale {
    private int SaleCode;
    private String DeviceModel;
    private String FullName;
    private long PhoneNumber;
    private static ArrayList<Sale> soldItems = new ArrayList<Sale>();
	private Product product;
	private String purchaseDate;

    public Sale (Product  product , int SaleCode, String DeviceModel, String FullName ,long PhoneNumber,String date ) {
		this.product=product;
        this.SaleCode = setSaleCode(SaleCode);
        this.DeviceModel = DeviceModel;
        this.FullName = FullName;
        this.PhoneNumber = PhoneNumber;
        this.purchaseDate =  date;
        if(!product.mustOrder()) {
            product.changeAvailableItems();
        } else {
            System.out.println("NO ITEMS REMAINING");
        }
    }

    public Sale(int SaleCode, String DeviceModel, String FullName, long PhoneNumber, String date) {
    	this.SaleCode = SaleCode;
    	this.DeviceModel = DeviceModel;
    	this.FullName = FullName;
    	this.PhoneNumber = PhoneNumber;
    	this.purchaseDate = date;
	}

	public int getSaleCode(){
		return this.SaleCode;
	}
	public String getFullName(){
		return this.FullName;
	}
	public String getpurchaseDate(){
		return this.purchaseDate;
	}
	public String getDeviceModel(){
		return this.DeviceModel;
	}
	public String getSaleManufacturer(){
		return product.getManufacturer();
	}
	public String getSaleType(){
		return product.getType();
	}
	public long getPhoneNumber(){
		return this.PhoneNumber;
	}
	



    public int setSaleCode(int SaleCode) {
            if (!soldItems.contains(SaleCode)) {
                return SaleCode;
            } else {
                return SaleCode + 1;
            }
    }
    public void setDeviceModel(String modelName) {
    	this.DeviceModel = modelName;
	}
	public void setFullName(String name) {
    	this.FullName = name;
	}
	public void setPhoneNumber(long phoneNumber) {
    	this.PhoneNumber = phoneNumber;
	}
	public void setPurchaseDate(String date) {
    	this.purchaseDate = date;
	}
	public void setCode(int code) {
    	this.SaleCode = code;
	}




	public String toString(){
		return "Sale code: " +this.SaleCode+
				"\nDevice model: " +this.DeviceModel+
				"\nBuyer's name: " +this.FullName+
				"\nPhoneNumber: " +this.PhoneNumber+
				"\nDate of purchase: " +this.purchaseDate;
	}
}
