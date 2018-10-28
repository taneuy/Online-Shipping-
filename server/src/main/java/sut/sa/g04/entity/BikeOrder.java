package sut.sa.g04.entity;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tb_bikeOrder")
public class BikeOrder {
    @Id
    @SequenceGenerator(name="bikeOrder_seq",sequenceName="bikeOrder_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bikeOrder_seq")
    @Column(name="ORDER_ID")
    private Long orderId;
    private String pickLocation;
    private String dropLocation;
    private Long totalPrice;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Customer.class)
    @JoinColumn(name = "CUSTOMER_ID", insertable = true)
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = BikeArea.class)
    @JoinColumn(name = "AREA_ID", insertable = true)
    private BikeArea bikeArea;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = BikePayment.class)
    @JoinColumn(name = "PAYMENT_ID", insertable = true)
    private BikePayment bikePayment;
}
