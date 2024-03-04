package trainpackage;
public class Train_details {
    public String from,to,date,start_time,stop_time;
	public int train_no; 
	public Train_details(int train_no,String from,String to,String date,String start_time,String stop_time){
		this.train_no=train_no;
		this.from=from;
		this.to=to;
		this.date=date;
		this.start_time=start_time;
		this.stop_time=stop_time;
	}
	public void display(){
		System.out.printf("%-9d %-10s %-12s %-13s %-11s %-10s%n", train_no, this.from, this.to, this.date, this.start_time, this.stop_time);

	}
}
