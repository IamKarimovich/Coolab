package com.coolab.demo.business.requests;

import com.coolab.demo.common.UserType;
import com.coolab.demo.entities.concretes.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {

    private int id;

    private String name;

    private String surname;

    private String email;

    private String password;

    private UserType userRole;



}
