package com.coolab.demo.api.controller;

import com.coolab.demo.business.abstracts.UserService;
import com.coolab.demo.business.requests.CreateUserRequest;
import com.coolab.demo.business.requests.LoginUserRequest;
import com.coolab.demo.business.requests.UpdateUserRequest;
import com.coolab.demo.business.response.GetAllUsersResponse;
import com.coolab.demo.business.response.GetByIdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping()
    public List<GetAllUsersResponse> getUsersList()
    {
        return userService.getUsers();
    }

    @GetMapping("{id}")
    public GetByIdResponse getUserById(@PathVariable int id)
    {
        return userService.getUserById(id);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createUser(@Valid @RequestBody CreateUserRequest userRequest)
    {
        userService.createUser(userRequest);
    }

    @GetMapping
    public GetAllUsersResponse loginUser(@Valid @RequestBody LoginUserRequest loginUserRequest)
    {
        return userService.loginUser(loginUserRequest);
    }

    @PutMapping()
    public void updateUser(@RequestBody @Valid UpdateUserRequest userRequest)
    {
        userService.updateUser(userRequest);
    }

    @DeleteMapping("deleteuser/{id}")
    public void deleteUser(@PathVariable int id)
    {
        userService.deleteUser(id);
    }
}
