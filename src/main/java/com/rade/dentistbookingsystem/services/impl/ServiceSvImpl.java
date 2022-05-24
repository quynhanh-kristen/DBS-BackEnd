package com.rade.dentistbookingsystem.services.impl;

import com.rade.dentistbookingsystem.domain.Service;
import com.rade.dentistbookingsystem.repository.ServiceRepo;
import com.rade.dentistbookingsystem.services.ServiceSv;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;

import java.util.List;

public class ServiceSvImpl implements ServiceSv {
    ServiceRepo serviceRepo;

    public ServiceSvImpl(ServiceRepo serviceRepo) {
        this.serviceRepo = serviceRepo;
    }

    @Override
    public <S extends Service> List<S> findAll(Example<S> example) {
        return serviceRepo.findAll(example);
    }

    @Override
    public <S extends Service> List<S> findAll(Example<S> example, Sort sort) {
        return serviceRepo.findAll(example, sort);
    }
}
