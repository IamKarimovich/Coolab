package com.coolab.demo.dataAcces.abstracts;

import com.coolab.demo.entities.concretes.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

    Role findRoleById(int id);

    @Query("select r from Role r where r.name = ?1")
    Role findRoleByName(String name);

}
