package ra.business.entity;

public class Cart{
    private Product product;
    private int qty;

    public Cart() {
    }

    public Cart(int qty, Product product) {
        this.qty = qty;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    public void displayCart() {
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.printf("| Id: %-5s | Name: %-15s | Price:%10.1f | Qty: %-10d | Catalog: %-10s |\n",
                this.product.getProductId(), this.product.getProductName(),this.product.getProductPrice(), this.qty,this.product.getCatalog().getCatalogName());
    }

}

