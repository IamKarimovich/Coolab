package com.coolab.demo.dataAcces.abstracts;

import com.coolab.demo.entities.concretes.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Integer> {


    @Transactional
    @Modifying
    @Query("delete from UserRole u where u.userId = ?1")
    public void deleteByUserId(int id);

}
