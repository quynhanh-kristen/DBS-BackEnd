package com.rade.dentistbookingsystem.services;

import com.rade.dentistbookingsystem.domain.Doctor;

import java.util.Optional;

public interface DoctorService {
    <S extends Doctor> S save(S entity);

    boolean existsById(Integer integer);

    Optional<Doctor> findById(Integer integer);
}
