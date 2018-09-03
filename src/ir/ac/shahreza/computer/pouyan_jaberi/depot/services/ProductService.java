package ir.ac.shahreza.computer.pouyan_jaberi.depot.services;

import ir.ac.shahreza.computer.pouyan_jaberi.depot.beans.Product;
import ir.ac.shahreza.computer.pouyan_jaberi.depot.dao.ProductDAO;

public class ProductService {
    private ProductDAO productDAO = new ProductDAO();
    private Product product;

    public Product getProduct() {
        return product;
    }

    public ProductService(Product product) {
        this.product = product;
    }

    /*public void add(Product product) {
        this.productDAO.addProduct(product);
    }

    public void update(Product product) {
        this.productDAO.updateProduct(product);
    }

    public void buy(Product product, int number) {
        this.productDAO.buyProduct(product, number);
    }

    public void getInfo(Product product) {

    }*/

    public void add() {
        this.productDAO.addProduct(product);
    }

    public void update() {
        this.productDAO.updateProduct(product);
    }

    public boolean buy(int number) {
        return this.productDAO.buyProduct(product, number);
    }

    public Product getInfo() {
        return this.productDAO.getProductInfo(product);
    }
}
