package com.coolab.demo.api.controller;

import com.coolab.demo.business.abstracts.EventService;
import com.coolab.demo.entities.concretes.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events/")
public class EventsController {

    private EventService eventService;

    @Autowired
    public EventsController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping()
    public List<Events> getAllEvents()
    {
        return eventService.getEvents();
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addEvent(@RequestBody Events event)
    {
        eventService.addEvent(event);
    }



}
