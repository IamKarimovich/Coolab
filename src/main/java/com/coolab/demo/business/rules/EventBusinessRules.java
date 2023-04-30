package com.coolab.demo.business.rules;

import com.coolab.demo.core.exceptions.BusinessExceptions;
import com.coolab.demo.dataAcces.abstracts.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventBusinessRules {

    private EventRepository eventRepository;

    @Autowired
    public EventBusinessRules(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void ifEventIsExists(int id)
    {
        if(!eventRepository.existsById(id))
        {
            throw new BusinessExceptions("Event is not exists!");
        }
    }


}
