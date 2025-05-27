package com.medsync.auth_service.dtoService;

import com.medsync.auth_service.dto.RoleDto;

import java.util.List;
import java.util.Set;

public interface RoleDtoService {
    Long createRole(RoleDto roleDto);
    List<RoleDto> getAllRole();
    void updateRole(RoleDto roleDto);
    void addAuthorityToRole(String role, Set<String> authorities);
    void deleteRole(long id);
    RoleDto getRoleByName(String name);
}
