package com.coolab.demo.business.response;

import com.coolab.demo.common.EventTypeEnum;
import com.coolab.demo.common.StatusType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

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
