import java.util.Scanner;

public class Mainclass {

	public static void main(String[] args) {

		BottleDispenser INSTANCE = BottleDispenser.getInstance();
		Scanner scanner = new Scanner(System.in);
		boolean aja = true;
		while(aja) {
			System.out.println("");
			System.out.println("*** BOTTLE DISPENSER ***");
			System.out.println("1) Add money to the machine");
			System.out.println("2) Buy a bottle");
			System.out.println("3) Take money out");
			System.out.println("4) List bottles in the dispenser");
			System.out.println("0) End");
			System.out.print("Your choice: ");
			int choice = scanner.nextInt();
			
			switch(choice) {
			
			case 0:
				aja = false;
				break;
			
			case 1:
				INSTANCE.money = INSTANCE.addMoney(INSTANCE.money);
				break;
			
			case 2:
				INSTANCE.listBottles();
				INSTANCE.money = INSTANCE.buyBottle(INSTANCE.money);
				break;
				
			case 3:
				INSTANCE.money = INSTANCE.returnMoney(INSTANCE.money);
				break;
				
			case 4:
				INSTANCE.listBottles();
				break;
			
			}
		}
	}

}

	


