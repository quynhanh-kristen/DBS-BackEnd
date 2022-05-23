package com.rade.dentistbookingsystem.services.impl;

import com.rade.dentistbookingsystem.repository.DoctorRepo;

public class DoctorServiceImpl {
    DoctorRepo doctorRepo;

    public DoctorServiceImpl(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }
}
