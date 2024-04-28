import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;
        char type;
        String name;
        double price, customsFee;

        System.out.print("Enter the number of products: ");
        n = sc.nextInt();
        sc.nextLine();

        List<Product> products = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        for(int i = 0; i < n; i++){

            System.out.println("Product #" + (i+1) + " data: ");

            System.out.print("Common, used or imported (c, u, i)?");
            type = sc.next().toUpperCase().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            name = sc.nextLine();
            System.out.print("Price: ");
            price = sc.nextInt();

            if(type == 'I'){
                System.out.print("Customs fee: ");
                customsFee = sc.nextDouble();

                products.add(new ImportedProduct(name, price, customsFee));

            } else if(type == 'U'){
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                String dateStr = sc.next();
                Date manufactureDate = sdf.parse(dateStr, new ParsePosition(0));
                products.add(new UsedProduct(name, price, manufactureDate));
            } else {
                products.add(new Product(name, price));
            }
        }
        System.out.println("Price tags: ");
        for(Product product: products){
            System.out.println(product.priceTag());
        }

        sc.close();
    }
    
}
