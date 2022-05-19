package com.rade.dentistbookingsystem.services.impl;

import com.rade.dentistbookingsystem.repository.DoctorBranchRepo;

public class DoctorBranchServiceImpl {
    DoctorBranchRepo doctorBranchRepo;

    public DoctorBranchServiceImpl(DoctorBranchRepo doctorBranchRepo) {
        this.doctorBranchRepo = doctorBranchRepo;
    }
}
