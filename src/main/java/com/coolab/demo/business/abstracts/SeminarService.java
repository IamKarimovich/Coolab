package com.coolab.demo.business.abstracts;

import com.coolab.demo.entities.concretes.Seminar;

import java.util.List;

public interface SeminarService {
    List<Seminar> getAllSeminars();
}
