package trainpackage;
public class Meal {
    public String name,ingredients,menu;
	float price;
	public int id;
	public Meal(int id,String name, String ingredients, String menu, float price){
		this.name=name;
		this.id=id;
		this.ingredients=ingredients;
		this.menu=menu;
		this.price=price;
	}
	public void display(String user){
		if(user.equals("pass"))
		System.out.printf("%-15s %-60s %-60s %-6f%n", name,menu,ingredients,price);
		else
		System.out.printf("%-4d %-15s %-60s %-60s %-6f%n", id,name,menu,ingredients,price);
		}
	public void update(String menu){
		this.menu=menu;
	}
}
