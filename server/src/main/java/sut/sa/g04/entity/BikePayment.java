package sut.sa.g04.entity;

import lombok.*;


import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tb_bikePayment")
public class BikePayment {
    @Id
    @SequenceGenerator(name="bikePayment_seq",sequenceName="bikePayment_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bikePayment_seq")
    @Column(name="PAYMENT_ID")
    private @NonNull Long paymentId;
    private @NonNull String paymentType;
}