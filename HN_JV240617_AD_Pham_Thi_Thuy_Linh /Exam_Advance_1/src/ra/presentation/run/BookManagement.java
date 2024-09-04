package ra.presentation.run;

import ra.business.entity.Cart;
import ra.business.entity.Catalog;
import ra.business.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManagement {
    static Scanner sc = new Scanner(System.in);
    public static List<Catalog> catalogList = new ArrayList<>();
    public static List<Product> productList = new ArrayList<>();
    public static List<Cart> cartList = new ArrayList<>();


    public static void main(String[] args) {
        Catalog catalog1 = new Catalog(1,"ct1","mt1");
        Catalog catalog2 = new Catalog(2,"ct2","mt2");
        Catalog catalog3 = new Catalog(3,"ct3","mt3");
        catalogList.add(catalog1);
        catalogList.add(catalog2);
        catalogList.add(catalog3);

        Product product1 = new Product("P001","p1",30000.0,"mt1",12,catalog1,true);
        Product product2 = new Product("P002","p2",50000.0,"mt2",15,catalog2,true);
        Product product3 = new Product("P003","p3",100000.0,"mt3",18,catalog1,true);
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);


        do {
            System.out.println("*******************************BASIC-MENU*******************************");
            System.out.println("*                                                                      *");
            System.out.println("*                        1. Quản lý danh mục                           *");
            System.out.println("*                        2. Quản lý sản phẩm                           *");
            System.out.println("*                        3. Dành cho người dùng (***)                  *");
            System.out.println("*                        4. Thoát                                      *");
            System.out.println("*                                                                      *");
            System.out.println("************************************************************************");
            System.out.println("Please enter your choice:");
            String choice = sc.nextLine();
            switch (choice) {
                case "1": {
                    CatalogManagement.catalogMenu(sc);
                    break;
                }
                case "2": {
                    ProductManagement.productMenu(sc);
                    break;
                }
                case "3": {
                    UserManagement.userMenu(sc);
                    break;
                }
                case "4": {
                    System.exit(0);
                    break;
                }
                default: {
                    System.err.println("Please enter choice form 1 to 4");
                    break;
                }
            }
        } while (true);
    }
}
