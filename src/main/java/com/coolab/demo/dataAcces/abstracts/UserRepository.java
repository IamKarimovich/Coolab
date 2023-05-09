package com.coolab.demo.dataAcces.abstracts;

import com.coolab.demo.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("select u from User u where u.email = ?1")
    Optional<User> findUserByEmail(String email);



    @Query("select (count(u) > 0) from User u where u.email = :email")
    boolean existsByEmail(@Param("email") String email);

    @Query("select (count(u) > 0) from User u where u.email = ?1 and u.password = ?2")
    boolean existsUserByEmailAndPassword(String email, String password);




}
