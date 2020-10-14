import java.util.*;
import java.io.*;

class CreateFilesApp { 
	
		
	
	public void CreateSalesFile(ArrayList <Sale> sold_items){
		System.out.println(" >>>>>>> Write data from ARRAYLIST sold_items to FILE sales ...");
		FileWriter writer = null;
		
		try {
			writer = new FileWriter(new File("SalesList.txt"));
				writer.write("SALES_LIST"+"\n"+"{");
			for (Sale sold_item: sold_items){
				writer.write("\n"+"\t"+"SALE"
				+"\n"+"\t"+"{"
				+"\n"+"\t"+"\t"+"ITEM_TYPE "+sold_item.getSaleType()
				+"\n"+"\t"+"\t"+"MODEL " + sold_item.getDeviceModel()
				+"\n"+"\t"+"\t"+"MANUFACTURER "+sold_item.getSaleManufacturer()
				+"\n"+"\t"+"\t"+"SALES_NUMBER "+sold_item.getSaleCode()
				+"\n"+"\t"+"\t"+"NAME "+sold_item.getFullName()
				+"\n"+"\t"+"\t"+"DATE "+sold_item.getpurchaseDate()
				+"\n"+"\t"+"\t"+"PHONE NUMBER "+sold_item.getPhoneNumber()
				+"\n"+"\t"+"}");
				
				
				}
			writer.write("\n"+"}");	
			writer.close();
		}
		catch (IOException e) {
				System.err.println("Error writing file.");
			}
		
	}
	public void CreateOrdersFile(ArrayList <Order> ordered_items){
		System.out.println(" >>>>>>> Write data from ARRAYLIST ordered_items to FILE orders ...");
		FileWriter writer = null;
		
		try {
			writer = new FileWriter(new File("orders.txt"));
			writer.write("ORDER_LIST "+"\n"+"{");
			for (Order ordered_item: ordered_items){
				writer.write("\n"+"\t"+"ORDER"
				+"\n"+"\t"+"{"
				+"\n"+"\t"+"\t"+"ITEM_TYPE "+ordered_item.getOrderType()
				+"\n"+"\t"+"\t"+"MODEL " + ordered_item.getOrderModel()
				+"\n"+"\t"+"\t"+"MANUFACTURER "+ordered_item.getOrderManufacturer()
				+"\n"+"\t"+"\t"+"ORDER_NUMBER "+ordered_item.getorderCode()
				+"\n"+"\t"+"\t"+"NAME "+ordered_item.getOrderName()
				+"\n"+"\t"+"\t"+"ORDER DATE "+ordered_item.getOrderDate()
				+"\n"+"\t"+"\t"+"DELIVERY DATE "+ordered_item.getOrderArriveDate()
				+"\n"+"\t"+"\t"+"PRICE "+ordered_item.getOrderPrice()
				+"\n"+"\t"+"\t"+"STATUS "+ordered_item.getStatus()
				+"\n"+"\t"+"\t"+"PHONE_NUMBER "+ordered_item.getOrderphone()
				+"\n"+"\t"+"}");
			}
		writer.write("\n"+"}");	
		writer.close();	
		}		
		catch (IOException e) {
				System.err.println("Error writing file.");
			}		
	}	
}	
			