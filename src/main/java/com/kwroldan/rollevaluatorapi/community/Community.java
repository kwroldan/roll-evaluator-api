package com.kwroldan.rollevaluatorapi.community;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

import lombok.Data;

@Entity
@Data
@Table(name = "Community")
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "first_trait")
    private String firstTrait;

    @Column(name = "second_trait")
    private String secondTrait;

    @Column(name = "comment", columnDefinition = "TEXT")
    private String comment;

}