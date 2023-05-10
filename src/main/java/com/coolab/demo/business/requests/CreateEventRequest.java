package com.coolab.demo.business.requests;

import com.coolab.demo.common.EventTypeEnum;
import com.coolab.demo.common.StatusType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEventRequest {

    @NotNull
    @NotBlank
    @Size(min = 5)
    private String name;

    @NotNull
    @NotBlank
    @Size(min = 5)
    private String description;


    private EventTypeEnum eventType;


    private MultipartFile image;

    @NotNull
    @NotBlank
    private String date;

    @NotNull
    @NotBlank
    private String link;


    private StatusType status;

}
