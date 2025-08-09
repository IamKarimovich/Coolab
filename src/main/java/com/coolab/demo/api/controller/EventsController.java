package com.coolab.demo.api.controller;

import com.coolab.demo.business.abstracts.EventsService;
import com.coolab.demo.business.requests.CreateEventRequest;
import com.coolab.demo.business.requests.UpdateEventRequest;
import com.coolab.demo.business.response.GetAllEventsResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/events/")
public class EventsController {

    private EventsService eventsService;

    @Autowired
    public EventsController(EventsService eventsService) {
        this.eventsService = eventsService;
    }


//    @PreAuthorize("hasRole(UserType.USER.name()) or hasRole(UserType.ADMIN.name())")
    @GetMapping("/")
    public List<GetAllEventsResponse> getAllEvents()
    {
        return eventsService.getEvents();
    }

//    @PreAuthorize("hasRole(UserType.ADMIN.name())")
    @PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE },value = "/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addEvent(
            @ModelAttribute  @Valid CreateEventRequest eventRequest
                         ) throws IOException {
        System.out.println("Error");
        eventsService.addEvent(eventRequest);
    }



//    @PreAuthorize("hasRole(UserType.USER.name()) or hasRole(UserType.ADMIN.name())")
    @RequestMapping(value="/{id}/image/", method = RequestMethod.GET,produces="image/jpeg")
    public byte[] getImage(@PathVariable int id) {
        return eventsService.getImage(id);
    }


//    @PreAuthorize("hasRole(UserType.ADMIN.name())")
    @PutMapping()
    @ResponseStatus(value = HttpStatus.OK)
    public void updateEvent(@RequestBody @Valid UpdateEventRequest updateEventRequest) throws IOException {
        eventsService.updateImage(updateEventRequest);
    }

//    @PreAuthorize("hasRole(UserType.ADMIN.name())")
    @GetMapping("/{id}/")
    public GetAllEventsResponse getEvent(@PathVariable int id)
    {
        return eventsService.getEvent(id);
    }

//    @PreAuthorize("hasRole(UserType.ADMIN.name())")
    @DeleteMapping("/{id}/")
    public void deleteUser(@PathVariable int id)
    {
        eventsService.deleteEvent(id);
    }


}
