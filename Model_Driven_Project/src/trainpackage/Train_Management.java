package trainpackage;
import java.util.ArrayList;
import java.util.Scanner;


public class Train_Management {
    public static void main(String[] args) throws Exception {
		Pass_train_seat_details pass_trains[]= new Pass_train_seat_details[4];
		pass_trains[0]=new Pass_train_seat_details(1001, "Chennai", "Delhi","02-03-2024","02:05","19:45");
		pass_trains[1]=new Pass_train_seat_details(1002, "Mumbai", "Kolkata","07-03-2024","12:10","18:30");
		pass_trains[2]=new Pass_train_seat_details(1003, "Kochin", "Bangalore","10-03-2024","11:25","01:15");
		pass_trains[3]=new Pass_train_seat_details(1004, "Pune", "Noida","01-04-2024","14:26","22:06");

		Cargo_train_cabin_details cargo_trains[]= new Cargo_train_cabin_details[4];
		cargo_trains[0]=new Cargo_train_cabin_details(1001, "Chennai", "Delhi","02-03-2024","02:05","19:45");
		cargo_trains[1]=new Cargo_train_cabin_details(1002, "Mumbai", "Kolkata","07-03-2024","12:10","18:30");
		cargo_trains[2]=new Cargo_train_cabin_details(1003, "Kochin", "Bangalore","10-03-2024","11:25","01:15");
		cargo_trains[3]=new Cargo_train_cabin_details(1004, "Pune", "Noida","01-04-2024","14:26","22:06");

		Meal meal_list[] = new Meal[2];
		meal_list[0] = new Meal(1001,"Vegetarian","Potato,rice,curd,dal,paneer","Potato curry, Paneer Butter Masala, Curd Rice",20);
		meal_list[1] = new Meal(1002,"Non Vegetarian","Mushroom,rice,chicken,Fish,Bread","Fish curry, Butter Chciken, Mushroom Rice,Bread",30);

		Lounge_details lounge_details[]= new Lounge_details[2];
		lounge_details[0]=new Lounge_details(1001, 100, "MontrealInn");
		lounge_details[1]=new Lounge_details(1002, 50, "TorontoInn");

		ArrayList<Pass_booking> pass_book_list = new ArrayList<>();
		ArrayList<Cargo_booking> cargo_book_list= new ArrayList<>();
		ArrayList<Lounge_booking> lounge_book_list = new ArrayList<>();
		ArrayList<Feedback> Feedback_list = new ArrayList<>();

	    int choice=1;	
		Scanner sc= new Scanner(System.in);
		
		while(choice!=0){
		System.out.print("\n\n");
		System.out.println("\t\tWelcome to Train Managemnet System");
		System.out.println("1. Passenger login\n2. Business User login\n3.Crew Member login\n4.Station Master login\n5.Maintanance staff login");
		System.out.print("Enter your choice");
		choice=sc.nextInt();
		int flag=1;
		switch(choice){
			case 1:
                System.out.println("Welcome Passenger ");
                System.out.print("Please enter your username : ");
				String username= sc.next();
				System.out.print("Please enter your password : ");
				String password= sc.next();
			while(flag==1){
				System.out.println("""
                                                   1. Search trains
                                                   2. Book trains
                                                   3. Cancel ticket
                                                   4. Select meal
                                                   5. View booking
                                                   6. Search lounge
                                                   7. Book lounge
												   \t\t\t\t    8. Cancel lounge
												   \t\t\t\t    9. Check membership
                                                   10. Provide feedback
												   11. Logout""");
				System.out.print("Enter your choice");
				int ch=sc.nextInt();
				switch(ch){
					case 1:
						System.out.println("Available Trains");
						System.out.printf("%-9s %-10s %-12s %-13s %-11s %-10s%n", "Train no", "From", "Destination", "Date", "Start time", "Stop time");
							for(int i=0; i<4; i++){
							pass_trains[i].display();
							}
						break;

					case 2:
						System.out.println("Please select your train");
						System.out.print("Enter the train no:");
						int train_no_book=sc.nextInt();
						pass_trains[train_no_book-1].display_seat();
						System.out.print("Enter the seat no:");
						int seat_no=sc.nextInt();
						pass_trains[train_no_book-1].book(seat_no);
						pass_book_list.add(new Pass_booking(pass_trains[train_no_book-1].train_no,pass_trains[train_no_book-1].from,pass_trains[train_no_book-1].to,pass_trains[train_no_book-1].date,pass_trains[train_no_book-1].start_time,seat_no,username,null));
						break;
					case 3:
						System.out.printf("%-10s %-9s %-8s %-13s %-10s %-6s %-13s %-13s%n", "User name","Train No", "From", "Destination", "Date", "Time", "Seat Number","Meal type");
						for(int i=0;i<pass_book_list.size();i++){
							if(pass_book_list.get(i).username.equals(username))
								pass_book_list.get(i).display_booking();

						}
						System.out.print("Enter the train no:");
						int cancel_train_no=sc.nextInt();
						System.out.print("Enter Seat no:");
						int cancel_seat_no=sc.nextInt();
					    Pass_booking.cancel_booking(cancel_train_no,cancel_seat_no,pass_book_list,pass_trains);
						break;
					case 4:
						System.out.printf("%-15s %-60s %-60s %-6s%n", "Name","Menu", "Ingredients", "Price");
						for(int i=0;i<2;i++){
							meal_list[i].display("pass");
						}
						System.out.print("Please enter your meal type : ");
						int meal_choice = sc.nextInt();
						String meal_type = meal_list[meal_choice-1].name;

						for(int i=0;i<pass_book_list.size();i++){
							if(pass_book_list.get(i).username.equals(username))
								pass_book_list.get(i).display_booking();

						}
						System.out.print("Enter the train no:");
						int meal_train_no=sc.nextInt();
						System.out.print("Enter Seat no:");
						int meal_seat_no=sc.nextInt();
						Pass_booking.meal_selection(meal_train_no,meal_seat_no,meal_type,pass_book_list);
						break;
					case 5:
						System.out.printf("%-10s %-9s %-8s %-13s %-10s %-6s %-13s %-13s%n", "User name","Train No", "From", "Destination", "Date", "Time", "Seat Number","Meal type");
						for(int i=0;i<pass_book_list.size();i++){
							if(pass_book_list.get(i).username.equals(username)){
								pass_book_list.get(i).display_booking();
							}
						}
						break;
					case 6:
						System.out.println("Available Lounges");
						System.out.printf("%-5s %-13s %-6s%n", "id","Name", "Price");
						for(int i=0; i<2; i++){
						   lounge_details[i].display_lounge();
						}
						break;
					case 7:
						System.out.println("Please select your lounge");
						System.out.print("select the lounge from above:");
						int lounge_no=sc.nextInt();
						lounge_details[lounge_no-1].display_room();
						System.out.print("Enter the room no:");
						int room_no=sc.nextInt();
						lounge_details[lounge_no-1].book_lounge(room_no);
						lounge_book_list.add(new Lounge_booking(username,lounge_details[lounge_no-1].lounge_id,lounge_details[lounge_no-1].name,room_no,lounge_details[lounge_no-1].price));
						break;
					case 8:
						System.out.printf("%-13s %-5s %-13s %-10s %-6s%n", "User Name","id","Lounge Name","Room Num","Price");
						for(int i=0;i<lounge_book_list.size();i++){
							if(lounge_book_list.get(i).user_name.equals(username))
								lounge_book_list.get(i).display_booking();

						}
						System.out.print("Enter the Lounge id:");
						int cancel_lounge_no=sc.nextInt();
						System.out.print("Enter room no:");
						int cancel_room_no=sc.nextInt();
						Lounge_booking.cancel_lounge_booking(cancel_lounge_no,cancel_room_no,lounge_book_list,lounge_details);
						break;
					case 10:
						System.out.print("Enter your train_no:");
						int train_no= sc.nextInt();
						System.out.print("Enter your ratings:");
						int rating=sc.nextInt();
						System.out.print("Enter your Category of your feedback:");
						String category=sc.next();
						System.out.print("Enter your description of your feedback:");
						String description=sc.next();
						Feedback_list.add(new Feedback(username,train_no,rating,category,description));
						System.out.printf("%-13s %-6s %-9s %-15s %-20s%n", "User name", "Train no","Ratings","Category","Description");
						Feedback_list.get(0).display_feedback();
						break;
					case 11: 
				    flag=0;
					break;	     
				}						
			}
			break;
			case 2:
				System.out.println("Welcome Business user ");
                System.out.print("Please enter your username : ");
				String b_username= sc.next();
				System.out.print("Please enter your password : ");
				String b_password= sc.next();
				while(flag==1){
				
					System.out.println("""
													1. Search trains
													2. Book trains
													3. Cancel ticket
													4.View bookings
													5.Provide Feedback
													6.Logout""");
					System.out.print("Enter your choice");
					int ch=sc.nextInt();
					switch(ch){
						case 1:
							System.out.println("Available Cargo Trains");
							System.out.printf("%-9s %-10s %-12s %-13s %-11s %-10s%n", "Train no", "From", "Destination", "Date", "Start time", "Stop time");
								for(int i=0; i<4; i++)
								cargo_trains[i].display();
							break;
						case 2:
							System.out.println("Please select your train");
							System.out.print("Enter the train no:");
							int train_no_book=sc.nextInt();
							cargo_trains[train_no_book-1].display_cabin();
							System.out.print("Enter the cabin no:");
							int cabin_no=sc.nextInt();
							cargo_trains[train_no_book-1].book(cabin_no);
							System.out.print("Enter the weight of your package:");
							Float weight= sc.nextFloat();
							cargo_book_list.add(new Cargo_booking(cargo_trains[train_no_book-1].train_no,cargo_trains[train_no_book-1].from,cargo_trains[train_no_book-1].to,cargo_trains[train_no_book-1].date,cargo_trains[train_no_book-1].start_time,cabin_no,b_username, weight));
							break;
						case 3:
							System.out.printf("%-10s %-9s %-8s %-13s %-10s %-6s %-13s %-13s%n", "User name","Train No", "From", "Destination", "Date", "Time", "Cabin Number","Meal type");
							for(int i=0;i<cargo_book_list.size();i++){
								if(cargo_book_list.get(i).username.equals(b_username))
									cargo_book_list.get(i).display_booking();

							}
							System.out.print("Enter the train no:");
							int cancel_train_no=sc.nextInt();
							System.out.print("Enter cabin no:");
							int cancel_cabin_no=sc.nextInt();
							Cargo_booking.cancel_booking(cancel_train_no,cancel_cabin_no,cargo_book_list,cargo_trains);
							break;
						case 4:
							System.out.printf("%-10s %-9s %-8s %-13s %-10s %-6s %-13s %-13s%n", "User name","Train No", "From", "Destination", "Date", "Time", "Cabin Number","Weight");
							for(int i=0;i<cargo_book_list.size();i++){
								if(cargo_book_list.get(i).username.equals(b_username)){
									cargo_book_list.get(i).display_booking();
								}
							}
							break;	
						case 5:
							System.out.print("Enter your train_no:");
							int train_no= sc.nextInt();
							System.out.print("Enter your ratings:");
							int rating=sc.nextInt();
							System.out.print("Enter your Category of your feedback:");
							String category=sc.next();
							System.out.print("Enter your description of your feedback:");
							String description=sc.next();
							Feedback_list.add(new Feedback(b_username,train_no,rating,category,description));
							System.out.printf("%-13s %-6s %-9s %-15s %-20s%n", "User name", "Train no","Ratings","Category","Description");
							Feedback_list.get(0).display_feedback();
							break;
						case 6: 
						flag=0;
						break;										
					}
					
			}
			case 4:
					System.out.println("Welcome Station Master ");
					System.out.print("Please enter your username : ");
					String m_username= sc.next();
					System.out.print("Please enter your password : ");
					String m_password= sc.next();
					while(flag==1){
					
						System.out.println("""
														1. Update Meal
														2. Manage lounge
														3. Generate time report
														4.Logout""");
						System.out.print("Enter your choice");
						int ch=sc.nextInt();
					switch(ch){
						case 1:
						System.out.printf("%-4s %-15s %-60s %-60s %-6s%n", "id","name","menu","ingredients","price");
							for(int i=0;i<2;i++)
								meal_list[i].display("master");
							System.out.print("Enter the meal id you want to update:");
							int id= sc.nextInt();
							sc.nextLine();
							System.out.print("Enter the new menu:");
							String menu=sc.nextLine();
							for(int i=0;i<2;i++){
								if(meal_list[i].id==id){
								meal_list[i].update(menu);
								break;
							    }
							}
							break;
						case 4:
						   flag=0;
						   break;
					}


		}
	}
}
	sc.close();
    }
}
