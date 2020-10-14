import javax.swing.*;
import java.io.*;
import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat; 

public class ReadFile2 {

    public ArrayList<Product> available_items = new ArrayList<>();
	public ArrayList <Order> ordered_items = new ArrayList<Order> ();
	public ArrayList<Sale> sold_items = new ArrayList<Sale>();

    public ArrayList<Product> readFile(String fileName) {
        BufferedReader reader = null;
        String item_type = "";
        int code = 0;
        int modelYear = 0;
        int available_products = 0;
        int memory = 0;
        int screen_size = 0;
        int megapixel = 0;
        int turns = 0;
        double capacity = 0.0;
        double maintenance_capacity = 0.0;
        double freezing_capacity = 0.0;
        double price = 0.0;
        String modelName = "";
        String constructor = "";
        String panel = "";
        String resolution = "";
        String interfaces = "";
        String cpu = "";
        String gpu = "";
        String scard = "";
        String type = "";
        String energy_class = "";
        String digital_zoom = "";
        String optical_zoom = "";
        String format = "";

        try {
            reader = new BufferedReader(new FileReader(new File(fileName)));
            String line = reader.readLine();
            if (line == null || !line.toUpperCase().trim().equals("ITEM_LIST".toUpperCase())) {
                throw new Exception("ERROR");
            }
            line = reader.readLine();
            if(line.toUpperCase().equals("{")) {
                //System.out.println("shmeio1");
                int counter = 0;
                while(line != null) {
                    //System.out.println("shmeio2");
                    counter += 1;
                    //System.out.println(counter);
                    line = reader.readLine();
                    if(line != null && line.trim().toUpperCase().equals("ITEM")) {
                        line = reader.readLine();
                        if (line.trim().equals("{")) {
                            boolean flag = false;
                            do {
                                //System.out.println("shmeio3 ");
                                line = reader.readLine().trim().toUpperCase();
                                if (line.split(" ")[0].equals("ITEM_TYPE")) {
                                    item_type = line.substring(10);
                                    //System.out.println("shmeio4");
                                } else if(line.split(" ")[0].equals("CODE")) {
                                    code = Integer.parseInt(line.split(" ")[1]);
                                } else if(line.split(" ")[0].equals("MODEL")) {
                                    modelName = line.substring(6);
                                } else if(line.split(" ")[0].equals("MODEL_YEAR")) {
                                    modelYear = Integer.parseInt(line.split(" ")[1]);
                                } else if(line.split(" ")[0].equals("MANUFACTURER")) {
                                    constructor = line.substring(13);
                                } else if(line.split(" ")[0].equals("PRICE")) {
                                    price = Double.parseDouble(line.split(" ")[1]);
                                } else if(line.split(" ")[0].equals("PANEL_TYPE")) {
                                    panel = line.split(" ")[1];
                                } else if(line.split(" ")[0].equals("DIMENSIONS")){
                                    screen_size  = Integer.parseInt(line.split(" ")[1]);
                                } else if(line.split(" ")[0].equals("RESOLUTION")) {
                                    resolution = line.substring(11);
                                } else if(line.split(" ")[0].equals("INTERFACES")) {
                                    interfaces = line.split(" ")[1];
                                } else if(line.trim().split(" ")[0].equals("PIECES")) {
                                    available_products = Integer.parseInt(line.split(" ")[1]);
                                } else if(line.split(" ")[0].equals("CPU")) {
                                    cpu = line.substring(4);
                                } else if(line.split(" ")[0].equals("GPU")) {
                                    gpu = line.substring(4);
                                } else if(line.split(" ")[0].equals("SCARD")) {
                                    scard = line.substring(6);
                                } else if(line.split(" ")[0].equals("MEMORY")) {
                                    memory = Integer.parseInt(line.split(" ")[1]);;
                                } else if(line.split(" ")[0].equals("TYPE")) {
                                    type = line.substring(5);
                                } else if(line.split(" ")[0].equals("ENERGY_CLASS")) {
                                    energy_class = line.substring(13);
                                } else if(line.trim().split(" ")[0].equals("MAINTENANCE_CAPACITY")) {
                                    maintenance_capacity = Double.parseDouble(line.split(" ")[1]);
                                } else if(line.trim().split(" ")[0].equals("FREEZING_CAPACITY")) {
                                    freezing_capacity = Double.parseDouble(line.split(" ")[1]);
                                } else if(line.trim().split(" ")[0].equals("SCREEN_SIZE")) {
                                    screen_size = Integer.parseInt(line.split(" ")[1]);
                                } else if(line.split(" ")[0].equals("OPTICAL_ZOOM")) {
                                    optical_zoom = line.split(" ")[1];
                                } else if(line.split(" ")[0].equals("DIGITAL_ZOOM")) {
                                    digital_zoom = line.split(" ")[1];
                                } else if(line.split(" ")[0].equals("FORMAT")) {
                                    format = line.substring(7);
                                } else if(line.trim().split(" ")[0].equals("CAPACITY")) {
                                    capacity = Double.parseDouble(line.split(" ")[1]);
                                } else if(line.trim().split(" ")[0].equals("TURNS")) {
                                    turns = Integer.parseInt(line.split(" ")[1]);
                                } else if(line.trim().split(" ")[0].equals("MEGAPIXEL")) {
                                    megapixel = Integer.parseInt(line.split(" ")[1]);
                                } else if(line.equals("}")) {
                                    flag = true;
                                } else {
                                    //System.err.println("ERROR READING ITEM LIST.");
                                    flag = true;
                                }
                            } while(!flag);

                            if(item_type.equals("TV")) {
                               this.available_items.add(new Tv(code, modelName, modelYear, constructor, price, available_products, panel, screen_size, resolution, interfaces));
                            } else if(item_type.equals("CAMERA")) {
                                this.available_items.add(new Camera(code, modelName, modelYear, constructor, price, available_products, type, megapixel, optical_zoom, digital_zoom, screen_size ));
                            } else if(item_type.equals("FRIDGE")) {
                                this.available_items.add(new Fridge(code, modelName, modelYear, constructor, price, available_products, energy_class, maintenance_capacity, freezing_capacity, type));
                            } else if(item_type.equals("GAMING")) {
                                this.available_items.add(new Gaming(code, modelName, modelYear, constructor, price, available_products, type, cpu, gpu, scard, memory));
                            } else if(item_type.equals("WASHING_MACHINE")) {
                                this.available_items.add(new WashingMachine(code, modelName, modelYear, constructor, price, available_products, capacity, turns, energy_class));
                            } else if(item_type.equals("DVD")) {
                                this.available_items.add(new Blueray_dvd(code, modelName, modelYear, constructor, price, available_products, type, resolution, format));
                            }
                        } else if(line.equals("") || line.equals("\n")) {

                        } else {
                            throw new Exception();
                        }
                    }
                }
            } else if(line.toUpperCase().equals("}")) {
                //end
            } else {
                throw new Exception("Error");
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return this.available_items;
    }
	public ArrayList<Order> readFileOrder(String fileName) {
		BufferedReader reader = null;
        String ModelName = "";
		String CostumerName="";
		int OrderNumber=0;
		long Phone=0;
		
		String orddate="";
		String aridate="";
		
		
		try {
            reader = new BufferedReader(new FileReader(new File(fileName)));
            String line = reader.readLine();
            if (line == null || !line.toUpperCase().trim().equals("ORDER_LIST".toUpperCase())) {
                throw new Exception("ERROR");
            }
			line = reader.readLine();
            if(line.toUpperCase().equals("{")) {
                //System.out.println("shmeio1");
                int counter = 0;
                while(line != null) {
                    //System.out.println("shmeio2");
                    counter += 1;
                    //System.out.println(counter);
                    line = reader.readLine();
                    if(line != null && line.trim().toUpperCase().equals("ORDER")) {
                        line = reader.readLine();
                        if (line.trim().equals("{")) {
							boolean flag = false;
                            do {
                                //System.out.println("shmeio3 ");
                                line = reader.readLine().trim().toUpperCase();
                                if (line.split(" ")[0].equals("MODEL")) {
                                    ModelName = line.substring(6);
									
                                    //System.out.println("shmeio4");
                                } else if(line.split(" ")[0].equals("ORDER_NUMBER")) {
                                    OrderNumber = Integer.parseInt(line.split(" ")[1]);
                                } else if(line.split(" ")[0].equals("NAME")) {
                                    CostumerName = line.substring(5);
                                } else if(line.split(" ")[0].equals("PHONE_NUMBER")) {
                                    Phone = Long.parseLong(line.split(" ")[1]);
                                }else if (line.split(" ")[0].equals("ITEM_TYPE")){
								}else if (line.split(" ")[0].equals("MANUFACTURER")){
								}else if (line.split(" ")[0].equals("ORDER")){
									orddate =line.substring(11);
									aridate =line.substring(14);
								}else if (line.split(" ")[0].equals("DELIVERY")){
									aridate =line.substring(14);
								}else if (line.split(" ")[0].equals("PRICE")){
								}else if (line.split(" ")[0].equals("STATUS")){
								}else if(line.equals("}")) {
                                    flag = true;
                                }else {
                                    System.out.println("ERROR READING ITEM LIST.");
                                    flag = true;
                                }
                            } while(!flag);
							for(Product product : available_items) {
								
								if (product.getModelName().equals(ModelName)){
									//Date date1=formatter5.parse(orddate);
									//Date date2=formatter5.parse(aridate);
									this.ordered_items.add(new Order(product,OrderNumber,CostumerName,Phone,orddate,aridate));
									
									
								}
								
							}
						} else if(line.equals("") || line.equals("\n")) {

						} else {
                            throw new Exception();
						}
					}
				}
			}else if(line.toUpperCase().equals("}")) {
                //end
            } else {
                //throw new Exception("Error");
            }
		} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
		
		return this.ordered_items;
	}


    public ArrayList<Sale> ReadSales(String fileName) {
        BufferedReader reader2 = null;
        String item_type= "";
        String model= "" ;
        String creator = "";
        int SaleCode = 0 ;
        String customer= "";
        String Date ="";
        long phone = 0;


        try {
            reader2= new BufferedReader(new FileReader(new File(fileName )));
            String line = reader2.readLine();
            if (line == null || !line.toUpperCase().trim().equals("SALES_LIST".toUpperCase())) {
                throw new Exception("ERROR");
            }
            line = reader2.readLine();
            if (line.toUpperCase().equals("{")) {
                int counter= 0 ;
                while (line!= null){
                    counter += 1;
                    //System.out.print(counter);
                    line = reader2.readLine();
                    if(line != null && line.trim().toUpperCase().equals("SALE")){
                        line = reader2.readLine();
                        if (line.trim().equals("{") ){
                            boolean flag2 = false ;
                            do{
                                line = reader2.readLine().trim().toUpperCase();
                                if (line.split(" ")[0].equals("ITEM_TYPE") ){
                                    item_type= line.substring(10);
                                }
                                else if ( line.split(" ")[0].equals("MODEL")){
                                    model = line.substring(6);
                                }
                                else if ( line.split(" ")[0].equals("MANUFACTURER")){
                                    creator = line.substring(13);
                                }
                                else if ( line.split(" ")[0].equals("SALES_NUMBER")){
                                    SaleCode = Integer.parseInt(line.substring(13));
                                }
                                else if (line.split(" ")[0].equals("NAME")){
                                    customer = line.substring(5);
                                }
                                else if (line.split(" ")[0].equals("DATE")){
                                    Date = line.substring(5);
                                }
                                else if (line.split(" ")[0].equals("PHONE")){
                                    phone = Long.parseLong(line.substring(13));
                                }
                                else if(line.equals("}")) {
                                    flag2 = true;
                                }
                                else {
                                    flag2= true;
                                }




                            }while(!flag2);
                            for (Product s : available_items) {
                                if (s.getModelName().equals(model)){
                                    this.sold_items.add(new Sale (s,SaleCode,model,customer,phone,Date));
                                }
                            }





                        }
                    }
                }
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }




        return this.sold_items;
    }
		
	
	

    public void printList() {
        for(Product product : available_items) {
            System.out.println(product);
            System.out.println( ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        }
    }

    public void getSize() {
        System.out.println(this.available_items.size());
    }
	public void printSalesList() {
        for(Sale sale : this.sold_items) {
            System.out.println(sale);
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        }
    }
/*
    public static void main(String[] args) {
        ReadFile2 reader = new ReadFile2();
        reader.readFile("Products.txt");
		reader.readFileOrder("orders.txt");
		reader.readSalesList("sales.txt");
        //reader.printList();
        //reader.getSize();
        reader.printSalesList();

    }


    */
    int salecodemetritis=0;
    int ordercodemetritis=0;
    public int getSaleCode(){
        for ( Sale sale: this.sold_items){
            salecodemetritis +=1;
        }
        return salecodemetritis;

    }

    public int getOrderCode(){
        for (Order order: this.ordered_items){
            ordercodemetritis+= 1;
        }
        return ordercodemetritis;
    }

}
