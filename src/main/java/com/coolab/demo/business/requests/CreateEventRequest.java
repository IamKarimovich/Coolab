package com.coolab.demo.business.requests;

import com.coolab.demo.common.EventTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEventRequest {

    private String name;

    private String description;

    private EventTypeEnum eventType;

    private MultipartFile image;


}
