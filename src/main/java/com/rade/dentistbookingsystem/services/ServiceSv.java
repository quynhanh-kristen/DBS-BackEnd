package com.rade.dentistbookingsystem.services;

import com.rade.dentistbookingsystem.domain.Service;
import com.rade.dentistbookingsystem.domain.ServiceType;

import java.util.List;

public interface ServiceSv {
    List<Service> findByServiceType(ServiceType serviceType);
    List<Service> findByServiceTypeId(int id);
}
