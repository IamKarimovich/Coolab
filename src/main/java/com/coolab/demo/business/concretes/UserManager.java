package com.coolab.demo.business.concretes;

import com.coolab.demo.business.abstracts.UserService;
import com.coolab.demo.business.requests.CreateUserRequest;
import com.coolab.demo.business.requests.CreateUserRoleRequest;
import com.coolab.demo.business.requests.LoginUserRequest;
import com.coolab.demo.business.requests.UpdateUserRequest;
import com.coolab.demo.business.response.GetAllUsersResponse;
import com.coolab.demo.business.response.GetByIdResponse;
import com.coolab.demo.business.rules.UserBusinessRules;
import com.coolab.demo.common.UserType;
import com.coolab.demo.core.mappers.ModelMapperService;
import com.coolab.demo.dataAcces.abstracts.RoleRepository;
import com.coolab.demo.dataAcces.abstracts.UserRepository;
import com.coolab.demo.dataAcces.abstracts.UserRoleRepository;
import com.coolab.demo.entities.concretes.User;
import com.coolab.demo.entities.concretes.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserManager implements UserService {


    private UserRepository userRepository;
    private ModelMapperService modelMapperService;

    private UserRoleRepository userRoleRepository;

    private RoleRepository roleRepository;

    private UserBusinessRules userBusinessRules;

    private int lastId;

    @Autowired
    public UserManager(UserRepository userRepository, ModelMapperService modelMapperService, UserRoleRepository userRoleRepository, RoleRepository roleRepository, UserBusinessRules userBusinessRules) {
        this.userRepository = userRepository;
        this.modelMapperService = modelMapperService;
        this.userRoleRepository = userRoleRepository;
        this.roleRepository = roleRepository;
        this.userBusinessRules = userBusinessRules;
    }

    @Override
    public List<GetAllUsersResponse> getUsers() {


        List<User> users = userRepository.findAll();


        List<GetAllUsersResponse> usersResponses = users.stream().map(
                user -> this.modelMapperService.forResponse().map(user, GetAllUsersResponse.class)
        ).collect(Collectors.toList());


        return usersResponses;
    }

    @Override
    public GetByIdResponse getUserById(int id) {
        Optional<User> user = userRepository.findById(id);
        GetByIdResponse getByIdResponse = modelMapperService.forResponse().map(user,GetByIdResponse.class);
        return getByIdResponse;
    }

    @Override
    public void createUser(CreateUserRequest userRequest) {

        userBusinessRules.CheckIfEmailExists(userRequest.getEmail());

        userRequest.setRole(UserType.valueOf(userRequest.getRole().toString().toUpperCase()));
        User user = modelMapperService.forRequest().map(userRequest,User.class);
        userRepository.saveAndFlush(user);
        System.out.println(user.getId());

        lastId = user.getId();

        CreateUserRoleRequest userRequest1 = new CreateUserRoleRequest(lastId, roleRepository.findRoleByName(user.getRole().toString()).getId());
        UserRole userRole = modelMapperService.forRequest().map(userRequest1,UserRole.class);
        userRoleRepository.save(userRole);
        lastId = 0;
    }

    @Override
    public void updateUser(UpdateUserRequest userRequest) {
        userBusinessRules.checkIfUserExists(userRequest.getId());
        userBusinessRules.ifEqualsEmail(userRequest.getId(),userRequest.getEmail());
        User user = modelMapperService.forRequest().map(userRequest,User.class);
        userRepository.save(user);

    }

    @Override
    public GetAllUsersResponse loginUser(LoginUserRequest loginUserRequest) {
        userBusinessRules.checkUserLoginIsCorrect(loginUserRequest);
        User user = userRepository.findUserByEmail(loginUserRequest.getLogin());
        GetAllUsersResponse usersResponse = modelMapperService.forResponse().map(user, GetAllUsersResponse.class);
        System.out.println(usersResponse.getUserRole().toString());
        return usersResponse;
    }

    @Override
    public void deleteUser(int id){
        userBusinessRules.checkIfUserExists(id);
        userRoleRepository.deleteByUserId(id);
        userRepository.deleteById(id);
    }
}
