package com.example.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.AppMapper;
import com.example.model.TermModel;
import com.example.model.UserModel;
import com.example.model.LinkStudentKuriModel;
import com.example.model.JadwalModel;
import com.example.model.KelasModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AppServiceDatabase implements AppService
{
    @Autowired
    private AppMapper appMapper;



}