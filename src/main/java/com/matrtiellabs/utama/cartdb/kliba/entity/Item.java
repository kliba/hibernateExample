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

    public Integer getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getKgPerPiece() {
        return kgPerPiece;
    }

    public void setKgPerPiece(Integer kgPerPiece) {
        this.kgPerPiece = kgPerPiece;
    }

    public Integer getPricePerPiece() {
        return pricePerPiece;
    }

    public void setPricePerPiece(Integer pricePerPiece) {
        this.pricePerPiece = pricePerPiece;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", kgPerPiece=" + kgPerPiece +
                ", pricePerPiece=" + pricePerPiece +
                '}';
    }
}
