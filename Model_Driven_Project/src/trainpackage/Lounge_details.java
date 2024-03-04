package trainpackage;
public class Lounge_details {
    public int lounge_id,price;
	int[][] room=new int[4][4];
	public String name;
	public Lounge_details(int lounge_id,int price, String name){
		this.lounge_id=lounge_id;
		this.price=price;
		this.name=name;
		int s=1;
		for(int i=0;i<4;i++){
			for (int j=0;j<4;j++)
			room[i][j]=s++;
		}
	    
	}

	public void display_lounge(){
		System.out.printf("%-5s %-13s %-6s%n", lounge_id,name, price);
	}

	public void display_room(){
		for(int i=0;i<4;i++){
			for (int j=0;j<4;j++)
				System.out.printf("%-3d",room[i][j]);
			System.out.println();
		}
	}

	public void book_lounge(int room_number){
		for(int i=0;i<4;i++){
			for (int j=0;j<4;j++){
				if(room[i][j]==room_number)
				   room[i][j]=0;
			}
		}
	}
	
	public static void room_reverse(int lounge_id, int room_num,Lounge_details lounge_details[]){
		for(int i=0;i<2;i++){
			if(lounge_details[i].lounge_id == lounge_id){
				System.out.println("inside condition");
				int s=0;
				for(int j=0; j<4;j++){
					for(int k=0; k<4;k++){
						s++;
						if(s == room_num){
							lounge_details[i].room[j][k]=s;
							break;
						}
					}
				}
			}
		}
	}
}
