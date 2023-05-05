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
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
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

    
    @GetMapping("getevent/list")
    public List<GetAllEventsResponse> getAllEvents()
    {
        return eventService.getEvents();
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addEvent(
            @RequestBody @Valid CreateEventRequest eventRequest
                         ) throws IOException {
        System.out.println("Error");
        eventService.addEvent(eventRequest);
    }

    @GetMapping("getimage/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable int id) {
        byte[] image = eventService.getImage(id);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
    }


    @PutMapping()
    @ResponseStatus(value = HttpStatus.OK)
    public void updateImage(@RequestBody @Valid UpdateEventRequest updateEventRequest) throws IOException {
        eventService.updateImage(updateEventRequest);
    }

    @GetMapping("getentity/{id}")
    public GetAllEventsResponse getEvent(@PathVariable int id)
    {
        return eventService.getEvent(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable int id)
    {
        eventService.deleteEvent(id);
    }


}
