package ru.itpark.domain;

public class Sale {
    private int id;
    private String manager_name;
    private String product_name;
    private int sold_amount;
    private int price;

    public Sale(int id, String manager_name, String product_name, int sold_amount, int price) {
        this.id = id;
        this.manager_name = manager_name;
        this.product_name = product_name;
        this.sold_amount = sold_amount;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManager_name() {
        return manager_name;
    }

    public void setManager_name(String manager_name) {
        this.manager_name = manager_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getSold_amount() {
        return sold_amount;
    }

    public void setSold_amount(int sold_amount) {
        this.sold_amount = sold_amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
