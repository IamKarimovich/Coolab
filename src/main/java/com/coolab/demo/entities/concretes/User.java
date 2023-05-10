package com.coolab.demo.entities.concretes;


import com.coolab.demo.common.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "users")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "f_name",nullable = false)
    private String name;
    @Column(name = "l_name",nullable = false)
    private String surname;

    @Column(name = "email",unique = true,nullable = false)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private UserType role;

    public static class Builder {


        private User user;



        public Builder() {
            user = new User();
        }

        public Builder withUsername(String username) {
            user.email = username;
            return this;
        }

        public Builder withFirstName(String firstName) {
            user.name = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            user.surname = lastName;
            return this;
        }



        public User build() {
            return user;
        }
    }


}
