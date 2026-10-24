package com.example.sqlitedemo;

/**
 * Un produit stocké dans la base SQLite (table « products »).
 */
public class Product {

    private int id;
    private String productName;
    private int sku;

    public Product() {
    }

    public Product(String productName, int sku) {
        this.productName = productName;
        this.sku = sku;
    }

    public Product(int id, String productName, int sku) {
        this.id = id;
        this.productName = productName;
        this.sku = sku;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    @Override
    public String toString() {
        return "#" + id + "  " + productName + "  (SKU " + sku + ")";
    }
}
