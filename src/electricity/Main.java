package electricity;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserDAO userDAO = new UserDAO();
        BillingService billingService = new BillingService();

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Edit User Details");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (option == 1) {
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                System.out.print("Enter phone number: ");
                String phoneNumber = scanner.nextLine();
                System.out.print("Enter email: ");
                String email = scanner.nextLine();
                System.out.print("Enter electricity board number: ");
                String electricityBoardNo = scanner.nextLine();

                User user = new User(name, password, phoneNumber, email, electricityBoardNo);
                userDAO.registerUser(user);
                System.out.println("User registered successfully! Your User ID is: " + user.getUserId());
            } else if (option == 2) {
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                System.out.println("Welcome to TNEB Bill payment System ");
                System.out.println("Your name is "+name);
                if (userDAO.validateUser(name, password)) {
                    User user = userDAO.getUserByNameAndPassword(name, password); // Retrieve user

                    if (user != null) {
                        System.out.print("Enter electricity usage (in units): ");
                        double unitsConsumed = scanner.nextDouble();
                        billingService.enterUsage(user, unitsConsumed);
                    } else {
                        System.out.println("User not found.");
                    }
                } else {
                    System.out.println("Invalid username or password.");
                }
            } else if (option == 3) {
                System.out.print("Enter User ID: ");
                int userId = scanner.nextInt();
                scanner.nextLine(); // consume newline

                User user = userDAO.getUserById(userId);
                if (user != null) {
                    System.out.print("Enter new name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter new phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter new email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter new electricity board number: ");
                    String electricityBoardNo = scanner.nextLine();

                    userDAO.updateUser(userId, name, phoneNumber, email, electricityBoardNo);
                    System.out.println("User details updated successfully!");
                } else {
                    System.out.println("User ID not found.");
                }
            } else if (option == 4) {
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
