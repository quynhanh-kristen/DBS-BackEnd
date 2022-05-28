package com.rade.dentistbookingsystem.services.impl;

import com.rade.dentistbookingsystem.domain.Role;
import com.rade.dentistbookingsystem.repository.RoleRepo;
import com.rade.dentistbookingsystem.services.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    RoleRepo roleRepo;

    public RoleServiceImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public <S extends Role> S save(S entity) {
        return roleRepo.save(entity);
    }
}
