package ra.business.design.IGeneric.service;

import ra.business.design.IGeneric.IGenericService;
import ra.business.entity.Product;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static ra.presentation.run.BookManagement.productList;

public class ProductService implements IGenericService<Product, String> {
    static ProductService productService = new ProductService();
    @Override
    public List<Product> getAll() {
        return List.of();
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public Product findById(String id) {

        if(productList.stream().anyMatch(p-> p.getProductId().equalsIgnoreCase(id))){
            return productList.stream().filter(p-> p.getProductId().equalsIgnoreCase(id)).findFirst().get();
        }else {
            return null;
        }
    }

    @Override
    public void delete(String id) {
        if(findById(id) == null){
            System.err.println("Product not found");
        }else{
            productList.remove(productList.indexOf(findById(id)));
            System.out.println("Deleted successfully !");
        }
    }

    public static void addProduct(Scanner sc) {
        System.out.println("Enter the id of the product you want to add:");
        int number = inputNum(sc);
        for (int i = 0; i < number; i++) {
            System.out.println("Product #" + (i + 1) + ":");
            Product productNew = new Product();
            productNew.inputProduct(sc,true);
            productList.add(productNew);
        }
        System.out.println("Add product successful");
        showAllProduct();

    }

    public static void showAllProduct() {
        if (productList.size() <= 0) {
            System.err.println("Product List is empty");
        }else {
            productList.forEach(Product::displayProduct);
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }

    public static void sortByPrice() {
        productList.stream().sorted(Comparator.comparingDouble(Product::getProductPrice)).toList().reversed().forEach(Product::displayProduct);
    }

    public static void deleteProductById(Scanner sc) {
        showAllProduct();
        System.out.println("Enter the id of the product you want to delete:");
       do{
           String id = sc.nextLine();
           if(id.isBlank())
               System.err.println("Data cannot be empty");
           else{
               productService.delete(id);
               showAllProduct();
               return;
           }
       }while (true);
    }

    public static void findByName(Scanner sc) {
        System.out.println("Enter the name of the product you want to find:");
        String name;
        do {
             name = sc.nextLine();
            if (name.isBlank()) {
                System.err.println("Data can not be blank");
            } else {
                String finalName = name;
                if(productList.stream().filter(p -> p.getProductName().contains(finalName)).toList().isEmpty()){
                    System.err.println("No result");
                    return;
                }else{
                    System.out.println("Result");
                    String finalName1 = name;
                    productList.stream().filter(p -> p.getProductName().contains(finalName1)).forEach(Product::displayProduct);
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
                    return;
                    }
                }
        }while (true);
    }

    public static void editProductById(Scanner sc) {
        System.out.println("Enter the id of the product you want to edit:");

        do {
            String id = sc.nextLine();
            if(productService.findById(id) == null) {
                System.err.println("Product #" + id + " does not exist");
            }else {
                Product productOld = productService.findById(id);
                productOld.inputProduct(sc,false);
                productOld.setProductId(productOld.getProductId());
                System.out.println("Product #" + id + " has been updated");
                showAllProduct();
                return;
            }
        }while (true);
    }

    public static int inputNum(Scanner sc) {
        do {
            String number = sc.nextLine();
            if (number.isBlank()) {
                System.err.println("Data cannot be empty");
            }else {
                    try{
                         int numberInt = Integer.parseInt(number);
                        if(numberInt< 0){
                            System.err.println("Please enter a positive integer");
                        }else {
                            return numberInt;
                        }
                    }catch (NumberFormatException e){
                        System.err.println("Please enter a positive integer");
                    }
            }
        }while (true);
    }
}
