package com.coolab.demo.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserRequest {

    @NotEmpty
    @NotNull
    @Email
    String login;

    @NotEmpty
    @NotNull
    String password;

}
