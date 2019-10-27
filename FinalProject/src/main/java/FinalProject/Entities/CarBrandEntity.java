package FinalProject.Entities;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "carbrand")
@Data
public class CarBrandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "manufacter")
    private String manifacter;
}
