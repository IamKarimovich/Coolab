package com.coolab.demo.business.response;

import com.coolab.demo.constants.EventTypeEnum;
import com.coolab.demo.constants.StatusType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllEventsResponse {

    private int id;

    private String name;

    private String description;

    private EventTypeEnum eventType;

    private String dateTime;

    private String link;
    private StatusType status;

//    private byte[] image;

}
