package com.coolab.demo.business.abstracts;

import com.coolab.demo.business.requests.CreateEventRequest;
import com.coolab.demo.business.requests.UpdateEventRequest;
import com.coolab.demo.business.response.GetAllEventsResponse;
import com.coolab.demo.common.EventTypeEnum;
import com.coolab.demo.core.utilities.EventImageUtil;
import com.coolab.demo.entities.concretes.Events;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface EventService {

    List<GetAllEventsResponse> getEvents();

    void addEvent(CreateEventRequest eventRequest) throws IOException;


    byte[] getImage(int id);

    void updateImage(UpdateEventRequest updateEventRequest) throws IOException;

    GetAllEventsResponse getEvent(int id);

    void deleteEvent(int id);



}
