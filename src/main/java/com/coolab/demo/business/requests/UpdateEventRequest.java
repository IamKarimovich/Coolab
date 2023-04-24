package com.coolab.demo.business.requests;

import com.coolab.demo.common.EventTypeEnum;
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



}
