package com.coolab.demo.dataAcces.abstracts;

import com.coolab.demo.entities.concretes.AboutUsText;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutTextRepository extends JpaRepository<AboutUsText,Integer> {


}
