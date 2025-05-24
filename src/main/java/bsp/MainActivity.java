package bsp;

import java.util.Scanner;

public class MainActivity {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("helllo world");
		
		do{
			//Efficient for non-hard coding 
			String arr[] = {"Login", "Registration"};
			
			for(int i = 0; i<arr.length; i++) {
				System.out.println((i+1) + ". " + arr[i]);
			}
			
			try {
				int choice = scanner.nextInt(); scanner.nextLine();
				switch (choice) {
					case 1:
						System.out.println("Welcome Shonen");
						//
						break;//to be implemented to get data in database&System(scanner);
					case 2:
						System.out.println("o");
						break;//(scanner);
					default: System.out.println("sdas");
				}
			}catch (Exception e) {
				System.out.println("Invalid Output.");
				scanner.next();
			}
		}while(true);
	}
}