package trainpackage;
import java.util.ArrayList;

public class Pass_booking extends Booking{
    public int seat_no;
	public String username,meal_type;
	public Pass_booking(int train_no,String from, String to, String date,String time,int seat_no,String username,String meal_type){
		super(train_no,from, to,date,time);
		this.seat_no=seat_no;
		this.username=username;
		this.meal_type=meal_type;
	}
	public void display_booking(){
		System.out.printf("%-10s %-9d %-8s %-13s %-10s %-6s %-13d %-13s%n", username,train_no, from, to, date, time, seat_no,meal_type);
	}
	public static void cancel_booking(int train_no,int seat_no,ArrayList<Pass_booking> pass_book_list,Pass_train_seat_details pass_trains[]){
		for (int i=0;i<pass_book_list.size();i++){
			if(pass_book_list.get(i).train_no== train_no && pass_book_list.get(i).seat_no==seat_no){
				pass_book_list.remove(i);
				Pass_train_seat_details.seat_reverse(train_no, seat_no,pass_trains);
			}
		}
	}
	public static void meal_selection(int train_no,int seat_no,String meal_type,ArrayList<Pass_booking> pass_book_list){
		for (int i=0;i<pass_book_list.size();i++){
			if(pass_book_list.get(i).train_no== train_no && pass_book_list.get(i).seat_no==seat_no){
				pass_book_list.get(i).meal_type= meal_type;
			}
		}
	}
}
