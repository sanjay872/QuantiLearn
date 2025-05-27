package com.medsync.auth_service.service;

import com.medsync.auth_service.entity.Role;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface RoleService {
    Long createRole(Role role);
    List<Role> getAllRole();
    void updateRole(Role role);
    void addAuthoritiesToRole(String role, Set<String> authorities);
    void deleteRole(long id);
    Role getRoleByName(String name);

}
