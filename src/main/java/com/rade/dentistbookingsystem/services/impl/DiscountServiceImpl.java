package com.rade.dentistbookingsystem.services.impl;

import com.rade.dentistbookingsystem.repository.DiscountRepo;
import com.rade.dentistbookingsystem.services.DiscountService;

public class DiscountServiceImpl implements DiscountService {
    DiscountRepo discountRepo;

    public DiscountServiceImpl(DiscountRepo discountRepo) {
        this.discountRepo = discountRepo;
    }
}
