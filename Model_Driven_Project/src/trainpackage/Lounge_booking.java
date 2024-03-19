package trainpackage;
import java.util.ArrayList;

class Lounge_booking{
	int lounge_id,room_no,price;
	String name,user_name;
	public Lounge_booking(String user_name,int lounge_id,String name, int room_no, int price){
		this.user_name=user_name;
		this.lounge_id=lounge_id;
		this.room_no=room_no;
		this.name=name;
		this.price=price;
	}
	public void display_booking(){
		System.out.printf("%-13s %-5s %-13s %-10d %-6s%n",user_name, lounge_id,name,room_no, price);
	}
	public static void cancel_lounge_booking(int lounge_id,int room_no,ArrayList<Lounge_booking> lounge_book_list,Lounge_details lounge_details[]){
		for (int i=0;i<lounge_book_list.size();i++){
			if(lounge_book_list.get(i).lounge_id== lounge_id && lounge_book_list.get(i).room_no==room_no){
				lounge_book_list.remove(i);
				Lounge_details.room_reverse(lounge_id, room_no,lounge_details);
			}
		}
	}
}
