package trainpackage;
public class Pass_train_seat_details extends Train_details{
    int[][] seat_no= new int[4][4];
	public Pass_train_seat_details(int train_no,String from,String to,String date,String start_time,String stop_time){
		super(train_no,from,to,date,start_time,stop_time);
		int s=1;
		for(int i=0;i<4;i++){
			for (int j=0;j<4;j++)
			seat_no[i][j]=s++;
		}

	}
	public void display_seat(){
		for(int i=0;i<4;i++){
			for (int j=0;j<4;j++)
				System.out.printf("%-3d",seat_no[i][j]);
			System.out.println();
		}
	}
	public void book(int seat_number){
		for(int i=0;i<4;i++){
			for (int j=0;j<4;j++){
				if(seat_no[i][j]==seat_number)
				   seat_no[i][j]=0;
			}
		}
	}
	public static void seat_reverse(int train_no, int seat_num,Pass_train_seat_details pass_trains[]){
		for(int i=0;i<4;i++){
			if(pass_trains[i].train_no == train_no){
				int s=0;
				for(int j=0; j<4;j++){
					for(int k=0; k<4;k++){
						s++;
						if(s == seat_num){
							pass_trains[i].seat_no[j][k]=s;
							break;
						}
					}
				}
			}
		}
	}
}
