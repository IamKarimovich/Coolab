package com.coolab.demo.dataAcces.abstracts;

import com.coolab.demo.entities.concretes.Seminar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeminarRepository extends JpaRepository<Seminar,Integer> {
}
