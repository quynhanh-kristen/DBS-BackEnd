package com.rade.dentistbookingsystem.repository;

import com.rade.dentistbookingsystem.domain.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepo extends JpaRepository<Discount, Integer> {
}
