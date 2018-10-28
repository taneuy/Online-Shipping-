package sut.sa.g04.entity;

import lombok.*;
import javax.persistence.*;


@Entity 
@Data
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="tb_taxi_area")
public class TaxiArea {
    @Id
    @SequenceGenerator(name="Area_seq",sequenceName="Area_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Area_seq")
    @Column(name="AREA_ID")
    private Long areaId;
    private String areaType;
    private Long  areaPrice;

}
