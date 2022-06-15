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

    @Column(name = "preferred_combo")
    private String preferredCombo;

    @Column(name = "combo_description", columnDefinition = "TEXT")
    private String comboDescription;

    @Column(name = "bungie_hash")
    private long bungieHash;

}