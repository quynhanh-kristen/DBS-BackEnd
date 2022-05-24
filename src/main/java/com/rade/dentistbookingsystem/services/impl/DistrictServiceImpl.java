package com.rade.dentistbookingsystem.services.impl;

import com.rade.dentistbookingsystem.repository.DistrictRepo;
import com.rade.dentistbookingsystem.services.DistrictService;

public class DistrictServiceImpl implements DistrictService {
    DistrictRepo districtRepo;

    public DistrictServiceImpl(DistrictRepo districtRepo) {
        this.districtRepo = districtRepo;
    }
}
