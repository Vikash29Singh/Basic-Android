package com.example.myapplication;

public class Model {

    private String name, manufacturer, price;
    int image, fav;
    //boolean colored;

    public Model() {
    }

    public Model(String name, String manufacturer, String price, int image, int fav/*, boolean colored*/) {

        /*this.colored = colored;
*/
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.image = image;
        this.fav = fav;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getImage() {
        return image;
    }
    public int getFav() {
        return fav;
    }

}
