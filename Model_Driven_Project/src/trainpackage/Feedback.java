package trainpackage;
public class Feedback {
    int train_no,rating; 
	String user_name,category,description;
	public Feedback(String username,int train_no,int rating,String category,String description){
		this.train_no=train_no;
		this.user_name=username;
		this.rating=rating;
		this.description=description;
		this.category=category;
	}
	public void display_feedback(){
		System.out.printf("%-13s %-6d %-9d %-15s %-20s%n",user_name,train_no,rating,category,description);
	}
}
