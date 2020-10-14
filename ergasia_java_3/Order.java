import java.util.ArrayList;
import java.util.Date;

public class Order {
    private int orderCode;
    private String orderModelName;
    private String fullName;
    private long phoneNumber;
    private String orderDate;
    private String orderArrivalDate;
    private static String status;
    private Product product;
	//private String date;
	//private String aridate;

	/*
    public Order(Product  product, int orderCode, String fullName, long phoneNumber) {
        this.orderCode = orderCode;
        this.orderModelName = product.getModelName();
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.orderDate = new Date();
        this.orderArrivalDate = new Date(orderDate.getTime() + (1000*60*60*24));
        this.status = "in progress";
        this.product = product;
    }*/
	public Order(Product  product, int orderCode, String fullName, long phoneNumber, String ordDate, String ariDate) {
        this.orderCode = orderCode;
        this.orderModelName = product.getModelName();
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.orderDate = ordDate;
        this.orderArrivalDate = ariDate;
        this.status = "in progress";
        this.product = product;
    }

    public void getOrderArrivalDate() {
        System.out.println(this.orderArrivalDate);
    }



    public String toString(){
        return "Order code: " + orderCode +  "\nFull name: " +   fullName + "\nPhone number: " +  phoneNumber + " \nDate of order: " + orderDate +  "\nArrival Date: " + orderArrivalDate ;

    }

    public String getOrderModel() {
        return  product.getModelName() ;
    }
    public Product getProductOfOrder(){
        return product;
    }
    public String getOrderName(){
        return fullName;
    }
    public long getOrderphone(){
        return phoneNumber;
    }
	public String getStatus(){
        return status;
    }
	public String getOrderArriveDate(){
        return orderArrivalDate;
    }
	public String getOrderDate(){
		return orderDate;
	}
	public String getOrderType(){
		return product.getType();
	}
	public String getOrderManufacturer(){
		return product.getManufacturer();
	}
	public int getorderCode(){
		return orderCode;
	}
	public double getOrderPrice(){
		return product.getPrice();
	}
	

}



