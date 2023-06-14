package com.coolab.demo.api.controller;

import com.coolab.demo.business.abstracts.UserService;
import com.coolab.demo.business.requests.CreateUserRequest;
import com.coolab.demo.business.requests.LoginUserRequest;
import com.coolab.demo.business.requests.UpdateUserRequest;
import com.coolab.demo.business.response.GetAllUsersResponse;
import com.coolab.demo.business.response.GetByIdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/users/")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @PreAuthorize("hasRole(UserType.ADMIN.name())")
    @GetMapping("GET/user/list")
    public List<GetAllUsersResponse> getUsersList()
    {
        return userService.getUsers();
    }

//    @PreAuthorize("hasRole(UserType.ADMIN.name())")
    @GetMapping("GET/user/{id}")
    public GetByIdResponse getUserById(@PathVariable int id)
    {
        return userService.getUserById(id);
    }

//    @PreAuthorize("hasRole(UserType.USER.name())")
    @PostMapping("POST/user/registration")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void Registration(@Valid @RequestBody CreateUserRequest userRequest)
    {
        userService.createUser(userRequest);
    }

//    @PreAuthorize("hasRole(UserType.USER.name()) or hasRole(UserType.ADMIN.name())")
    @GetMapping("GET/login")
    public GetAllUsersResponse loginUser(@Valid @RequestBody LoginUserRequest loginUserRequest)
    {
        return userService.loginUser(loginUserRequest);
    }
//
//    @PreAuthorize("hasRole(UserType.USER.name()) or hasRole(UserType.ADMIN.name())")
    @PutMapping("PUT/user/update")
    public void updateUser(@RequestBody @Valid UpdateUserRequest userRequest)
    {
        userService.updateUser(userRequest);
    }

//    @PreAuthorize("hasRole(UserType.ADMIN.name())")
    @DeleteMapping("DELETE/user/{id}")
    public void deleteUser(@PathVariable int id)
    {
        userService.deleteUser(id);
    }
}
