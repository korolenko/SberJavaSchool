package FinalProject.Entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "carbrand")
@Data
public class SparePartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "model")
    private String model;
}
