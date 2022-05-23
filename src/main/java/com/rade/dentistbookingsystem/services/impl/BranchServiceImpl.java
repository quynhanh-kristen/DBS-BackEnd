package com.rade.dentistbookingsystem.services.impl;

import com.rade.dentistbookingsystem.repository.BranchRepo;
import com.rade.dentistbookingsystem.services.BranchService;

public class BranchServiceImpl implements BranchService {
    BranchRepo branchRepo;

    public BranchServiceImpl(BranchRepo branchRepo) {
        this.branchRepo = branchRepo;
    }
}
