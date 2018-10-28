package sut.sa.g04.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="tb_foodMenu")

public class FoodMenu {

    @Id

    @SequenceGenerator(name="foodMenu_seq",sequenceName="foodMenu_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="foodMenu_seq")
    @Column(name="foodMenu_ID")
    private   @NonNull Long foodMenuId;
    private   @NonNull String foodMenuName;
    private   @NonNull Long foodMenuPrice;

    private @NonNull String code;
    private @NonNull String url;

}
