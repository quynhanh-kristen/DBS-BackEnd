package com.rade.dentistbookingsystem.services;

import com.rade.dentistbookingsystem.domain.Doctor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    <S extends Doctor> List<S> findAll(Example<S> example, Sort sort);

    Optional<Doctor> findById(Integer integer);

    Doctor getById(Integer integer);

    void deleteById(Integer integer);

    <S extends Doctor> S save(S entity);
}
