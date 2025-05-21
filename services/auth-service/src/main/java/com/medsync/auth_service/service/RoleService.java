package com.medsync.auth_service.service;

import com.medsync.auth_service.entity.Role;

import java.util.List;

public interface RoleService {
    Long createRole(Role role);
    List<Role> getAllRole();
    void updateRole(Role role);
    void deleteRole(long id);
}
