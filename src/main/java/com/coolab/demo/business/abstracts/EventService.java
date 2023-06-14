package com.coolab.demo.business.abstracts;

import com.coolab.demo.business.requests.CreateEventRequest;
import com.coolab.demo.business.requests.UpdateEventRequest;
import com.coolab.demo.business.response.GetAllEventsResponse;

import java.io.IOException;
import java.util.List;

public interface EventService {

    List<GetAllEventsResponse> getEvents();

    void addEvent(CreateEventRequest eventRequest) throws IOException;


    byte[] getImage(int id);

    void updateImage(UpdateEventRequest updateEventRequest) throws IOException;

    GetAllEventsResponse getEvent(int id);

    void deleteEvent(int id);



}
