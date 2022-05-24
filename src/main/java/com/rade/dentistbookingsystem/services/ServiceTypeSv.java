package com.rade.dentistbookingsystem.services;

import com.rade.dentistbookingsystem.domain.ServiceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ServiceTypeSv {

    long count();

    void deleteById(Integer id);

    List<ServiceType> findAll();

    Page<ServiceType> findAll(Pageable pageable);

    Optional<ServiceType> findById(Integer id);

    ServiceType getById(Integer id);

    <S extends ServiceType> S save(S entity);
}
