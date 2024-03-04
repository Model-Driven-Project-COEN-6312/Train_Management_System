package trainpackage;
public class Cargo_train_cabin_details extends Train_details{
    int[][] cabin_no=new int[4][4];
	public Cargo_train_cabin_details(int train_no,String from,String to,String date,String start_time,String stop_time){
		super(train_no,from,to,date,start_time,stop_time);
		int s=1;
		for(int i=0;i<4;i++){
			for (int j=0;j<4;j++)
			cabin_no[i][j]=s++;
		}
		}
	public void display_cabin(){
		for(int i=0;i<4;i++){
			for (int j=0;j<4;j++)
				System.out.printf("%-3d",cabin_no[i][j]);
			System.out.println();
			   

		}
	}
	public void book(int cabin_number){
		for(int i=0;i<4;i++){
			for (int j=0;j<4;j++){
				if(cabin_no[i][j]==cabin_number)
				   cabin_no[i][j]=0;
			}
		}
	}
	public static void seat_reverse(int train_no, int cabin_num,Cargo_train_cabin_details cabin_trains[]){
		for(int i=0;i<4;i++){
			if(cabin_trains[i].train_no == train_no){
				int s=0;
				for(int j=0; j<4;j++){
					for(int k=0; k<4;k++){
						s++;
						if(s == cabin_num){
							cabin_trains[i].cabin_no[j][k]=s;
							break;
						}
					}
				}
			}
		}
	}
}
