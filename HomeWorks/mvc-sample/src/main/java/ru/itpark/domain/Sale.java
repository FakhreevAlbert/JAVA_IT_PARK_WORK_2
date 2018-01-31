package ru.itpark.domain;

public class Sale {
    private int id;
    private String manager;
    private String product;
    private int sold;
    private int price;

    public Sale(int id, String manager, String product, int sold, int price) {
        this.id = id;
        this.manager = manager;
        this.product = product;
        this.sold = sold;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
