package com.coolab.demo.business.response;

import com.coolab.demo.common.EventTypeEnum;
import com.coolab.demo.common.StatusType;
import com.coolab.demo.common.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUsersResponse {
    private String name;

    private String surname;

    private String email;

    private String password;

    private UserType userRole;
}
