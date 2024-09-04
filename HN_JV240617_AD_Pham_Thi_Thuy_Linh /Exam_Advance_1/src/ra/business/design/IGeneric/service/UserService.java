package ra.business.design.IGeneric.service;

import ra.business.entity.Cart;
import ra.business.entity.Product;

import java.util.Scanner;

import static ra.business.design.IGeneric.service.ProductService.inputNum;
import static ra.business.design.IGeneric.service.ProductService.showAllProduct;
import static ra.presentation.run.BookManagement.cartList;
import static ra.presentation.run.BookManagement.productList;


public class UserService {
    public UserService() {
    }

    public static void addToCart(Scanner sc) {
        Cart cartNew = new Cart();
        showAllProduct();
        System.out.println("Enter product ID you want to add to cart: ");
        do {
            String productID = sc.nextLine();
            if(productID.isBlank()) {
                System.err.println("Data can't be empty");
            }else{
                if(productList.stream().noneMatch(p->p.getProductId().equalsIgnoreCase(productID))) {
                    System.err.println("Product ID does not match");
                }else {
                    Product productAdd = productList.stream().filter(p->p.getProductId().equalsIgnoreCase(productID)).toList().getFirst();
                    System.out.println("Enter quantity of product you want to add to cart: ");

                    do {
                        int quantity = inputNum(sc);
                        if(quantity > productAdd.getStock()) {
                            System.out.println("SORRY ! we don't have enough product in stock to add to cart");
                        }else {

                            if(cartList.stream().anyMatch(p->p.getProduct().getProductId().equalsIgnoreCase(productID))){
                                Cart cartOld = cartList.stream().filter(p->p.getProduct().getProductId().equalsIgnoreCase(productID)).findFirst().get();
                                cartOld.setQty(cartOld.getQty() + quantity);
                                showAllCart();
                                return;
                            }else{
                                cartNew.setProduct(productAdd);
                                cartNew.setQty(quantity);
                                cartList.add(cartNew);
                                cartNew.getProduct().setStock(productAdd.getStock() - quantity);
                            }
                            System.out.println("Added product to the cart");
                            showAllCart();
                            return;
                        }
                    }while(true);
                }
            }
        }while(true);
    }

    public static void showAllCart() {
        if(cartList.isEmpty()) {
            System.err.println("Cart is empty");
        }else {
            cartList.forEach(Cart::displayCart);
            System.out.println("-----------------------------------------------------------------------------------------------");
        }
    }

    public static void editQuantityInCart(Scanner sc) {
        System.out.println("Enter product ID you want to edit: ");
        do {
            String productID = sc.nextLine();
            if(productID.isBlank()) {
                System.err.println("Data can't be empty");
            }else{
                if(cartList.stream().noneMatch(c->c.getProduct().getProductId().equalsIgnoreCase(productID))) {
                    System.err.println("Product does not exist in cart");
                }else{
                    Cart productOldCart = cartList.stream().filter(c->c.getProduct().getProductId().equalsIgnoreCase(productID)).toList().getFirst();
                    Product productOld = productOldCart.getProduct();
//              Display
                    System.out.println("Product you want to edit: ");
                    productOldCart.displayCart();
                    System.out.println("Enter new quantity of product you want to edit: ");
                    int quantity = inputNum(sc);

//              Update Product List
                    productOld.setStock(productOld.getStock() + productOldCart.getQty() - quantity);
//              Update Cart
                    System.out.println("New cart:");
                    productOldCart.setQty(quantity);
                    System.out.println("Edited successfully");
                    showAllCart();

                    return;
                }
            }
        }while(true);
    }

    public static void deleteProductInCart(Scanner sc) {
        showAllCart();
        System.out.println("Enter product ID you want to delete: ");
        do {
            String productID = sc.nextLine();
            if(productID.isBlank()) {
                System.err.println("Data can't be empty");
            }else{
                if(cartList.stream().noneMatch(c->c.getProduct().getProductId().equalsIgnoreCase(productID))) {
                    System.err.println("Product does not exist in cart");
                    return;
                }else{
                    Cart productOldCart = cartList.stream().filter(c->c.getProduct().getProductId().equalsIgnoreCase(productID)).toList().getFirst();
                    Product productOld = productOldCart.getProduct();
//              Update Cart
                    cartList.remove(productOldCart);
//              Update Product List
                    productOld.setStock(productOld.getStock() + productOldCart.getQty());

                    System.out.println("Delete successfully");
                    showAllCart();
                    return;
                }
            }
        }while(true);
    }

    public static void clearCart(Scanner sc) {
        if(cartList.isEmpty()) {
            System.err.println("Cart is empty");
        }else{
            Product productBeforeClear ;
            for(Cart cart: cartList) {
                int index = productList.indexOf(cart.getProduct());
                productBeforeClear =productList.get(index);
                productList.get(index).setStock(productBeforeClear.getStock()+ cart.getQty());
            }
            cartList.clear();
            System.out.println("Cart is empty");
        }
    }


}
