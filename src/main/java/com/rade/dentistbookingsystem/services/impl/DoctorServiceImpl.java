package com.rade.dentistbookingsystem.services.impl;

import com.rade.dentistbookingsystem.domain.Doctor;
import com.rade.dentistbookingsystem.repository.DoctorRepo;
import com.rade.dentistbookingsystem.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    DoctorRepo doctorRepo;

    public DoctorServiceImpl(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    @Override
    public <S extends Doctor> S save(S entity) {
        return doctorRepo.save(entity);
    }

    @Override
    public boolean existsById(Integer integer) {
        return doctorRepo.existsById(integer);
    }

    @Override
    public Optional<Doctor> findById(Integer integer) {
        return doctorRepo.findById(integer);
    }

}
