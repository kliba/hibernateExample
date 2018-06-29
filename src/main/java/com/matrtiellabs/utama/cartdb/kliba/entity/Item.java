package com.matrtiellabs.utama.cartdb.kliba.entity;

import javax.persistence.*;

@Entity
@Table(name = "ITEM")
public class Item {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "kgPerPiece")
    private Integer kgPerPiece;

    @Column(name = "pricePerPiece")
    private Integer pricePerPiece;


}
