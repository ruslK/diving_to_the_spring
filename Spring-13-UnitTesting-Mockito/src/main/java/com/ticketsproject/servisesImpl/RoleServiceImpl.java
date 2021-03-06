package com.ticketsproject.servisesImpl;

import com.ticketsproject.dto.RoleDTO;
import com.ticketsproject.entities.Role;
import com.ticketsproject.mapper.MapperUtil;
import com.ticketsproject.repository.RoleRepository;
import com.ticketsproject.servises.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final MapperUtil mapper;

    public RoleServiceImpl(RoleRepository roleRepository, MapperUtil mapper) {
        this.roleRepository = roleRepository;
        this.mapper = mapper;
    }

    @Override
    public List<RoleDTO> listAllRoles() {
        List<Role> roles = roleRepository.findAll();
        return roles.stream().map(role -> mapper.convert(role, new RoleDTO())).collect(Collectors.toList());
    }

    @Override
    public RoleDTO findById(long id) {
        return mapper.convert(roleRepository.findById(id).get(), new RoleDTO());
    }
}
