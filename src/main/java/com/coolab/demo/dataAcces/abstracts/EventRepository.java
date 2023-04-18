package com.coolab.demo.dataAcces.abstracts;

import com.coolab.demo.entities.concretes.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Events,Integer> {
}
