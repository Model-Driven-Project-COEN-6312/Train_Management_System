package trainpackage;
import java.util.ArrayList;
import java.util.Scanner;


public class Train_Management {
	public static void main(String args[]) {
		
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
		ArrayList<Passenger_details> pass_details = new ArrayList<>();
	

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
				System.out.print("Enter your age: ");
				int age=sc.nextInt();
				pass_details.add(new Passenger_details(username,password,age));
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
												   11. check my discount
												   12. Check meal discount
												   13. Check allowed baggage
												   14. Edit Profile
												   15. Logout""");
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
					int flag3=0,seat_no=17,train_no_book=0,flag4=1,flag_train=1;
					while(flag3==0){
						
						System.out.println("Please select the train");
						while(flag_train == 1){
						System.out.print("Enter the train from the list(1,2,3,4):");
						train_no_book=sc.nextInt();
						if(train_no_book>4 || train_no_book<1)
						{
							System.out.println("PLease enter valid train number");
						}
						else flag_train=0;
						}
						if(pass_trains[train_no_book-1].availableseats<2)
						System.out.println("The train is full, please select other train");
						if(train_no_book<=4)
						flag3=1;
						else
						System.out.println("Enter the valid number");
					}
						pass_trains[train_no_book-1].display_seat();
						while(seat_no>16 || flag4==1){
						System.out.print("Enter the seat no:");
						seat_no=sc.nextInt();
				
						
						if(seat_no>16)
						System.out.println("The entered seat number is not valid");
						if(flag4==0)
						System.out.println("The entered seat is already booked");
						if(seat_no<16 || flag4!=0){
						flag4=pass_trains[train_no_book-1].book(seat_no);

						pass_book_list.add(new Pass_booking(pass_trains[train_no_book-1].train_no,pass_trains[train_no_book-1].from,pass_trains[train_no_book-1].to,pass_trains[train_no_book-1].date,pass_trains[train_no_book-1].start_time,seat_no,username,null));
						
					}
						}
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
					int flag2=0;
					String meal_type="";
						System.out.printf("%-15s %-60s %-60s %-6s%n", "Name","Menu", "Ingredients", "Price");
						for(int i=0;i<2;i++){
							meal_list[i].display("pass");
						}
						
						while(flag2==0){
						System.out.print("Please enter your meal type : ");
						int meal_choice = sc.nextInt();
						if(meal_choice<2)
						{
						meal_type = meal_list[meal_choice-1].name;
						flag2=1;
						}
						else
						System.out.println("Select only from the list");
					}
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
                    	int flag1=0,rating=0,train_no_flag=0,train_no=0;
						while(train_no_flag==0){
						System.out.print("Enter your train_no:");
						train_no= sc.nextInt();
						for(int i=0;i<pass_book_list.size();i++)
						if(pass_book_list.get(i).username.equals(username) && pass_book_list.get(i).train_no==train_no)
						train_no_flag=1;
						if(train_no_flag==0)
						System.out.println("you can only prodvide feedbacks for the train you have booked");
						}
						while(flag1==0){
                        System.out.print("Enter your ratings:");
						rating=sc.nextInt();
						if(rating>=1 && rating<=5)
						flag1=1;
						else
						System.out.println("Enter ratings between 1 and 5");
						}
						System.out.print("Enter your Category of your feedback:");
						String category=sc.next();
						System.out.print("Enter your description of your feedback:");
						String description=sc.next();
						Feedback_list.add(new Feedback(username,train_no,rating,category,description));
						System.out.printf("%-13s %-6s %-9s %-15s %-20s%n", "User name", "Train no","Ratings","Category","Description");
						Feedback_list.get(0).display_feedback();
						break;
					case 11:
						Membership member= new Membership();
						System.out.printf("Your benifit on travel is %d%%",member.check_discount(pass_book_list,username));
						break;
					case 12:
						Membership member1= new Membership();
						System.out.printf("Your discount on meal is %d%%",member1.check_discount(pass_book_list,username)/2);
						break;
					case 13:
						if(age<18)
						System.out.println("You ca carry 2 luggages");
						else if(age>18 && age<=60)
						System.out.println("You ca carry 3 luggages");
						else
						System.out.println("You ca carry 4 luggages");
					break;
					case 14:
					    String newUsername="";
						System.out.println("Have a look at your profile details");
						Passenger_details.display_profile(pass_details,username);
						System.out.println("Please enter new values, if no chnages required enter ,");
						for( int i = 0; i < pass_details.size(); i++){
							if(pass_details.get(i).username.equals(username)){
								System.out.println("Enter New Username: ");
								newUsername = sc.next();
								System.out.println("Enter New Password: ");
								String newPassword = sc.next();
								System.out.println("Enter New First_Name: ");
								String newFirstname = sc.next();
								System.out.println("Enter New Last_Name: ");
								String newLastname = sc.next();
								System.out.println("Enter New Age 0 if no change: ");
								int newAge = sc.nextInt();
								System.out.println("Enter New Address: ");
								String newAddress = sc.next();
								pass_details.get(i).edit_profile(newUsername, newPassword, newFirstname, newLastname, newAge, newAddress);
							}
						}
						System.out.println("Have a look at your new profile details");
						if(newUsername.equals(username))
						Passenger_details.display_profile(pass_details,username);
						else
						Passenger_details.display_profile(pass_details,newUsername);
					break;
					case 15: 
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
						int flag1=0;
							System.out.println("Please select your train");
							System.out.print("Enter the train from the list(1,2,3,4):");
							int train_no_book=sc.nextInt();
							cargo_trains[train_no_book-1].display_cabin();
							System.out.print("Enter the cabin no:");
							int cabin_no=sc.nextInt();
							cargo_trains[train_no_book-1].book(cabin_no);
							System.out.print("Enter the business type:");
							String business_type=sc.next();
							while (flag1==0) {
								System.out.print("Enter the weight of your package:");
								Float weight= sc.nextFloat();
								if(business_type.equals("construction") && weight>=30 && weight<=40){
								cargo_book_list.add(new Cargo_booking(cargo_trains[train_no_book-1].train_no,cargo_trains[train_no_book-1].from,cargo_trains[train_no_book-1].to,cargo_trains[train_no_book-1].date,cargo_trains[train_no_book-1].start_time,cabin_no,b_username, weight));
								flag1=1;
							}
								else if(business_type.equals("textile") && weight>=15 && weight<=20){
								cargo_book_list.add(new Cargo_booking(cargo_trains[train_no_book-1].train_no,cargo_trains[train_no_book-1].from,cargo_trains[train_no_book-1].to,cargo_trains[train_no_book-1].date,cargo_trains[train_no_book-1].start_time,cabin_no,b_username, weight));
								flag1=1;
								}
								else if (weight>=5 && weight<=10){
								cargo_book_list.add(new Cargo_booking(cargo_trains[train_no_book-1].train_no,cargo_trains[train_no_book-1].from,cargo_trains[train_no_book-1].to,cargo_trains[train_no_book-1].date,cargo_trains[train_no_book-1].start_time,cabin_no,b_username, weight));
								flag1=1;
							}
							else
							System.out.println("Enter the valid weight");
						}
							
							
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

					
			}break;
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
