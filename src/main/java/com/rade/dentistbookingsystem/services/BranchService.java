package com.rade.dentistbookingsystem.services;

import com.rade.dentistbookingsystem.domain.Branch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BranchService {

    long count();

    void deleteById(Integer id);

    boolean existsById(Integer id);

    List<Branch> findAll();

    Page<Branch> findAll(Pageable pageable);

    Optional<Branch> findById(Integer id);

    <S extends Branch> S save(S entity);
}
