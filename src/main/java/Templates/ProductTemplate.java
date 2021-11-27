package Templates;

import java.util.Scanner;

import Models.Product.Product;
import Models.User.User;

public class ProductTemplate {
	private static Scanner userInput = new Scanner(System.in);
	
	public static Product addingNewProduct(User currentUser) {
        @SuppressWarnings("resource")
		Scanner userInput = new Scanner(System.in);

        System.out.println("Enter the product name ");
        String name = userInput.nextLine();

        System.out.println("Enter the product price :");
        int price = userInput.nextInt();
        userInput.nextLine();

        System.out.println("Enter about description : ");
        String description = userInput.nextLine();
        return new Product(name, price, description, currentUser.getId());
    }

    public static Product updateProduct(Product product) {
        System.out.println("Product update ...");

        System.out.println("1. Name \n2. Price \n3. Description");
        int choice = userInput.nextInt();
        userInput.nextLine();
        switch (choice){
            case 1:
                System.out.println("Enter the new name : ");
                String name = userInput.nextLine();
                if(name.length() > 0){
                    product.setName(name);
                }

            case 2:
                System.out.println("Enter the new price :");
                int price = userInput.nextInt();
                userInput.nextLine();

                if(price > 0){
                    product.setPrice(price);
                }
            case 3:
                System.out.println("Enter the new details : ");
                String description = userInput.nextLine();
                if(description.length() > 0) {
                    product.setDescription(description);
                }
                break;
            default:
                System.out.println("Wrong Input !!");
                break;
        }
        return product;
    }
}
