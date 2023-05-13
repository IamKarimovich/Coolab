package com.coolab.demo.business.concretes;

import com.coolab.demo.business.abstracts.EventService;
import com.coolab.demo.business.requests.CreateEventRequest;
import com.coolab.demo.business.requests.UpdateEventRequest;
import com.coolab.demo.business.response.GetAllEventsResponse;
import com.coolab.demo.business.rules.EventBusinessRules;
import com.coolab.demo.common.StatusType;
import com.coolab.demo.core.mappers.ModelMapperService;
import com.coolab.demo.core.utilities.EventImageUtil;
import com.coolab.demo.dataAcces.abstracts.EventRepository;
import com.coolab.demo.entities.concretes.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventManager implements EventService {

    private EventRepository eventRepository;
    private ModelMapperService modelMapperService;

    private EventBusinessRules eventBusinessRules;


    @Autowired
    public EventManager(EventRepository eventRepository, ModelMapperService modelMapperService, EventBusinessRules eventBusinessRules) {
        this.eventRepository = eventRepository;
        this.modelMapperService = modelMapperService;
        this.eventBusinessRules = eventBusinessRules;
    }

    @Override
    public List<GetAllEventsResponse> getEvents() {

        List<Events> eventsList = eventRepository.findAll();

        List<GetAllEventsResponse> getAllEventsResponses = eventsList.stream().map(
                event -> modelMapperService.forResponse().map(event, GetAllEventsResponse.class)).collect(Collectors.toList());

        return getAllEventsResponses;
    }

    @Override
    public void addEvent(CreateEventRequest eventRequest) {



        Events event = modelMapperService.forRequest().map(eventRequest,Events.class);
        try {
            event.setImage(eventRequest.getImage().getBytes());
        } catch (IOException e) {
            System.out.println("error");
        }
        eventRepository.save(event);
    }

    @Override
    public byte[] getImage(int id){
        eventBusinessRules.ifEventIsExists(id);
        Optional<Events> imageData = eventRepository.findById(id);
        return EventImageUtil.decompressImage(imageData.get().getImage());
    }

    @Override
    public void updateImage(UpdateEventRequest updateEventRequest) throws IOException {
        eventBusinessRules.ifEventIsExists(updateEventRequest.getId());
        Events event = modelMapperService.forRequest().map(updateEventRequest,Events.class);
        event.setImage(EventImageUtil.compressImage(updateEventRequest.getImage().getBytes()));
        eventRepository.save(event);
    }

    @Override
    public GetAllEventsResponse getEvent(int id) {
        Events event = eventRepository.findById(id).orElseThrow();
        GetAllEventsResponse eventsResponse = this.modelMapperService.forResponse().map(event,GetAllEventsResponse.class);

        return eventsResponse;
    }

    @Override
    public void deleteEvent(int id) {
        eventBusinessRules.ifEventIsExists(id);
        eventRepository.deleteById(id);
    }
}
