package sut.sa.g04.entity;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tb_bikeArea")
public class BikeArea {
    @Id
    @SequenceGenerator(name="bikeArea_seq",sequenceName="bikeArea_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bikeArea_seq")
    @Column(name="Area_ID")
    private @NonNull Long areaId;
    private @NonNull String areaType;
    private @NonNull Long areaPrice;
}
