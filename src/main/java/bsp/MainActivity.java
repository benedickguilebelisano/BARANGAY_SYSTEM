package bsp;

import java.util.Scanner;

public class MainActivity {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("helllo world");
		
		while (true) {
			System.out.println("Welcome Shonen");
			System.out.println("1.Login");  //number are temporary for console
			System.out.println("2.Registration");

			int choice = scanner.nextInt(); scanner.nextLine();
			switch (choice) {
				case 1 -> //to be implemented to get data in database&System(scanner);
				case 2 -> //(scanner);
				default -> System.out.println("sdas");
			}
		}
	}
}