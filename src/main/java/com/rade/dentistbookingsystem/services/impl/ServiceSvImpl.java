package com.rade.dentistbookingsystem.services.impl;

import com.rade.dentistbookingsystem.domain.Service;
import com.rade.dentistbookingsystem.domain.ServiceType;
import com.rade.dentistbookingsystem.repository.ServiceRepo;
import com.rade.dentistbookingsystem.services.ServiceSv;

import java.util.List;
@org.springframework.stereotype.Service
public class ServiceSvImpl implements ServiceSv {
    ServiceRepo serviceRepo;

    public ServiceSvImpl(ServiceRepo serviceRepo) {
        this.serviceRepo = serviceRepo;
    }

    @Override
    public List<Service> findByServiceType(ServiceType serviceType) {
        return serviceRepo.findByServiceType(serviceType);
    }

    public List<Service> findByServiceTypeId(int id) {
        return serviceRepo.findByServiceTypeId(id);
    }
}
