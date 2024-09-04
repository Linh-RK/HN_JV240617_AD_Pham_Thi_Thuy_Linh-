package ra.presentation.run;

import ra.business.design.IGeneric.service.CatalogService;

import java.util.Scanner;


public class CatalogManagement {
    public static void catalogMenu(Scanner sc){

        boolean flag = true;
        do {
            System.out.println("***************************CATALOG-MANAGEMENT***************************");
            System.out.println("*                                                                      *");
            System.out.println("*  1. Nhập số danh mục thêm mới và nhập thông tin cho từng danh mục    *");
            System.out.println("*  2. Hiển thị thông tin tất cả các danh mục                           *");
            System.out.println("*  3. Sửa tên danh mục theo mã danh mục                                *");
            System.out.println("*  4. Xóa danh muc theo mã danh mục (lưu ý ko xóa khi có sản phẩm)     *");
            System.out.println("*  5. Quay lại                                                         *");
            System.out.println("*                                                                      *");
            System.out.println("************************************************************************");
            System.out.println("Mời nhập lựa chọn:");
            String choice = sc.nextLine();
            switch (choice) {
                case "1": {
                    CatalogService.addCatalog(sc);
                    break;
                }
                case "2": {
                    CatalogService.showAllCatalog();
                    break;
                }
                case "3": {
                    CatalogService.editCatalogById(sc);
                    break;
                }
                case "4": {
                    CatalogService.deleteCatalogById(sc);
                    break;
                }
                case "5": {
                    flag = false;
                    break;
                }
                default: {
                    System.out.println("Please enter choice form 1 to 5");
                    break;
                }
            }
        } while (flag);
    }
}
