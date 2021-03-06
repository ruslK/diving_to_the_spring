package com.ticketsproject.servises;

import com.ticketsproject.dto.RoleDTO;

import java.util.List;

public interface RoleService {

    List<RoleDTO> listAllRoles();

    RoleDTO findById(long id);

}
