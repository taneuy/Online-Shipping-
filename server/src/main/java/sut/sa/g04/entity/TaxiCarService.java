package sut.sa.g04.entity;
import javax.persistence.Entity;
import javax.persistence.*;
import lombok.*;
//import java.util.*;
@Entity 
@Data
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="tb_taxi_carservice")
public class TaxiCarService {
    @Id 
    @SequenceGenerator(name="Car_seq",sequenceName="Car_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Car_seq")
    @Column(name="CAR_ID")
    private Long serviceId;
    private String carType;
    private Long carPrice;

}
