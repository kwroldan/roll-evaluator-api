package com.kwroldan.rollevaluatorapi.trait;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

import lombok.Data;

@Entity
@Data
@Table(name = "traits")
public class Trait {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "pve_rating")
    private long pveRating;

    @Column(name = "pvp_rating")
    private long pvpRating;

}