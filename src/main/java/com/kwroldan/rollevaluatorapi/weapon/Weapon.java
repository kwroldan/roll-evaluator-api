package com.kwroldan.rollevaluatorapi.weapon;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

import lombok.Data;

@Entity
@Data
@Table(name = "weapons")
public class Weapon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "first_trait1")
    private String firstTrait1;

    @Column(name = "first_trait2")
    private String firstTrait2;

    @Column(name = "first_trait3")
    private String firstTrait3;

    @Column(name = "first_trait4")
    private String firstTrait4;

    @Column(name = "first_trait5")
    private String firstTrait5;

    @Column(name = "first_trait6")
    private String firstTrait6;

    @Column(name = "second_trait1")
    private String secondTrait1;

    @Column(name = "second_trait2")
    private String secondTrait2;

    @Column(name = "second_trait3")
    private String secondTrait3;

    @Column(name = "second_trait4")
    private String secondTrait4;

    @Column(name = "second_trait5")
    private String secondTrait5;

    @Column(name = "second_trait6")
    private String secondTrait6;

    @Column(name = "preferred_combo")
    private String preferredCombo;

    // @Column(name = "combo_description", columnDefinition = "text")
    // private String comboDescription;

}