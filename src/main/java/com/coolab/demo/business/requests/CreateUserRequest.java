package com.coolab.demo.business.requests;

import com.coolab.demo.common.UserType;
import com.coolab.demo.entities.concretes.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {

    @NotNull
    @NotBlank
    @Size(min = 5)
    private String name;

    @NotNull
    @NotBlank
    @Size(min = 5)
    private String surname;

    @NotNull
    @NotBlank
    @Email
    private String email;

    @NotNull
    @NotBlank
    @Size(min = 8,message = "Password should be at least 8 character")
    private String password;


    private UserType role;
}
