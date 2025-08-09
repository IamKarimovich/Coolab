package com.coolab.demo.business.response;

import com.coolab.demo.constants.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
