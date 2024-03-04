package trainpackage;
import java.util.ArrayList;

public class Cargo_booking extends Booking{
    int coach_no;
	public String username;
	float weight;

	public Cargo_booking(int train_no,String from, String to, String date,String time,int coach_no,String username,float weight){
		super(train_no,from, to,date,time);
		this.coach_no=coach_no;
		this.username=username;
		this.weight=weight;
	}
	public void display_booking(){
		System.out.printf("%-10s %-9d %-8s %-13s %-10s %-6s %-13d %-13s%n", username,train_no, from, to, date, time, coach_no,weight);
	}
	public static void cancel_booking(int train_no,int cabin_no,ArrayList<Cargo_booking> cargo_book_list,Cargo_train_cabin_details cargo_trains[]){
		for (int i=0;i<cargo_book_list.size();i++){
			if(cargo_book_list.get(i).train_no== train_no && cargo_book_list.get(i).coach_no==cabin_no){
				cargo_book_list.remove(i);
				Cargo_train_cabin_details.seat_reverse(train_no, cabin_no,cargo_trains);
			}
		}
	}
}
