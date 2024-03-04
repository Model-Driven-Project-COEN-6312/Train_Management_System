package trainpackage;
public class Booking {
    public int train_no;
	public String from,to,date,time;
	public Booking(int train_no,String from, String to, String date,String time)
	{
		this.train_no=train_no;
		this.from=from;
		this.to=to;
		this.date=date;
		this.time=time;
	}
}
