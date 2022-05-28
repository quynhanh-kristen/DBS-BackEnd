package com.rade.dentistbookingsystem.repository;

import com.rade.dentistbookingsystem.domain.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceTypeRepo extends JpaRepository<ServiceType, Integer> {
}
