package com.matrtiellabs.utama.cartdb.kliba.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.*;

@Entity
@Table(name = "SETTINGS")
public class Setting {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "vat")
    private Integer vat;

    @Column(name = "weightLimit")
    private Integer weightLimit;

    @Column(name = "owPenaltyPerKG")
    private Integer owPenaltyPerKG;
}
