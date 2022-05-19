package com.rade.dentistbookingsystem.services.impl;

import com.rade.dentistbookingsystem.repository.ServiceRepo;
import com.rade.dentistbookingsystem.services.ServiceSv;

public class ServiceSvImpl implements ServiceSv {
    ServiceRepo serviceRepo;

    public ServiceSvImpl(ServiceRepo serviceRepo) {
        this.serviceRepo = serviceRepo;
    }
}
