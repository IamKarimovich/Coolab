package com.coolab.demo.business.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserByIdResponse {
    private String name;

    private String surname;

    private String email;

    private String password;

    private String userRole;
}
