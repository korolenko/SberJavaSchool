package FinalProjectSecondService.Entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
@Table(name = "repairlist", schema = "\"order\"")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Accessors(chain = true)
public class RepairListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "orderid")
    private Long orderId;

//    @OneToMany
//    @JoinColumn(name = "orderid")
////    @Column(name = "orderid")
//    private OrderEntity orderId;

    @Column(name = "pricelistid")
    private Long pricelistId;
}
