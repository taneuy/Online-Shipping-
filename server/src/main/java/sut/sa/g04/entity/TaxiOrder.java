package sut.sa.g04.entity;

import javax.persistence.*;
import lombok.*;

@Entity 
@Data
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="tb_taxiOrder")
public class TaxiOrder {
    @Id 
    @SequenceGenerator(name="taxiOrder_seq",sequenceName="taxiOrder_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="taxiOrder_seq")
    @Column(name="ORDER_ID")

    private Long id;
    private String Location1;
    private String Location2;
    private String note;
    private Long totalPrice;

    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Customer.class)
    @JoinColumn(name= "CUSTOMER_ID", insertable = true)
    private Customer customer;
    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = TaxiCarService.class)
    @JoinColumn(name= "CAR_ID", insertable = true)
    private TaxiCarService taxicarService;
    
    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = TaxiArea.class)
    @JoinColumn(name= "AREA_ID", insertable = true)
    private TaxiArea taxiArea;
    
    
}
