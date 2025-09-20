package Service;

import DB.DataBase;
import qwe.Product;

import static DB.DataBase.products;
import static ustils.ustils1.scanner;
import static ustils.ustils1.scannerStr;

public class ProductService {
    public static void runProductService() {
        stop:
        while (true) {
            System.out.println("""
                    1 - Product create
                    2 - Product delete
                    3 - Product amount add
                    4 - return to Main menu 
                    """);
            switch (scanner.nextInt()) {
                case 1 -> {
                    newProduct();
                }
                case 4 -> {
                    break stop;
                }
                default -> {
                    System.out.println("wrong choice");
                }
            }
        }
    }

    private static void newProduct() {
        System.out.println("enter product name: ");
        String name = scannerStr.nextLine();
        System.out.println("enter price: ");
        double price = scanner.nextDouble();
        System.out.println("enter product quantity: ");
        int quantity = scanner.nextInt();

        if (products.isEmpty()) {
            products.add(new Product(
                    1,
                    name,
                    price,
                    quantity
            ));
        } else {
            products.add(new Product(
                    products.get(products.size() - 1).getId(),
                    name,
                    price,
                    quantity
            ));
        }

        System.out.println("product has been created");
    }
}
