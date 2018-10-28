package sut.sa.g04.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tb_convenienceOrder")
public class ConvenienceOrder {
    @Id
    @SequenceGenerator(name="convenienceOrder_seq",sequenceName="convenienceOrder_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="convenienceOrder_seq")
    @Column(name="ORDER_ID")
    private Long orderId;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Customer.class)
    @JoinColumn(name = "CUSTOMER_ID", insertable = true)
    private Customer adder;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Collection<ConvenienceSetProduct> listProduct;

}

