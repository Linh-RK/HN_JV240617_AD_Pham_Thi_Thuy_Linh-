package ra.presentation.run;

import ra.business.design.IGeneric.service.ProductService;

import java.util.Scanner;

public class ProductManagement {

    public static void productMenu(Scanner sc){
        boolean flag = true;
        do {
            System.out.println("***************************PRODUCT-MANAGEMENT***************************");
            System.out.println("*                                                                      *");
            System.out.println("*       1. Nhập số sản sản phẩm và nhập thông tin sản phẩm             *");
            System.out.println("*       2. Hiển thị thông tin các sản phẩm                             *");
            System.out.println("*       3. Sắp xếp sản phẩm theo giá giảm dần                          *");
            System.out.println("*       4. Xóa sản phẩm theo mã                                        *");
            System.out.println("*       5. Tìm kiếm sách theo tên sách                                 *");
            System.out.println("*       6. Thay đổi thông tin của sách theo mã sách                    *");
            System.out.println("*       7. Quay lại                                                    *");
            System.out.println("*                                                                      *");
            System.out.println("************************************************************************");
            System.out.println("Mời nhập lựa chọn:");
            String choice = sc.nextLine();
            switch (choice) {
                case "1": {
                    ProductService.addProduct(sc);
                    break;
                }
                case "2": {
                    ProductService.showAllProduct();
                    break;
                }
                case "3": {
                    ProductService.sortByPrice();
                    break;
                }
                case "4": {
                    ProductService.deleteProductById(sc);
                    break;
                }
                case "5": {
                    ProductService.findByName(sc);
                    break;
                }
                case "6": {
                    ProductService.editProductById(sc);
                    break;
                }
                case "7": {
                    flag = false;
                    break;
                }
                default: {
                    System.out.println("Please enter choice form 1 to 7");
                    break;
                }
            }
        } while (flag);
    }
}
