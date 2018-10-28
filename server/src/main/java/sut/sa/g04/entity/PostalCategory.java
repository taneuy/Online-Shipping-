package sut.sa.g04.entity;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tb_postalcategory")

public class PostalCategory {
    @Id
    @SequenceGenerator(name="category_seq",sequenceName="category_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="category_seq")
    @Column(name="POSTALCATEGORY_ID")
    private Long PostalCategoryId;
    private String category;
}
