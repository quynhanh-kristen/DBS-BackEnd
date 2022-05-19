package com.rade.dentistbookingsystem.services.impl;

import com.rade.dentistbookingsystem.repository.ServiceTypeRepo;
import com.rade.dentistbookingsystem.services.ServiceTypeSv;

public class ServiceTypeSvImpl implements ServiceTypeSv {
    ServiceTypeRepo serviceTypeRepo;

    public ServiceTypeSvImpl(ServiceTypeRepo serviceTypeRepo) {
        this.serviceTypeRepo = serviceTypeRepo;
    }
}
