package edu.core.java.bank.vo;

/**
 * Created by nikitamakarov on 14.05.17.
 */

public class ProductVO extends ValueObject{

    public String name;
    public double price;

    public ProductVO(Long id, String name, double price) {
        super.id = id;
        this.name = name;
        this.price = price;
    }

    public ProductVO(String name, double price) {
        this.name = name;
        this.price = price;
    }

//    @Override
//    public String toString() {
//        return  "id: " + super.id + " | product name: " + name +  " | product salary: " + price;
//    }

}
