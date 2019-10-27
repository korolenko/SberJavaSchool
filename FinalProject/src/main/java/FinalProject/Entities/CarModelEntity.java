package FinalProject.Entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "carbrand")
@Data
public class CarModelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "manufacter")
    private String manifacter;

    @Column(name = "model")
    private String model;
}
