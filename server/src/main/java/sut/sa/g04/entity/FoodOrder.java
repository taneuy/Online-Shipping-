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
@Table(name="tb_foodOrder")

public class FoodOrder {

    @Id

    @SequenceGenerator(name="foodOrder_seq",sequenceName="foodOrder_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="foodOrder_seq")
    @Column(name="ORDER_ID",unique = true, nullable = true)
    private Long orderId;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Customer.class)
    @JoinColumn(name = "CUSTOMER_ID", insertable = true)
    private  Customer adder;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @Column(name = "LISTMENU_ID")
    private Collection<FoodBasket> ListMenu;

}

