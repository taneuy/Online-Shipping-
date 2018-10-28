package sut.sa.g04.entity;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tb_customer")
public class Customer {
    @Id
    @SequenceGenerator(name="customer_seq",sequenceName="customer_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="customer_seq")
    @Column(name="CUSTOMER_ID")
    private Long customerId;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String username;
    private String password;
}
