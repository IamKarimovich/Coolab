package com.coolab.demo.business.requests;

import com.coolab.demo.constants.EventTypeEnum;
import com.coolab.demo.constants.StatusType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateEventRequest {


    private int id;

    @NotNull
    @NotBlank
    @Size(min = 5)
    private String name;

    @NotNull
    @NotBlank
    @Size(min = 5)
    private String description;

    @NotNull
    @NotBlank
    private EventTypeEnum eventType;

    private MultipartFile image;



    private String date;

    private String link;

    private StatusType status;


}
