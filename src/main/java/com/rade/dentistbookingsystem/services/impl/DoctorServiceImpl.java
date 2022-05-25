package com.rade.dentistbookingsystem.services.impl;

import com.rade.dentistbookingsystem.domain.Doctor;
import com.rade.dentistbookingsystem.repository.DoctorRepo;
import com.rade.dentistbookingsystem.services.DoctorService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {
    DoctorRepo doctorRepo;

    public DoctorServiceImpl(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    @Override
    public <S extends Doctor> List<S> findAll(Example<S> example, Sort sort) {
        return doctorRepo.findAll(example, sort);
    }

    @Override
    public Optional<Doctor> findById(Integer integer) {
        return doctorRepo.findById(integer);
    }

    @Override
    public Doctor getById(Integer integer) {
        return doctorRepo.getById(integer);
    }

    @Override
    public void deleteById(Integer integer) {
        doctorRepo.deleteById(integer);
    }

    @Override
    public <S extends Doctor> S save(S entity) {
        return doctorRepo.save(entity);
    }
}
