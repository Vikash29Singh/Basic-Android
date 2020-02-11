package com.example.Travelprogram;

public class Model {

    private String name, destination, price,arival_time,dept_time;
    int image, fav;
    //boolean colored;

    public Model() {
    }

    public Model(String name, String dept_time,String destination, String arival_time,String price, int image/*, boolean colored*/) {

        /*this.colored = colored;
*/
        this.name = name;
        this.destination = destination;
        this.price = price;
        this.image = image;
        this.arival_time = arival_time;
        this.dept_time = dept_time;

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

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getImage() {
        return image;
    }
    public int getFav() {
        return fav;
    }

    public String getArival_time() {
        return arival_time;
    }

    public void setArival_time(String arival_time) {
        this.arival_time = arival_time;
    }

    public String getDept_time() {
        return dept_time;
    }

    public void setDept_time(String dept_time) {
        this.dept_time = dept_time;
    }
}
