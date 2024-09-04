package ra.presentation.run;

import ra.business.design.IGeneric.service.ProductService;
import ra.business.design.IGeneric.service.UserService;

import java.util.Scanner;

//import static ra.business.design.IGeneric.service.UserService.addToCart;


public class UserManagement {
//    UserService userService=new UserService();
    public static void userMenu(Scanner sc){
        boolean flag = true;
        do {
            System.out.println("********************************MENU-USER*******************************");
            System.out.println("*                                                                      *");
            System.out.println("*           1. Xem danh sách sản phẩm                                  *");
            System.out.println("*           2. Thêm vào giỏ hàng                                       *");
            System.out.println("*           3. Xem tất cả sản phẩm giỏ hàng                            *");
            System.out.println("*           4. Thay đổi số lượng sản phẩm trong giỏ hàng               *");
            System.out.println("*           5. Xóa 1 sản phẩm trong giỏ hàng                           *");
            System.out.println("*           6. Xóa toàn bộ sản phẩm trong giỏ hàng                     *");
            System.out.println("*           7. Quay lại                                                *");
            System.out.println("*                                                                      *");
            System.out.println("************************************************************************");
            System.out.println("Mời nhập lựa chọn:");
            String choice = sc.nextLine();
            switch (choice) {
                case "1": {
                    ProductService.showAllProduct();
                    break;
                }
                case "2": {
                    UserService.addToCart(sc);
                    break;
                }
                case "3": {
                    UserService.showAllCart();
                    break;
                }
                case "4": {
                    UserService.editQuantityInCart(sc);
                    break;
                }
                case "5": {
                    UserService.deleteProductInCart(sc);
                    break;
                }
                case "6": {
                    UserService.clearCart(sc);
                    break;
                }
                case "7": {
                    flag = false;
                    break;
                }
                default: {
                    System.out.println("Vui lòng nhập lựa chọn từ 1 -> 7");
                    break;
                }
            }
        } while (flag);
    }
}
