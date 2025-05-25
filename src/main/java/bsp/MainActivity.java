package bsp;

import java.util.Scanner;

public class MainActivity {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("helllo world");
		
		while (true) {
			System.out.println();
			System.out.println(" Welcome to the Barangay System ");
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println("3. Exit"); //will be remove when gui is available
			
			
			int choice = scanner.nextInt();
			
			switch (choice) {
			case 1 -> {
				System.out.print("Username: ");
				String username = scanner.next();
				System.out.print("Password: ");
				String password = scanner.next();
				
				if (Database.loginStaff(username, password)) {
					System.out.println("Login successful!");
					//if login pupunta sa menu but not available to call now so commentt muna
				} else {
					System.out.println("Invalid credentials. Please try again.");
				} 
			}
			case 2 -> {
				System.out.print("Full Name: ");
				String fullName = scanner.next();
				System.out.print("Username: ");
				String username = scanner.next();
				System.out.print("Password: ");
				String password = scanner.next();
				System.out.print("Position: ");
				String position = scanner.next();
				System.out.print("Email: ");
				String email = scanner.next();
				System.out.print("Phone Number: ");
				String phoneNumber = scanner.next();
				System.out.print("Address: ");
				String address = scanner.next();
				
				boolean registered = Database.registerStaff(fullName, username, password, position, email, phoneNumber, address);
				
				if (registered) {
					System.out.println("Registration successful!");
				} else {
					System.out.println("Registration failed. Username or email may already be taken.");
				}
			}
			case 3 -> {
			    System.out.println("Goodbye");
			    scanner.close(); // Close the scanner to avoid resource leak
				System.exit(choice); // mag login ulit sdasad
			}
			default -> {
				System.out.println("Invalid choice. Please try again.");
			}
			
		}

		
	}
	
	}
	//below is the last brace brakettt
}
