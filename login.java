import java.util.HashMap;
import java.util.Scanner;

public class login {

    
    private static HashMap<String, String> users = new HashMap<>();
    private static String loggedInUser = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Welcome ====");

            
            if (loggedInUser == null) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();

                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                if (users.containsKey(username) && users.get(username).equals(password)) {
                    loggedInUser = username;
                    System.out.println("Login successful! Welcome, " + username + ".");
                } else {
                    System.out.println("Invalid username or password.");
                    System.out.println("Would you like to register? (yes/no)");
                    String choice = scanner.nextLine();

                    if (choice.equalsIgnoreCase("yes")) {
                        signUp(scanner);
                    } else {
                        continue;
                    }
                }
            }

            
            if (loggedInUser != null) {
                System.out.println("\n==== Logged In ====");
                System.out.println("Welcome to the application, " + loggedInUser + "!");
                System.out.println("It's great having you buddy... ");

                
                System.out.println("\nWould you like to log out? (yes/no)");
                String choice = scanner.nextLine();

                if (choice.equalsIgnoreCase("yes")) {
                    logOut();
                } else {
                    System.out.println("Enjoy your session, " + loggedInUser + "!");
                }
            }
        }
    }

    
    private static void signUp(Scanner scanner) {
        System.out.println("\n==== Sign Up ====");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        if (users.containsKey(username)) {
            System.out.println("Username already exists. Please try another.");
            return;
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        users.put(username, password);
        System.out.println("Sign up successful! You can now log in.");
    }

    
    private static void logOut() {
        if (loggedInUser == null) {
            System.out.println("No user is currently logged in.");
        } else {
            System.out.println("User " + loggedInUser + " has been logged out.");
            loggedInUser = null;
        }
    }
}
