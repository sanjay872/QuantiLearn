package com.medsync.auth_service.service.serviceImpl;

import com.medsync.auth_service.entity.Role;
import com.medsync.auth_service.exception.exceptions.CustomException;
import com.medsync.auth_service.repository.RoleRepository;
import com.medsync.auth_service.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository){
        this.roleRepository=roleRepository;
    }

    @Override
    public Long createRole(Role role) {
        return roleRepository.save(role).getId();
    }

    @Override
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

    @Override
    public void updateRole(Role role) {
        Optional<Role> existRoleOptional=roleRepository.findById(role.getId());
        if(existRoleOptional.isPresent()){
            roleRepository.save(role);
        }
        else{
            throw new CustomException("Role update failed!");
        }
    }

    @Override
    public void deleteRole(long id) {
        Optional<Role> existRoleOptional=roleRepository.findById(id);
        if(existRoleOptional.isPresent()){
            roleRepository.delete(existRoleOptional.get());
        }
        else{
            throw new CustomException("Role delete failed!");
        }
    }
}
