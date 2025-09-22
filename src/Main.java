import static Service.BasketService.runBasketService;
import static Service.CustomerService.runCustomerService;
import static Service.ProductService.runProductService;
import static ustils.ustils1.scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome");

        stop : while (true){
            System.out.println("""
                    1 - Product_Service
                    2 - Customer_Service
                    3 - Basket_Service
                    4 - Exit\s
                   \s""");
            switch (scanner.nextInt()){
                case 1 ->{
                    runProductService();
                } case 2 ->{
                    runCustomerService();
                } case 3 ->{
                    runBasketService();
                } case 4 ->{
                    System.out.println("Goodbye");
                    return;
                }default -> {
                    System.out.println("wrong choice");
                }
            }
        }
    }
}
