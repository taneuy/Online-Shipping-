package sut.sa.g04.entity;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tb_messengerOrder")
public class MessengerOrder {
    @Id
    @SequenceGenerator(name="messengerOrder_seq",sequenceName="messengerOrder_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="messengerOrder_seq")
    @Column(name="ORDER_ID")
    private @NonNull Long orderId;
    private @NonNull String receiverName;
    private @NonNull String receiverPhone;
    private @NonNull String receiverAddress;
    private String note;
    private @NonNull Long totalPrice;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Customer.class)
    @JoinColumn(name = "CUSTOMER_ID", insertable = true)
    private Customer paidCustomer;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = MessengerService.class)
    @JoinColumn(name = "SERVICE_ID", insertable = true)
    private MessengerService paidService;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = MessengerArea.class)
    @JoinColumn(name = "AREA_ID", insertable = true)
    private MessengerArea paidArea;
}
