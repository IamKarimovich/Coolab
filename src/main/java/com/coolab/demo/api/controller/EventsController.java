package com.coolab.demo.api.controller;

import com.coolab.demo.business.abstracts.EventService;
import com.coolab.demo.business.requests.CreateEventRequest;
import com.coolab.demo.business.requests.UpdateEventRequest;
import com.coolab.demo.business.response.GetAllEventsResponse;
import com.coolab.demo.common.EventTypeEnum;
import com.coolab.demo.entities.concretes.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/events/",consumes = MediaType.ALL_VALUE)
public class EventsController {

    private EventService eventService;

    @Autowired
    public EventsController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping()
    public List<GetAllEventsResponse> getAllEvents()
    {
        return eventService.getEvents();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.OK)
    public void addEvent(
            @RequestBody CreateEventRequest eventRequest
                         ) throws IOException {
        System.out.println("Error");
        eventService.addEvent(eventRequest);
    }

    @GetMapping("{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable int id) {
        byte[] image = eventService.getImage(id);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
    }


    @PutMapping()
    @ResponseStatus(value = HttpStatus.OK)
    public void updateImage(@RequestBody UpdateEventRequest updateEventRequest) throws IOException {
        eventService.updateImage(updateEventRequest);
    }


}
