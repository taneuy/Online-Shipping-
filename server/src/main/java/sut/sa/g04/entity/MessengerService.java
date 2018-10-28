package sut.sa.g04.entity;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tb_messengerService")
public class MessengerService {
    @Id
    @SequenceGenerator(name="messengerService_seq",sequenceName="messengerService_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="messengerService_seq")
    @Column(name="SERVICE_ID")
    private @NonNull Long serviceId;
    private @NonNull String serviceType;
    private @NonNull Long servicePrice;
}
