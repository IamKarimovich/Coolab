package com.coolab.demo.dataAcces.abstracts;

import com.coolab.demo.common.StatusType;
import com.coolab.demo.entities.concretes.Events;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Events,Integer> {


}
