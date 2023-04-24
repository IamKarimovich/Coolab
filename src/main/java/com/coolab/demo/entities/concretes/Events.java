package com.coolab.demo.entities.concretes;

import com.coolab.demo.common.EventTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
    private EventTypeEnum eventType;


    @Lob
    @Column(name = "image")
    private byte[] image;

}
