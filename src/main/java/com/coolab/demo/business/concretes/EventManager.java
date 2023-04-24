package com.coolab.demo.business.concretes;

import com.coolab.demo.business.abstracts.EventService;
import com.coolab.demo.business.requests.CreateEventRequest;
import com.coolab.demo.business.requests.UpdateEventRequest;
import com.coolab.demo.business.response.GetAllEventsResponse;
import com.coolab.demo.common.EventTypeEnum;
import com.coolab.demo.core.mappers.ModelMapperManager;
import com.coolab.demo.core.mappers.ModelMapperService;
import com.coolab.demo.core.utilities.EventImageUtil;
import com.coolab.demo.dataAcces.abstracts.EventRepository;
import com.coolab.demo.entities.concretes.Events;
import org.hibernate.event.internal.EventUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventManager implements EventService {

    private EventRepository eventRepository;
    private ModelMapperService modelMapperService;



    @Autowired
    public EventManager(EventRepository eventRepository, ModelMapperService modelMapperService) {
        this.eventRepository = eventRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public List<GetAllEventsResponse> getEvents() {

        List<Events> eventsList = eventRepository.findAll();

        List<GetAllEventsResponse> getAllEventsResponses = new ArrayList<>();

        for (Events event:eventsList) {
            GetAllEventsResponse getAllEventsResponse = new GetAllEventsResponse();

            getAllEventsResponse.setId(event.getId());
            getAllEventsResponse.setEventType(event.getEventType());
            getAllEventsResponse.setDescription(event.getDescription());
            getAllEventsResponse.setName(event.getName());
            getAllEventsResponses.add(getAllEventsResponse);

        }

        return getAllEventsResponses;
    }

    @Override
    public void addEvent(CreateEventRequest eventRequest) {
        Events event = new Events();;
        try {

            event.setEventType(eventRequest.getEventType());
            event.setDescription(eventRequest.getDescription());
            event.setName(eventRequest.getName());
            event.setImage(EventImageUtil.compressImage(eventRequest.getImage().getBytes()));
        } catch (IOException e) {
            System.out.println("Error");
        }
        eventRepository.save(event);
    }

    @Override
    public byte[] getImage(int id){
        Optional<Events> imageData = eventRepository.findById(id);

        return EventImageUtil.decompressImage(imageData.get().getImage());
    }

    @Override
    public void updateImage(UpdateEventRequest updateEventRequest) throws IOException {

        Events event = modelMapperService.forRequest().map(updateEventRequest,Events.class);
        event.setImage(EventImageUtil.compressImage(updateEventRequest.getImage().getBytes()));
        eventRepository.save(event);
    }
}
