package com.coolab.demo.api.controller;

import com.coolab.demo.business.abstracts.SeminarService;
import com.coolab.demo.entities.concretes.Seminar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/seminars/")
public class SeminarController {


    private SeminarService seminarService;

    @Autowired
    public SeminarController(SeminarService seminarService) {
        this.seminarService = seminarService;
    }

    @GetMapping("getall")
    List<Seminar> getAllSeminars()
    {
        return seminarService.getAllSeminars();
    }



}
