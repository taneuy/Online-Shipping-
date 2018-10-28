package sut.sa.g04.entity;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tb_messengerArea")
public class MessengerArea {
    @Id
    @SequenceGenerator(name="messengerArea_seq",sequenceName="messengerArea_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="messengerArea_seq")
    @Column(name="AREA_ID")
    private @NonNull Long areaId;
    private @NonNull String areaType;
    private @NonNull Long areaPrice;
}
