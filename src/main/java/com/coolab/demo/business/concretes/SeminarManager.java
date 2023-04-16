package com.coolab.demo.business.concretes;

import com.coolab.demo.business.abstracts.SeminarService;
import com.coolab.demo.dataAcces.abstracts.SeminarRepository;
import com.coolab.demo.entities.concretes.Seminar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeminarManager implements SeminarService {


    private SeminarRepository seminarRepository;

    @Autowired
    public SeminarManager(SeminarRepository seminarRepository) {
        this.seminarRepository = seminarRepository;
    }

    @Override
    public List<Seminar> getAllSeminars() {
        return seminarRepository.findAll();
    }
}
