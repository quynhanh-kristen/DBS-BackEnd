package com.rade.dentistbookingsystem.services.impl;

import com.rade.dentistbookingsystem.domain.District;
import com.rade.dentistbookingsystem.repository.DistrictRepo;
import com.rade.dentistbookingsystem.services.DistrictService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DistrictServiceImpl implements DistrictService {
    DistrictRepo districtRepo;


    public DistrictServiceImpl(DistrictRepo districtRepo) {
        this.districtRepo = districtRepo;
    }
    @Override
    public District findById(Integer id) {
        return districtRepo.findById(id).get();
    }
}
