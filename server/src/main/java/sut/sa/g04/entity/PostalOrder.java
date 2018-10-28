package sut.sa.g04.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tb_postalorder")

public class PostalOrder {
    @Id
    @SequenceGenerator(name="postalorder_seq",sequenceName="postalorder_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="postalorder_seq")
    @Column(name="POSTALORDER_ID")
    private Long postalOrderId;
    @Temporal(TemporalType.DATE)
    private Date orderDate;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Customer.class)
    @JoinColumn(name = "CUSTOMER_ID", insertable = true)
    private Customer customerorder;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = PostalCategory.class)
    @JoinColumn(name = "POSTALCATEGORY_ID", insertable = true)
    private PostalCategory category;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = PostalAmount.class)
    @JoinColumn(name = "POSTALAMOUNT_ID", insertable = true)
    private PostalAmount amount;
   
}
