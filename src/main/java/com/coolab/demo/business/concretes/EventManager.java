package com.coolab.demo.business.concretes;

import com.coolab.demo.business.abstracts.EventService;
import com.coolab.demo.dataAcces.abstracts.EventRepository;
import com.coolab.demo.entities.concretes.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventManager implements EventService {

    private EventRepository eventRepository;

    @Autowired
    public EventManager(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Events> getEvents() {
        return eventRepository.findAll();
    }




}
