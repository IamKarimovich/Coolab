package com.coolab.demo.business.response;

import com.coolab.demo.common.EventTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllEventsResponse {

    private int id;

    private String name;

    private String description;

    private EventTypeEnum eventType;


}
