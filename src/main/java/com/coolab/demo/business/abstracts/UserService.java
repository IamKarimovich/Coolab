package com.coolab.demo.business.abstracts;

import com.coolab.demo.business.requests.CreateUserRequest;
import com.coolab.demo.business.requests.LoginUserRequest;
import com.coolab.demo.business.requests.UpdateUserRequest;
import com.coolab.demo.business.response.GetAllUsersResponse;
import com.coolab.demo.business.response.GetByIdResponse;
import com.coolab.demo.entities.concretes.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<GetAllUsersResponse> getUsers();

    GetByIdResponse getUserById(int id);

    void createUser(CreateUserRequest userRequest);

    void updateUser(UpdateUserRequest userRequest);

    void deleteUser(int id);

    GetAllUsersResponse loginUser(LoginUserRequest loginUserRequest);






}
