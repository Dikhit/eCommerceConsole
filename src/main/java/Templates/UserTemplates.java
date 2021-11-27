package Templates;

import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;

import DAO.UserDAO;
import Models.User.User;

public class UserTemplates {
	private static Scanner userInput = new Scanner(System.in);
	
	public static void updateProfileTemplate(User currentUser, AbstractApplicationContext context) {
        System.out.println(currentUser);
        System.out.println();
        System.out.println("What you want to update : ");
        boolean isDone = false;
        while (!isDone){
            System.out.println("1. Name \n2. Email \n3. Password \n4. Wallet Amount ");
            int choice = userInput.nextInt();
            userInput.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Enter your new name !!");
                    String name = userInput.nextLine();
                    if (name.length() > 0){
                        currentUser.setName(name);
                    }
                    break;
                case 2:
                    System.out.println("Enter your new email !!");
                    String email = userInput.nextLine();
                    if(email.length() > 0){
                        currentUser.setEmail(email);
                    }
                    break;
                case 3:
                    System.out.println("Enter your new password !!");
                    String password = userInput.nextLine();
                    if (password.length() > 3){
                        currentUser.setPassword(password);
                    }
                    else {
                        System.out.println("password length min 3");
                    }
                    break;
                case 4:
                    System.out.println("Enter your amount !!");
                    int walletPrice = userInput.nextInt();
                    if(walletPrice > 0){
                        currentUser.setWalletPrice(
                                currentUser.getWalletPrice() + walletPrice
                        );
                    }
                    break;
                default:
                    isDone = true;
            }
        }
        currentUser = UserDAO.getUserDAO(context).updateUser(currentUser);
        if(currentUser != null){
            System.out.println(currentUser);
            System.out.println("Update Successfully");
        }
        else{
            System.out.println("Please try again later !!");
        }
    }
}
