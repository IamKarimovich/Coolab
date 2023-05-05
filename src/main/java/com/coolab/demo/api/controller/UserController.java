package com.coolab.demo.api.controller;

import com.coolab.demo.business.abstracts.UserService;
import com.coolab.demo.business.requests.CreateUserRequest;
import com.coolab.demo.business.requests.LoginUserRequest;
import com.coolab.demo.business.requests.UpdateUserRequest;
import com.coolab.demo.business.response.GetAllUsersResponse;
import com.coolab.demo.business.response.GetByIdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @Secured("ROLE_ADMIN")
    @GetMapping("getuser/list")
    public List<GetAllUsersResponse> getUsersList()
    {
        return userService.getUsers();
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("getuser/{id}")
    public GetByIdResponse getUserById(@PathVariable int id)
    {
        return userService.getUserById(id);
    }

    @Secured("ROLE_USER")
    @PostMapping("signup")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createUser(@Valid @RequestBody CreateUserRequest userRequest)
    {
        userService.createUser(userRequest);
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @GetMapping("login")
    public GetAllUsersResponse loginUser(@Valid @RequestBody LoginUserRequest loginUserRequest)
    {
        return userService.loginUser(loginUserRequest);
    }

    @Secured({"ROLE_ADMIN","ROLE_USER"})
    @PutMapping("update")
    public void updateUser(@RequestBody @Valid UpdateUserRequest userRequest)
    {
        userService.updateUser(userRequest);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("deleteuser/{id}")
    public void deleteUser(@PathVariable int id)
    {
        userService.deleteUser(id);
    }
}
