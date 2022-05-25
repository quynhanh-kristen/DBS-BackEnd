package com.rade.dentistbookingsystem.repository;

import com.rade.dentistbookingsystem.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountRepo extends JpaRepository<Account, Integer> {
    @Query(value = "SELECT * FROM Account  WHERE phone = ?1", nativeQuery = true)
    public Account getUserByPhone(@Param("phone") String phone);
}
