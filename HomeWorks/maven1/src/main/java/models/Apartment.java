package models;




public class Apartment {
    private int id;
    private int number;
    private int area;
    private int ownerId;

    public Apartment(int id, int number, int area, int ownerId) {
        this.id = id;
        this.number = number;
        this.area = area;
        this.ownerId = ownerId;

    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }


}
