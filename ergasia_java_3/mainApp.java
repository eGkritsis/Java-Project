
// Omada 99
// p3190047 , p3190045 , p3190046 
import java.text.SimpleDateFormat;  
import java.text.DateFormat; 
import java.util.Date; 
import java.util.*;

public class mainApp {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String answer;
        boolean done = false;
		int no =1;
		int salec = 1 ;
		int orderc = 1;
		String answer1;
		String answer5;
		double finalprice ;
		int numberanswer;


        

        ReadFile2 reader = new ReadFile2();
        reader.readFile("Products.txt");
		reader.readFileOrder("orders.txt");
		reader.ReadSales("SalesList.txt");


		salec= reader.getSaleCode() +1;
		orderc= reader.getOrderCode() +1 ;

    

        System.out.println();
        System.out.println("Hi, welcome to our online shop!");
		
		
		

        while (!done) {
            System.out.println("\n1. Overview of available products");
            System.out.println("2. Overview of orders");
            System.out.println("3. Overview of sold products");
            System.out.println("0. Exit");
            System.out.print(">>> ");
			
            answer = in.nextLine();
            if (answer.equals("1")) {

                System.out.println("\n1.Electronics");
                System.out.println("2.Gaming");
                System.out.println("3.Household Appliances ");
                System.out.print(">>> ");
                answer = in.nextLine();
                if (answer.equals("1")) {
                    System.out.println("\n1. Tv");
                    System.out.println("2. DVD / Blue Ray ");
                    System.out.println("3. Camera ");
                    System.out.print(">>> ");
                    answer = in.nextLine();
                    if (answer.equals("1")) {


                        no = 1;


                        for (Product p : reader.available_items) {
                            if (p instanceof Tv) {
                                System.out.println(no + ".  " + p.getModelName());
                            }
                            no = no + 1;
                        }
                        System.out.print(">>>");
                        answer = in.nextLine();

						if (answer.equals("1")||answer.equals("2")) {
                        System.out.println(reader.available_items.get(Integer.parseInt(answer) - 1));
                        finalprice= (1-reader.available_items.get(Integer.parseInt(answer) -1 ).getDiscount()) * reader.available_items.get(Integer.parseInt(answer) -1).getPrice();
                        System.out.println("Final Price: " + finalprice + '$');
                        System.out.println("Would you like to purchase this product?");
                        System.out.println("1. Yes \n2. No ");
                        System.out.print(">>>");
                        answer1 = in.nextLine();
                        if (answer1.equals("1")) {
                            System.out.print("How many items do you want to purchase : ");
                            numberanswer  = in.nextInt();
                            if ( reader.available_items.get(Integer.parseInt(answer) - 1).getAvailableItems() >= numberanswer ) {
                                System.out.print("Name: ");
                                String name = in.next();
                                System.out.print("Phone number: ");
                                long phonenumber = in.nextLong();
                                System.out.print("Date:");
                                String date = in.next();
                                for (int i = 1; i <= numberanswer; i++){
                                    Sale si = new Sale(reader.available_items.get(Integer.parseInt(answer) - 1), salec, reader.available_items.get(Integer.parseInt(answer) - 1).getModelName(), name, phonenumber,date);
                                    reader.sold_items.add(si);
                                    salec = salec + 1;
                                 }
								in.nextLine();
                                System.out.println("Product's finale price is " + finalprice * numberanswer + '$');
                                System.out.println("Thank you for your purchase ");
                            }
                            else if((reader.available_items.get(Integer.parseInt(answer) - 1).getAvailableItems()== 0)){
                                System.out.print( "There are no available items, do you want to order it?");
                                System.out.println("\n1. Yes \n2. No ");
                                System.out.print(">>> ");
                                answer1 = in.next();
                                if(answer1.equals("1")){
                                    System.out.print("Name: ");
                                    String name = in.next();
                                    System.out.print("Phone number: ");
                                    long phonenumber = in.nextLong();
									System.out.print("Date enter day(int) : ");
									int day = in.nextInt();
									System.out.print(" enter month(int) : ");
									int month = in.nextInt();
									System.out.print(" enter year(int) : ");
									int year = in.nextInt();
									String s1=String.valueOf(day);
									String s2=String.valueOf(month);
									String s3=String.valueOf(year);
									String s4=String.valueOf(day+3);
                                    for ( int i = 1; i<= numberanswer ; i++ ) {
                                        Order oi = new Order(reader.available_items.get(Integer.parseInt(answer) - 1), orderc, name, phonenumber,s1+"/"+s2+"/"+s3,s1+"/"+s4+"/"+s3);
                                        reader.ordered_items.add(oi);
                                        orderc = orderc + 1;
                                    }
									in.nextLine();
                                    System.out.println("Product's finale price is " + finalprice * numberanswer + '$');
                                    System.out.println("Thank you for your order ");
                                }
                            }
                            else {
                                System.out.print("Name: ");
                                String name = in.next();
                                System.out.print("Phone number: ");
                                long phonenumber = in.nextLong();
                                System.out.print("Date:");
                                String date = in.next();
                                int metrhths = reader.available_items.get(Integer.parseInt(answer)-1 ).getAvailableItems();
                                for ( int i = 1 ; i<= metrhths ; i++ ) {
                                    Sale si = new Sale(reader.available_items.get(Integer.parseInt(answer) - 1), salec, reader.available_items.get(Integer.parseInt(answer) - 1).getModelName(), name, phonenumber,date);
                                    reader.sold_items.add(si);
                                    salec = salec + 1;
                                }
                                in.nextLine();
                                System.out.println("Product's final price is " + finalprice *  metrhths  + '$');
                                System.out.println("Thank you for your purchase ");
                                System.out.println( "Items out of stock do you want to order the rest ? (" + (numberanswer - metrhths) + " remaining)"   );
                                System.out.println("\n1. Yes \n2. No ");
								System.out.print(">>> ");
                                answer1 = in.next();
								
                                
                                if(answer1.equals("1")) {
									System.out.print("Date enter day(int) : ");
									int day = in.nextInt();
									System.out.print(" enter month(int) : ");
									int month = in.nextInt();
									System.out.print(" enter year(int) : ");
									int year = in.nextInt();
									String s1=String.valueOf(day);
									String s2=String.valueOf(month);
									String s3=String.valueOf(year);
									String s4=String.valueOf(day+3);
                                    for (int i = 1; i <= numberanswer - metrhths; i++) {
                                        Order oi = new Order(reader.available_items.get(Integer.parseInt(answer) - 1), orderc, name, phonenumber,s1+"/"+s2+"/"+s3,s1+"/"+s4+"/"+s3);
                                        reader.ordered_items.add(oi);
                                        orderc = orderc + 1;
                                    }
                                    System.out.println(" Order's final price is : "+ finalprice *(numberanswer - metrhths));
                                }
                                in.nextLine();


                            }
                        }
						}

                    } else if (answer.equals("2")) {
                        ArrayList<Integer> A = new ArrayList <Integer> ();
                        no = 1;
                        int metritis = 0;
                        for (Product p : reader.available_items) {
                            if (p instanceof Blueray_dvd) {
                                System.out.println(no + ".  " + p.getModelName());
                                no = no + 1;
                                A.add(metritis);
                            }
                        metritis=metritis+1;

                        }
                        System.out.print(">>> ");
                        answer = in.nextLine();
						if (answer.equals("1")||answer.equals("2")) {
						 int b= A.get(Integer.parseInt(answer) -1 );
                        System.out.println(reader.available_items.get(b));
                        finalprice= (1-reader.available_items.get(b ).getDiscount()) * reader.available_items.get(b).getPrice();
                        System.out.println("Final Price: " + finalprice + '$');
                        System.out.println("Would you like to purchase this product?");
                        System.out.println("1. Yes \n2. No ");
                        System.out.print(">>>");
                        answer1 = in.nextLine();
                        if (answer1.equals("1")) {
                            System.out.print("How many items do you want to purchase :");
                            numberanswer  = in.nextInt();
                            if ( reader.available_items.get(b ).getAvailableItems() >= numberanswer ) {
                                System.out.print("Name: ");
                                String name = in.next();
                                System.out.print("Phone number: ");
                                long phonenumber = in.nextLong();
                                System.out.print("Date:");
                                String date = in.next();
                                for (int i = 1; i <= numberanswer; i++){
                                    Sale si = new Sale(reader.available_items.get(b), salec, reader.available_items.get(b).getModelName(), name, phonenumber,date);
                                    reader.sold_items.add(si);
                                    salec = salec + 1;
                                }
                                in.nextLine();
                                System.out.println("Product's final price is " + finalprice * numberanswer + '$');
                                System.out.println("Thank you for your purchase ");
                            }
                            else if((reader.available_items.get(b).getAvailableItems()== 0)){
                                System.out.print( "There are no available items, do you want to order it?");
                                System.out.println("\n1. Yes \n2. No ");
                                System.out.print(">>> ");
                                answer1 = in.next();
                                if(answer1.equals("1")){
                                    System.out.print("Name: ");
                                    String name = in.next();
                                    System.out.print("Phone number: ");
                                    long phonenumber = in.nextLong();
									System.out.print("Date enter day(int) : ");
									int day = in.nextInt();
									System.out.print(" enter month(int) : ");
									int month = in.nextInt();
									System.out.print(" enter year(int) : ");
									int year = in.nextInt();
									String s1=String.valueOf(day);
									String s2=String.valueOf(month);
									String s3=String.valueOf(year);
									String s4=String.valueOf(day+3);
                                    for ( int i = 1; i<= numberanswer ; i++ ) {
                                        Order oi = new Order(reader.available_items.get(b), orderc, name, phonenumber,s1+"/"+s2+"/"+s3,s1+"/"+s4+"/"+s3);
                                        reader.ordered_items.add(oi);
                                        orderc = orderc + 1;
                                    }
                                    in.nextLine();
                                    System.out.println("Product's final price is " + finalprice * numberanswer + '$');
                                    System.out.println("Thank you for your order ");
                                }
                            }
                            else {
                                System.out.print("Name: ");
                                String name = in.next();
                                System.out.print("Phone number: ");
                                long phonenumber = in.nextLong();
                                System.out.print("Date:");
                                String date = in.next();
                                int metrhths = reader.available_items.get(b).getAvailableItems();
                                for ( int i = 1 ; i<= metrhths ; i++ ) {
                                    Sale si = new Sale(reader.available_items.get(b), salec, reader.available_items.get(b).getModelName(), name, phonenumber,date);
                                    reader.sold_items.add(si);
                                    salec = salec + 1;
                                }
                                in.nextLine();
                                System.out.println("Product's final price is " + finalprice *  metrhths  + '$');
                                System.out.println("Thank you for your purchase ");
                                System.out.println( "Items out of stock do you want to order the rest ? (" + (numberanswer - metrhths) + " remaining)" );
                                System.out.println("\n1. Yes \n2. No ");
                                System.out.print(">>> ");
                                answer1 = in.next();
								
                                if(answer1.equals("1")) {
									System.out.print("Date enter day(int) : ");
									int day = in.nextInt();
									System.out.print(" enter month(int) : ");
									int month = in.nextInt();
									System.out.print(" enter year(int) : ");
									int year = in.nextInt();
									String s1=String.valueOf(day);
									String s2=String.valueOf(month);
									String s3=String.valueOf(year);
									String s4=String.valueOf(day+3);
                                    for ( int i = 1; i<= numberanswer - metrhths ; i++ ) {
                                        Order oi = new Order(reader.available_items.get(b), orderc, name, phonenumber,s1+"/"+s2+"/"+s3,s1+"/"+s4+"/"+s3);
                                        reader.ordered_items.add(oi);
                                        orderc = orderc + 1;
                                    }
                                    System.out.println(" Order's final price is : "+ finalprice *(numberanswer - metrhths));
                                }
                                in.nextLine();


                            }
                        }
						}
                    } else if (answer.equals("3")) {
                        no = 1;
                        ArrayList<Integer> A = new ArrayList <Integer> ();
                        int metritis =0 ;
                        for (Product p : reader.available_items) {
                            if (p instanceof Camera) {
                                System.out.println(no + ".  " + p.getModelName());
                                no = no + 1;
                                A.add(metritis);
                            }
                            metritis = metritis + 1;

                        }
                        System.out.print(">>> ");
                        answer = in.nextLine();
						if (answer.equals("1")||answer.equals("2")) {
                            int b= A.get(Integer.parseInt(answer) -1 );
                        System.out.println(reader.available_items.get(b));
                        finalprice= (1-reader.available_items.get(b).getDiscount()) * reader.available_items.get(b).getPrice();
                        System.out.println("Final Price: " + finalprice + '$');
                        System.out.println("Would you like to purchase the product?");
                        System.out.println("1. Yes \n2. No ");
                        System.out.print(">>>");
                        answer1 = in.nextLine();
                        if (answer1.equals("1")) {
                            System.out.print("How many items do you want to purchase :");
                            numberanswer  = in.nextInt();
                            if ( reader.available_items.get(b).getAvailableItems() >= numberanswer ) {
                                System.out.print("Name: ");
                                String name = in.next();
                                System.out.print("Phone number: ");
                                System.out.print("Date:");
                                String date = in.next();
                                long phonenumber = in.nextLong();
                                for (int i = 1; i <= numberanswer; i++){
                                    Sale si = new Sale(reader.available_items.get(b), salec, reader.available_items.get(b).getModelName(), name, phonenumber,date);
                                    reader.sold_items.add(si);
                                    salec = salec + 1;
                                }
                                in.nextLine();
                                System.out.println("Product's final price is " + finalprice * numberanswer + '$');
                                System.out.println("Thank you for your purchase ");
                            }
                            else if((reader.available_items.get(b).getAvailableItems()== 0)){
                                System.out.print( "There are no available items, do you want to order it?");
                                System.out.println("\n1. Yes \n2. No ");
                                System.out.print(">>> ");
                                answer1 = in.next();
                                if(answer1.equals("1")){
                                    System.out.print("Name: ");
                                    String name = in.next();
                                    System.out.print("Phone number: ");
                                    long phonenumber = in.nextLong();
									System.out.print("Date enter day(int) : ");
									int day = in.nextInt();
									System.out.print(" enter month(int) : ");
									int month = in.nextInt();
									System.out.print(" enter year(int) : ");
									int year = in.nextInt();
									String s1=String.valueOf(day);
									String s2=String.valueOf(month);
									String s3=String.valueOf(year);
									String s4=String.valueOf(day+3);
                                    for ( int i = 1; i<= numberanswer ; i++ ) {
                                        Order oi = new Order(reader.available_items.get(b), orderc, name, phonenumber,s1+"/"+s2+"/"+s3,s1+"/"+s4+"/"+s3);
                                        reader.ordered_items.add(oi);
                                        orderc = orderc + 1;
                                    }
                                    in.nextLine();
                                    System.out.println("Product's final price is " + finalprice * numberanswer + '$');
                                    System.out.println("Thank you for your order ");
                                }
                            }
                            else {
                                System.out.print("Name: ");
                                String name = in.next();
                                System.out.print("Phone number: ");
                                long phonenumber = in.nextLong();
                                System.out.print("Date:");
                                String date = in.next();
                                int metrhths = reader.available_items.get(b).getAvailableItems();
                                for ( int i = 1 ; i<= metrhths ; i++ ) {
                                    Sale si = new Sale(reader.available_items.get(b), salec, reader.available_items.get(b).getModelName(), name, phonenumber,date);
                                    reader.sold_items.add(si);
                                    salec = salec + 1;
                                }
                                in.nextLine();
                                System.out.println("Product's final price is " + finalprice *  metrhths  + '$');
                                System.out.println("Thank you for your purchase ");
                                System.out.println("Items out of stock do you want to order the rest ? (" + (numberanswer - metrhths) + " remaining)" );
                                System.out.println("\n1. Yes \n2. No ");
                                System.out.print(">>> ");
                                answer1 = in.next();
                                if(answer1.equals("1")) {
									System.out.print("Date enter day(int) : ");
									int day = in.nextInt();
									System.out.print(" enter month(int) : ");
									int month = in.nextInt();
									System.out.print(" enter year(int) : ");
									int year = in.nextInt();
									String s1=String.valueOf(day);
									String s2=String.valueOf(month);
									String s3=String.valueOf(year);
									String s4=String.valueOf(day+3);
                                    for ( int i = 1; i<= numberanswer - metrhths ; i++ ) {
                                        Order oi = new Order(reader.available_items.get(b), orderc, name, phonenumber,s1+"/"+s2+"/"+s3,s1+"/"+s4+"/"+s3);
                                        reader.ordered_items.add(oi);
                                        orderc = orderc + 1;
                                    }
                                    System.out.println(" Order's final price is : "+ finalprice *(numberanswer - metrhths));
                                }
                                in.nextLine();


                            }
                        }
						}
                    }
                }
				    else if (answer.equals("2")) {
                         no = 1;
                         ArrayList < Integer> A = new ArrayList <Integer > ();
                         int metritis= 0;
                        for (Product p : reader.available_items) {
                            if (p instanceof Gaming) {
                                System.out.println(no + ".  " + p.getModelName());
                                no = no + 1;
                                A.add(metritis);
                            }
                            metritis= metritis + 1;
                        }

					    System.out.print(">>> ");
					    answer = in.nextLine();
						if (answer.equals("1")||answer.equals("2")) {
						    int b= A.get(Integer.parseInt(answer) -1 );
                        System.out.println(reader.available_items.get(b));
                        finalprice= (1-reader.available_items.get(b).getDiscount()) * reader.available_items.get(b).getPrice();
                        System.out.println("Final Price: " + finalprice + '$');
                        System.out.println("Would you like to purchase the item?");
                        System.out.println("1. Yes \n2. No ");
                        System.out.print(">>>");
                        answer1 = in.nextLine();
                        if (answer1.equals("1")) {
                            System.out.print("How many items do you want to purchase :");
                            numberanswer  = in.nextInt();
                            if ( reader.available_items.get(b).getAvailableItems() >= numberanswer ) {
                                System.out.print("Name: ");
                                String name = in.next();
                                System.out.print("Phone number: ");
                                long phonenumber = in.nextLong();
                                System.out.print("Date:");
                                String date = in.next();
                                for (int i = 1; i <= numberanswer; i++){
                                    Sale si = new Sale(reader.available_items.get(b), salec, reader.available_items.get(b).getModelName(), name, phonenumber,date);
                                    reader.sold_items.add(si);
                                    salec = salec + 1;
                                }
                                in.nextLine();
                                System.out.println("Product's final price is " + finalprice * numberanswer + '$');
                                System.out.println("Thank you for your purchase ");
                            }
                            else if((reader.available_items.get(b).getAvailableItems()== 0)){
                                System.out.print( "There are no available items, do you want to order it?");
                                System.out.println("\n1. Yes \n2. No ");
                                System.out.print(">>> ");
                                answer1 = in.next();
                                if(answer1.equals("1")){
                                    System.out.print("Name: ");
                                    String name = in.next();
                                    System.out.print("Phone number: ");
                                    long phonenumber = in.nextLong();
									System.out.print("Date enter day(int) : ");
									int day = in.nextInt();
									System.out.print(" enter month(int) : ");
									int month = in.nextInt();
									System.out.print(" enter year(int) : ");
									int year = in.nextInt();
									String s1=String.valueOf(day);
									String s2=String.valueOf(month);
									String s3=String.valueOf(year);
									String s4=String.valueOf(day+3);
                                    for ( int i = 1; i<= numberanswer ; i++ ) {
                                        Order oi = new Order(reader.available_items.get(b), orderc, name, phonenumber,s1+"/"+s2+"/"+s3,s1+"/"+s4+"/"+s3);
                                        reader.ordered_items.add(oi);
                                        orderc = orderc + 1;
                                    }
                                    in.nextLine();
                                    System.out.println("Product's final price is " + finalprice * numberanswer + '$');
                                    System.out.println("Thank you for your order ");
                                }
                            }
                            else {
                                System.out.print("Name: ");
                                String name = in.next();
                                System.out.print("Phone number: ");
                                long phonenumber = in.nextLong();
                                System.out.print("Date:");
                                String date = in.next();
                                int metrhths = reader.available_items.get(b).getAvailableItems();
                                for ( int i = 1 ; i<= metrhths ; i++ ) {
                                    Sale si = new Sale(reader.available_items.get(b), salec, reader.available_items.get(b).getModelName(), name, phonenumber,date);
                                    reader.sold_items.add(si);
                                    salec = salec + 1;
                                }
                                in.nextLine();
                                System.out.println("Product's final price is " + finalprice *  metrhths  + '$');
                                System.out.println("Thank you for your purchase ");
                                System.out.println( "Items out of stock do you want to order the rest ? (" + (numberanswer - metrhths) + " remaining)" );
                                System.out.println("\n1. Yes \n2. No ");
                                System.out.print(">>> ");
                                answer1 = in.next();
                                if(answer1.equals("1")) {
									System.out.print("Date enter day(int) : ");
									int day = in.nextInt();
									System.out.print(" enter month(int) : ");
									int month = in.nextInt();
									System.out.print(" enter year(int) : ");
									int year = in.nextInt();
									String s1=String.valueOf(day);
									String s2=String.valueOf(month);
									String s3=String.valueOf(year);
									String s4=String.valueOf(day+3);
                                    for ( int i = 1; i<= numberanswer - metrhths ; i++ ) {
                                        Order oi = new Order(reader.available_items.get(b), orderc, name, phonenumber,s1+"/"+s2+"/"+s3,s1+"/"+s4+"/"+s3);
                                        reader.ordered_items.add(oi);
                                        orderc = orderc + 1;
                                    }
                                    System.out.println(" Order's final price is : "+ finalprice *(numberanswer - metrhths));
                                }
                                in.nextLine();


                            }
                         }
						}
                    }
				    else if (answer.equals("3")) {
				         System.out.println("\n1. Fridge ");
                         System.out.println("2. WashingMachine ");
                         System.out.print(">>> ");
                    answer = in.nextLine();
                    if (answer.equals("1")) {
                        no = 1;
                        int metritis = 0;
                        ArrayList <Integer> A= new ArrayList<Integer> ();
                        for (Product p : reader.available_items) {
                            if (p instanceof Fridge) {
                                System.out.println(no + ".  " + p.getModelName());
                                no = no + 1;
                                A.add(metritis);
                            }
                            metritis = metritis + 1;


                        }



                        System.out.print(">>> ");
                        answer = in.nextLine();
						if (answer.equals("1")||answer.equals("2")) {
						    int  b = A.get(Integer.parseInt(answer)-1);
                        System.out.println(reader.available_items.get(b));
                        finalprice= (1-reader.available_items.get(b).getDiscount()) * reader.available_items.get(b).getPrice();
                        System.out.println("Final Price: " + finalprice + '$');
                        System.out.println("Would you like to purchase the product?");
                        System.out.println("1. Yes \n2. No ");
                        System.out.print(">>>");
                        answer1 = in.nextLine();
                        if (answer1.equals("1")) {
                            System.out.print("How many items do you want to purchase :");
                            numberanswer  = in.nextInt();
                            if ( reader.available_items.get(b ).getAvailableItems() >= numberanswer ) {
                                System.out.print("Name: ");
                                String name = in.next();
                                System.out.print("Phone number: ");
                                long phonenumber = in.nextLong();
                                System.out.print("Date:");
                                String date = in.next();
                                for (int i = 1; i <= numberanswer; i++){
                                    Sale si = new Sale(reader.available_items.get(b), salec, reader.available_items.get(b).getModelName(), name, phonenumber,date);
                                    reader.sold_items.add(si);
                                    salec = salec + 1;
                                }
                                in.nextLine();
                                System.out.println("Product's final price is " + finalprice * numberanswer + '$');
                                System.out.println("Thank you for your purchase ");
                            }
                            else if((reader.available_items.get(b).getAvailableItems()== 0)){
                                System.out.print( "There are no available items, do you want to order it?");
                                System.out.println("\n1. Yes \n2. No ");
                                System.out.print(">>> ");
                                answer1 = in.next();
                                if(answer1.equals("1")){
                                    System.out.print("Name: ");
                                    String name = in.next();
                                    System.out.print("Phone number: ");
                                    long phonenumber = in.nextLong();
									System.out.print("Date enter day(int) : ");
									int day = in.nextInt();
									System.out.print(" enter month(int) : ");
									int month = in.nextInt();
									System.out.print(" enter year(int) : ");
									int year = in.nextInt();
									String s1=String.valueOf(day);
									String s2=String.valueOf(month);
									String s3=String.valueOf(year);
									String s4=String.valueOf(day+3);
                                    for ( int i = 1; i<= numberanswer ; i++ ) {
                                        Order oi = new Order(reader.available_items.get(b), orderc, name, phonenumber,s1+"/"+s2+"/"+s3,s1+"/"+s4+"/"+s3);
                                        reader.ordered_items.add(oi);
                                        orderc = orderc + 1;
                                    }
                                    in.nextLine();
                                    System.out.println("Product's final price is " + finalprice * numberanswer + '$');
                                    System.out.println("Thank you for your order ");
                                }
                            }
                            else {
                                System.out.print("Name: ");
                                String name = in.next();
                                System.out.print("Phone number: ");
                                long phonenumber = in.nextLong();
                                System.out.print("Date:");
                                String date = in.next();
                                int metrhths = reader.available_items.get(b ).getAvailableItems();
                                for ( int i = 1 ; i<= metrhths ; i++ ) {
                                    Sale si = new Sale(reader.available_items.get(b), salec, reader.available_items.get(b ).getModelName(), name, phonenumber,date);
                                    reader.sold_items.add(si);
                                    salec = salec + 1;
                                }
                                in.nextLine();
                                System.out.println("Product's final price is " + finalprice *  metrhths  + '$');
                                System.out.println("Thank you for your purchase ");
                                System.out.println( "Items out of stock do you want to order the rest ? (" + (numberanswer - metrhths) + " remaining)" );
                                System.out.println("\n1. Yes \n2. No ");
                                System.out.print(">>> ");
                                answer1 = in.next();
                                if(answer1.equals("1")) {
									System.out.print("Date enter day(int) : ");
									int day = in.nextInt();
									System.out.print(" enter month(int) : ");
									int month = in.nextInt();
									System.out.print(" enter year(int) : ");
									int year = in.nextInt();
									String s1=String.valueOf(day);
									String s2=String.valueOf(month);
									String s3=String.valueOf(year);
									String s4=String.valueOf(day+3);
                                    for ( int i = 1; i<= numberanswer - metrhths ; i++ ) {
                                        Order oi = new Order(reader.available_items.get(b), orderc, name, phonenumber,s1+"/"+s2+"/"+s3,s1+"/"+s4+"/"+s3);
                                        reader.ordered_items.add(oi);
                                        orderc = orderc + 1;
                                    }
                                    System.out.println(" Order's final price is : "+ finalprice *(numberanswer - metrhths));
                                }
                                in.nextLine();


                            }
                        }
						}
                    } 
					else if (answer.equals("2")) {
                        no = 1;
                        int metritis = 0;
                        ArrayList<Integer> A= new ArrayList<Integer>();
                        for (Product p : reader.available_items) {
                            if (p instanceof WashingMachine) {
                                System.out.println(no + ".  " + p.getModelName());
                                no = no + 1;
                                A.add(metritis);
                            }
                            metritis= metritis + 1;


                        }



                        System.out.print(">>> ");
                        answer = in.nextLine();
						if (answer.equals("1")||answer.equals("2")) {
						    int b = A.get(Integer.parseInt(answer)-1);
                        System.out.println(reader.available_items.get(b));
                        finalprice= (1-reader.available_items.get(b).getDiscount()) * reader.available_items.get(b).getPrice();
                        System.out.println("Final Price: " + finalprice + '$');
                        System.out.println("Would you like to purchase the product?");
                        System.out.println("1. Yes \n2. No ");
                        System.out.print(">>>");
                        answer1 = in.nextLine();
                        if (answer1.equals("1")) {
                            System.out.print("How many items do you want to purchase :");
                            numberanswer  = in.nextInt();
                            if ( reader.available_items.get(b ).getAvailableItems() >= numberanswer ) {
                                System.out.print("Name: ");
                                String name = in.next();
                                System.out.print("Phone number: ");
                                System.out.print("Date:");
                                String date = in.next();
                                long phonenumber = in.nextLong();
                                for (int i = 1; i <= numberanswer; i++){
                                    Sale si = new Sale(reader.available_items.get(b), salec, reader.available_items.get(b).getModelName(), name, phonenumber,date);
                                    reader.sold_items.add(si);
                                    salec = salec + 1;
                                }
                                in.nextLine();
                                System.out.println("Product's final price is " + finalprice * numberanswer + '$');
                                System.out.println("Thank you for your purchase ");
                            }
                            else if((reader.available_items.get(b).getAvailableItems()== 0)){
                                System.out.print( "There are no available items, do you want to order it?");
                                System.out.println("\n1. Yes \n2. No ");
                                System.out.print(">>> ");
                                answer1 = in.next();
                                if(answer1.equals("1")){
                                    System.out.print("Name: ");
                                    String name = in.next();
                                    System.out.print("Phone number: ");
                                    long phonenumber = in.nextLong();
									System.out.print("Date enter day(int) : ");
									int day = in.nextInt();
									System.out.print(" enter month(int) : ");
									int month = in.nextInt();
									System.out.print(" enter year(int) : ");
									int year = in.nextInt();
									String s1=String.valueOf(day);
									String s2=String.valueOf(month);
									String s3=String.valueOf(year);
									String s4=String.valueOf(day+3);
                                    for ( int i = 1; i<= numberanswer ; i++ ) {
                                        Order oi = new Order(reader.available_items.get(b), orderc, name, phonenumber,s1+"/"+s2+"/"+s3,s1+"/"+s4+"/"+s3);
                                        reader.ordered_items.add(oi);
                                        orderc = orderc + 1;
                                    }
                                    in.nextLine();
                                    System.out.println("Product's final price is " + finalprice * numberanswer + '$');
                                    System.out.println("Thank you for your order ");
                                }
                            }
                            else {
                                System.out.print("Name: ");
                                String name = in.next();
                                System.out.print("Phone number: ");
                                long phonenumber = in.nextLong();
                                System.out.print("Date:");
                                String date = in.next();
                                int metrhths = reader.available_items.get(b).getAvailableItems();
                                for ( int i = 1 ; i<= metrhths ; i++ ) {
                                    Sale si = new Sale(reader.available_items.get(b), salec, reader.available_items.get(b).getModelName(), name, phonenumber,date);
                                    reader.sold_items.add(si);
                                    salec = salec + 1;
                                }
                                in.nextLine();
                                System.out.println("Product's final price is " + finalprice *  metrhths  + '$');
                                System.out.println("Thank you for your purchase ");
                                System.out.println( "Items out of stock do you want to order the rest ? (" + (numberanswer - metrhths) + " remaining)" );
                                System.out.println("\n1. Yes \n2. No ");
                                System.out.print(">>> ");
                                answer1 = in.next();
                                if(answer1.equals("1")) {
									System.out.print("Date enter day(int) : ");
									int day = in.nextInt();
									System.out.print(" enter month(int) : ");
									int month = in.nextInt();
									System.out.print(" enter year(int) : ");
									int year = in.nextInt();
									String s1=String.valueOf(day);
									String s2=String.valueOf(month);
									String s3=String.valueOf(year);
									String s4=String.valueOf(day+3);
                                    for ( int i = 1; i<= numberanswer - metrhths ; i++ ) {
                                        Order oi = new Order(reader.available_items.get(b), orderc, name, phonenumber,s1+"/"+s2+"/"+s3,s1+"/"+s4+"/"+s3);
                                        reader.ordered_items.add(oi);
                                        orderc = orderc + 1;
                                    }
                                    System.out.println(" Order's final price is : "+ finalprice *(numberanswer - metrhths));
                                }
                                in.nextLine();


                            }
                        }
						}
                    }
                }
			}
			else if (answer.equals("2")) {
			    int par=1;
                    for (Order o : reader.ordered_items) {
                        System.out.println(par + " . " + o.getOrderModel());
                        par = par + 1;
                    }
                    if(reader.ordered_items.isEmpty()) {
                        System.out.println("No orders at the moment!!!");
                    } else {
                        System.out.println("Choose an order to inspect");
                        System.out.print(">>> ");
                        int answer2 = in.nextInt();
						in.nextLine();
                        System.out.println(reader.ordered_items.get(answer2 - 1));
                        System.out.println("Did the item arrive?");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        System.out.print(">>>");
                        
                        answer5 = in.nextLine();

                        if (answer5.equals("1")) {
                            reader.ordered_items.get(answer2 - 1).getProductOfOrder().setAvailableItemsToOne();
                            Sale s1 = new Sale(reader.ordered_items.get(answer2 - 1).getProductOfOrder(), salec, reader.ordered_items.get(answer2 - 1).getOrderModel(), reader.ordered_items.get(answer2 - 1).getOrderName(), reader.ordered_items.get(answer2 - 1).getOrderphone(),reader.ordered_items.get(answer2 - 1).getOrderArriveDate());
                            salec = salec + 1;
                            reader.ordered_items.remove(reader.ordered_items.get(answer2 - 1));
                            reader.sold_items.add(s1);
                        } else if (answer5.equals("2")) {
                            System.out.println("Expected arrival date:");
                            reader.ordered_items.get(answer2 - 1).getOrderArrivalDate();
                        }

                    }

            }
			else if (answer.equals("3")) {
			    if (!reader.sold_items.isEmpty()) {
                    for (Sale s : reader.sold_items) {
                        System.out.println(s);
						System.out.println("------------");
                    }
                } else {
                    System.out.println("There are no sold products at the moment!!!");
                }
            } 
			else if (answer.equals("0")) {
				done = true;
				CreateFilesApp app = new CreateFilesApp ();
				app.CreateSalesFile(reader.sold_items);
				app.CreateOrdersFile(reader.ordered_items);
				
			}
            

        }
        in.close();
    }
}



