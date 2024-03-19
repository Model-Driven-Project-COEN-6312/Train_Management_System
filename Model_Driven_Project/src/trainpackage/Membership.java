package trainpackage;
class Membership{
	int membership_id;
	String name,benefits;

	public int check_discount(ArrayList<Pass_booking> pass_book_list,String username){
		int count=0;
		for(int i=0;i<pass_book_list.size();i++){
			if(pass_book_list.get(i).username.equals(username))
			count++;
		}
		if(count<=5){
		return 10;
	}
		else if(count>=6 && count<10){
		return 20;
		
	}
		else {
		return 50;
		}
	}

}
