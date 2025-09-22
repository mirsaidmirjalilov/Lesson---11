package Service;

import qwe.Basket;
import qwe.Customer;
import qwe.Product;

import static DB.DataBase.*;
import static ustils.ustils1.scanner;
import static ustils.ustils1.scannerStr;

public class CustomerService {
    static int id = 1;

    public static void runCustomerService() {
        stop:
        while (true) {
            System.out.println("""
                    1 - create Customer
                    2 - delete Customer
                    3 - buy product
                    4 - Exit
                    """);
            switch (scanner.nextInt()) {
                case 1 -> createCustomer();
                case 2 -> deleteCustomer();
                case 3 -> buyProduct();
                case 4 -> {
                    break stop;
                }
                default -> System.out.println("wrong choice");
            }
        }
    }

    private static void buyProduct() {
        System.out.println("choose customer that will buy");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
        int customerId = scanner.nextInt();

        System.out.println("choose product to buy");
        for (Product product : products) {
            System.out.println(product);
        }
        int productId = scanner.nextInt();

        System.out.println("enter quantity to buy");
        int quantityToBuy = scanner.nextInt();

        if (quantityToBuy > products.get(productId - 1).getQuantity()) {
            System.out.println("entered quantity more than existing quantity");
        } else if (customers.get(customerId - 1).getBalance() < products.get(productId).getPrice() * quantityToBuy) {
            System.out.println("not enough balance to purchase");
        } else {
            double overallPrice = products.get(productId).getPrice() * quantityToBuy;
            customers.get(customerId - 1).setBalance(customers.get(customerId - 1).getBalance() - overallPrice);
            products.get(productId).setQuantity(products.get(productId).getQuantity() - quantityToBuy);

            System.out.println("purchase successfully done");
        }
    }

    private static void deleteCustomer() {
        System.out.println("choose customer to delete");
        for (Customer customer : customers) {
            System.out.println(customer);
        }

        int customerId = scanner.nextInt();

        customers.remove(customerId - 1);
        System.out.println("customer has been deleted");
    }

    private static void createCustomer() {
        System.out.println("enter name");
        String name = scannerStr.nextLine();
        System.out.println("enter balance");
        double balance = scanner.nextDouble();

        customers.add(new Customer(
                id++,
                name,
                balance
        ));

        System.out.println("customer has been created");
    }
}
