package com.coolab.demo.entities.concretes;

import com.coolab.demo.common.EventTypeEnum;
import com.coolab.demo.common.StatusType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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

    @Column(name = "event_date")
    private String date;

    @Column(name = "link")
    private String link;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusType status;

    @Lob
    @Column(name = "image")
    private byte[] image;
}
