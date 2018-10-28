package sut.sa.g04.entity;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tb_postalamount")
public class PostalAmount {
    @Id
    @SequenceGenerator(name="postalamount_seq",sequenceName="postalamount_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="postalamount_seq")
    @Column(name="POSTALAMOUNT_ID")
    private Long amountId;
    private String box;
    private int min;
    private int max;
}
