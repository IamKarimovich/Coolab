package com.coolab.demo.api.controller;

import com.coolab.demo.business.abstracts.EventService;
import com.coolab.demo.entities.concretes.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/events/")
public class EventsController {

    private EventService eventService;

    @Autowired
    public EventsController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("getevents")
    public List<Events> getAllEvents()
    {
        return eventService.getEvents();
    }


}
