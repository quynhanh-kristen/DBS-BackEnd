package com.rade.dentistbookingsystem.services;

import com.rade.dentistbookingsystem.domain.Role;

public interface RoleService  {
    <S extends Role> S save(S entity);
}
