package homework8.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "laptop")
@Data
public class LaptopEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "manufacter")
    private String manifacter;

    @Column(name = "model")
    private String model;

    @Column(name = "price")
    private int price;
}
