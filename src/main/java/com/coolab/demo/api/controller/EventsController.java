package com.coolab.demo.api.controller;

import com.coolab.demo.business.abstracts.EventService;
import com.coolab.demo.business.requests.CreateEventRequest;
import com.coolab.demo.business.requests.UpdateEventRequest;
import com.coolab.demo.business.response.GetAllEventsResponse;
import com.coolab.demo.common.EventTypeEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/events/")
public class EventsController {

    private EventService eventService;

    @Autowired
    public EventsController(EventService eventService) {
        this.eventService = eventService;
    }


//    @PreAuthorize("hasRole(UserType.USER.name()) or hasRole(UserType.ADMIN.name())")
    @GetMapping("getevent/list")
    public List<GetAllEventsResponse> getAllEvents()
    {
        return eventService.getEvents();
    }

//    @PreAuthorize("hasRole(UserType.ADMIN.name())")
    @PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addEvent(
            @ModelAttribute  @Valid CreateEventRequest eventRequest
                         ) throws IOException {
        System.out.println("Error");
        eventService.addEvent(eventRequest);
    }

//    @PreAuthorize("hasRole(UserType.USER.name()) or hasRole(UserType.ADMIN.name())")
    @GetMapping("getimage/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable int id) {
        byte[] image = eventService.getImage(id);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
    }


//    @PreAuthorize("hasRole(UserType.ADMIN.name())")
    @PutMapping()
    @ResponseStatus(value = HttpStatus.OK)
    public void updateEvent(@RequestBody @Valid UpdateEventRequest updateEventRequest) throws IOException {
        eventService.updateImage(updateEventRequest);
    }

//    @PreAuthorize("hasRole(UserType.ADMIN.name())")
    @GetMapping("getentity/{id}")
    public GetAllEventsResponse getEvent(@PathVariable int id)
    {
        return eventService.getEvent(id);
    }

//    @PreAuthorize("hasRole(UserType.ADMIN.name())")
    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable int id)
    {
        eventService.deleteEvent(id);
    }


}
