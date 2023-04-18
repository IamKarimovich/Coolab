package com.coolab.demo.business.abstracts;

import com.coolab.demo.entities.concretes.Events;

import java.util.List;

public interface EventService {

    List<Events> getEvents();

    void addEvent(Events event);

}
