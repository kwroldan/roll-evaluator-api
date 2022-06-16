package com.kwroldan.rollevaluatorapi.key;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

import lombok.Data;

@Entity
@Data
@Table(name = "Key")
public class Key {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "key")
    private String key;

}