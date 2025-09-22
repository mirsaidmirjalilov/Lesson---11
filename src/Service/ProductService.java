package Service;

import qwe.Product;

import static DB.DataBase.products;
import static ustils.ustils1.scanner;
import static ustils.ustils1.scannerStr;

public class ProductService {
    static int size = 1;

    public static void runProductService() {
        stop:
        while (true) {
            System.out.println("""
                     1 - Product create
                     2 - Product delete
                     3 - Product amount add
                     4 - return to Main menu\s
                    \s""");
            switch (scanner.nextInt()) {
                case 1 -> newProduct();
                case 2 -> deleteProduct();
                case 3 -> addQuantityToProduct();
                case 4 -> {
                    break stop;
                }
                default -> System.out.println("wrong choice");
            }
        }
    }

    private static void addQuantityToProduct() {
        System.out.println("choose product to add quantity");
        for (Product product : products) {
            System.out.println(product);
        }

        int idToAdd = scanner.nextInt();
        System.out.println("enter quantity:");
        int quantity = scanner.nextInt();

        products.get(idToAdd - 1).setQuantity(products.get(idToAdd - 1).getQuantity() + quantity);
        System.out.println("entered quantity has been added");
    }

    private static void deleteProduct() {
        if (products.isEmpty()) {
            System.out.println("firstly create product");
            return;
        }

        System.out.println("choose product to delete");
        for (Product product : products) {
            System.out.println(product);
        }

        int idToDelete = scanner.nextInt();

        products.remove(idToDelete - 1);
        size--;
        System.out.println("product has been deleted");
    }

    private static void newProduct() {
        System.out.println("enter product name: ");
        String name = scannerStr.nextLine();
        System.out.println("enter price: ");
        double price = scanner.nextDouble();
        System.out.println("enter product quantity: ");
        int quantity = scanner.nextInt();

        products.add(new Product(
                size++,
                name,
                price,
                quantity
        ));

        System.out.println("product has been created");
    }
}
