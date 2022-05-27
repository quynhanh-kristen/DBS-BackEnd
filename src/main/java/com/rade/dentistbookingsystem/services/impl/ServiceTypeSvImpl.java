package com.rade.dentistbookingsystem.services.impl;

import com.rade.dentistbookingsystem.domain.ServiceType;
import com.rade.dentistbookingsystem.repository.ServiceTypeRepo;
import com.rade.dentistbookingsystem.services.ServiceTypeSv;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceTypeSvImpl implements ServiceTypeSv {
    ServiceTypeRepo serviceTypeRepo;

    public ServiceTypeSvImpl(ServiceTypeRepo serviceTypeRepo) {
        this.serviceTypeRepo = serviceTypeRepo;
    }

    public List<ServiceType> findAll() {
        return serviceTypeRepo.findAll();
    }

    @Override
    public ServiceType findByName(String name) {
        return serviceTypeRepo.findByName(name);
    }

    public Page<ServiceType> findAll(Pageable pageable) {
        return serviceTypeRepo.findAll(pageable);
    }
    
    public ServiceType getById(Integer id) {
        return serviceTypeRepo.getById(id);
    }

    public <S extends ServiceType> S save(S entity) {
        return serviceTypeRepo.save(entity);
    }

    public Optional<ServiceType> findById(Integer id) {
        return serviceTypeRepo.findById(id);
    }

    public long count() {
        return serviceTypeRepo.count();
    }

    public void deleteById(Integer id) {
        serviceTypeRepo.deleteById(id);
    }
    
    
}
