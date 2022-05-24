package com.rade.dentistbookingsystem.services.impl;

import com.rade.dentistbookingsystem.repository.ProvinceRepo;
import com.rade.dentistbookingsystem.services.ProvinceService;

public class ProvinceServiceImpl implements ProvinceService {
    ProvinceRepo provinceRepo;

    public ProvinceServiceImpl(ProvinceRepo provinceRepo) {
        this.provinceRepo = provinceRepo;
    }
}
