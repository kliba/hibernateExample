package com.matrtiellabs.utama.cartdb.kliba.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.*;

@Entity
@Table(name = "SETTINGS")
public class Settings {

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

    public Settings() {
    }


    public Settings(Integer vat, Integer weightLimit, Integer owPenaltyPerKG) {
        this.vat = vat;
        this.weightLimit = weightLimit;
        this.owPenaltyPerKG = owPenaltyPerKG;
    }

    public Integer getId() {
        return id;
    }


    public Integer getVat() {
        return vat;
    }

    public void setVat(Integer vat) {
        this.vat = vat;
    }

    public Integer getWeightLimit() {
        return weightLimit;
    }

    public void setWeightLimit(Integer weightLimit) {
        this.weightLimit = weightLimit;
    }

    public Integer getOwPenaltyPerKG() {
        return owPenaltyPerKG;
    }

    public void setOwPenaltyPerKG(Integer owPenaltyPerKG) {
        this.owPenaltyPerKG = owPenaltyPerKG;
    }

    @Override
    public String toString() {
        return "Settings{" +
                "id=" + id +
                ", vat=" + vat +
                ", weightLimit=" + weightLimit +
                ", owPenaltyPerKG=" + owPenaltyPerKG +
                '}';
    }
}
