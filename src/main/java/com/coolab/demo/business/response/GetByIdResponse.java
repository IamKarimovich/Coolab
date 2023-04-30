package com.coolab.demo.business.response;

import com.coolab.demo.common.EventTypeEnum;
import com.coolab.demo.common.StatusType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdResponse {


    private String description;

    private EventTypeEnum eventType;

    private MultipartFile image;

    private String date;

    private String link;

    private StatusType status;

}
