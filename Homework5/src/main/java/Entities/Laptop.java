package Entities;

import javax.persistence.*;

@Entity
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String model;
    @Column
    private Integer ram, price,screen;

    public Laptop(){
    }

    public Laptop(String model,int ram, int price, int screen){
        this.model = model;
        this.ram = ram;
        this.price = price;
        this.screen = screen;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Laptop {id: "
                + this.id
                + ", model: "
                + this.model
                + ", ram: "
                + this.ram
                + ", price: "
                + this.price
                + ", screen: "
                + this.screen
                + "}\n";
    }
}
