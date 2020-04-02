import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;

public final class BottleDispenser {

    private int bottles;
    
    private static final BottleDispenser INSTANCE = new BottleDispenser();

    // The array for the Bottle-objects

    private ArrayList<Bottle> bottle_list;

    public double money;

    int x;
    
    public static BottleDispenser getInstance() {
    	return INSTANCE;
    }
    

    private BottleDispenser() {

        bottles = 2;

        money = 0;
        
        x = 0;
        

        // Initialize the array

        bottle_list = new ArrayList<Bottle>();
        Bottle x = new Bottle("Pepsi Max", "Pepsi", 0.3, 0.5, 1.8);
        bottle_list.add(x);
        x = new Bottle("Pepsi Max", "Pepsi", 0.3, 1.5, 2.2);
        bottle_list.add(x);
        x = new Bottle("Coca-Cola Zero", "Coca-Cola", 0.3, 0.5, 2.0);
        bottle_list.add(x);
        x = new Bottle("Coca-Cola Zero", "Coca-Cola", 0.3, 1.5, 2.5);
        bottle_list.add(x);
        x = new Bottle("Fanta Zero", "Coca-Cola", 0.3, 0.5, 1.95);
        bottle_list.add(x);
        
    }

    

    public double addMoney(double money) {

        money += 1;

        System.out.println("Klink! Added more money!");
        return money;

    }

    

    public double buyBottle(double money) {
    	
    	if(money == 0) {
    		System.out.println("Add money first!");
    	}
    	
    	else if(money < bottle_list.get(0).getPrice()) {
    		System.out.println("Add money first!");
    	}
    	
    	else {
    		bottles -= 1;
    		Scanner scanner = new Scanner(System.in);
    		System.out.print("Your choice: ");
    		int choice = scanner.nextInt();
    		String name = bottle_list.get(choice - 1).getName();
    		System.out.println("KACHUNK! " + name + " came out of the dispenser!");
    		money -= bottle_list.get(choice - 1).getPrice();
    		bottle_list.remove(choice - 1);
    	}
    	return money;
    	
        

    }

    public void listBottles() {
    	int x = 1;
    	for(int i = 0; i < bottle_list.size(); i++) {
    		System.out.println(x + ". Name: " + bottle_list.get(i).getName());
    		System.out.println("	Size: " + bottle_list.get(i).getSize() + "	Price: " + bottle_list.get(i).getPrice());
    		x++;
    	}
    }

    public double returnMoney(double money) {
    	DecimalFormat f = new DecimalFormat("#0.00");
    	String moneyString = String.valueOf(money);
    	moneyString = f.format(money);
    	moneyString = moneyString.replace(".", ",");
    	System.out.println("Klink klink. Money came out! You got " + moneyString + "€ back");
        money = 0;
        return money;

    }

}
