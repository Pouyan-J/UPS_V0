package ir.ac.shahreza.computer.pouyan_jaberi.depot.beans;

import ir.ac.shahreza.computer.pouyan_jaberi.seller.beans.Seller;

public class Product {
    private String id;
    private String name;
    private String caption;
    private Seller seller;
    private int count;

    //<editor-fold desc="Getters and Setters">
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if (count >= 0)
            this.count = count;
        else
            this.count = 0;
    }

    //</editor-fold>


    public Product() {
    }

    public Product(String id, String name, String caption, Seller seller, int count) {
        this.id = id;
        this.name = name;
        this.caption = caption;
        this.seller = seller;
        this.count = count;
    }
}