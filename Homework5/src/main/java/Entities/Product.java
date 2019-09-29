package Entities;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String maker,model,type;

    public Product(){
    }

    public Product(String maker, String model, String type){
        this.maker = maker;
        this.model = model;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Product{id: "
                + this.id
                + ", maker: "
                + this.maker
                + ", model: "
                + this.model
                + ", type: "
                + this.type
                + "}\n";
    }
}
