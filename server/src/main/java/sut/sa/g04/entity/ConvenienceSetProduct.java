package sut.sa.g04.entity;

        import lombok.*;
        import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tb_convenienceSetProduct")
public class ConvenienceSetProduct {
    @Id
    @SequenceGenerator(name="convenienceSetProduct_seq",sequenceName="convenienceSetProduct_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="convenienceSetProduct_seq")
    @Column(name="SET_PRODUCT_ID")
    private Long setProductId;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = ConvenienceProduct.class)
    @JoinColumn(name = "PRODUCT_ID", insertable = true)
    private  ConvenienceProduct product;

    @Column(name="ORDER_ID")
    private Long orderId;
}
