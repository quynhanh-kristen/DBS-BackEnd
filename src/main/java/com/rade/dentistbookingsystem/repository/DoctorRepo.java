package com.rade.dentistbookingsystem.repository;

import com.rade.dentistbookingsystem.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepo extends JpaRepository<Doctor, Integer> {
}
