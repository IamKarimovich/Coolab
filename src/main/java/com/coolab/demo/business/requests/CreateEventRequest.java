package com.coolab.demo.business.requests;

import com.coolab.demo.common.EventTypeEnum;
import com.coolab.demo.common.StatusType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEventRequest {

    private String name;

    private String description;

    private EventTypeEnum eventType;

    private MultipartFile image;

    private String date;

    private String link;

    private StatusType status;

}
