package com.rade.dentistbookingsystem.repository;

import com.rade.dentistbookingsystem.domain.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepo extends JpaRepository<Service, Integer> {
}
