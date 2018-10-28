package sut.sa.g04.entity;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tb_convenienceProduct")
public class ConvenienceProduct {
    @Id
    @SequenceGenerator(name="convenienceProduct_seq",sequenceName="convenienceProduct_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="convenienceProduct_seq")
    @Column(name="PRODUCT_ID")
    private Long productId;
    private String productName;
}
