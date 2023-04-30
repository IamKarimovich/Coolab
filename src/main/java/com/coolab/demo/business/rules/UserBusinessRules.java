package com.coolab.demo.business.rules;

import com.coolab.demo.business.requests.LoginUserRequest;
import com.coolab.demo.core.exceptions.BusinessExceptions;
import com.coolab.demo.dataAcces.abstracts.UserRepository;
import com.coolab.demo.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserBusinessRules {
    private UserRepository userRepository;

    @Autowired
    public UserBusinessRules(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void CheckIfEmailExists(String email)
    {
        if(userRepository.existsByEmail(email))
        {
            throw new BusinessExceptions("Email address is already exists!");
        }
    }

    public boolean ifEqualsEmail(int id,String newEmail)
    {
        Optional<User> user = userRepository.findById(id);
        if (!user.get().getEmail().equals(newEmail))
            CheckIfEmailExists(newEmail);
        return true;
    }

    public void checkIfUserExists(int id)
    {
        if(!userRepository.existsById(id))
        {
            throw new BusinessExceptions("User does not exists!");
        }
    }

    public void checkUserLoginIsCorrect(LoginUserRequest loginUserRequest)
    {
        if(!userRepository.existsUserByEmailAndPassword(loginUserRequest.getLogin(), loginUserRequest.getPassword()))
        {
            throw new BusinessExceptions("Wrong email or password!");
        }
    }
}
