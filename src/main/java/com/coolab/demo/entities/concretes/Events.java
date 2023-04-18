package com.coolab.demo.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "Events")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Events {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "event_type")
    private String eventType;

    @Column(name = "image")
    private byte[] image;

}
