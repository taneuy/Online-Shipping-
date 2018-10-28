package sut.sa.g04.entity;

//package com.example.food.Entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="tb_foodBasket")

public class FoodBasket {

    @Id

    @SequenceGenerator(name="foodBasket_seq",sequenceName="foodBasket_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="foodBasket_seq")
    @Column(name="FOODBASKET_ID")
    private Long FoodBasketId;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = FoodMenu.class)
    @JoinColumn(name = "FOODMENU_ID", insertable = true)
    private  FoodMenu Foodmenu;

    @Column(name="ORDER_ID")
    private Long OrderID;

}
