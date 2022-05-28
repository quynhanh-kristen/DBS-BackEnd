package com.rade.dentistbookingsystem.services;

import com.rade.dentistbookingsystem.domain.Service;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ServiceSv {
    <S extends Service> List<S> findAll(Example<S> example);

    <S extends Service> List<S> findAll(Example<S> example, Sort sort);
}
