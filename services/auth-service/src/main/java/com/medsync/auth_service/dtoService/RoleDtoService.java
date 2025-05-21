package com.medsync.auth_service.dtoService;

import com.medsync.auth_service.dto.RoleDto;

import java.util.List;

public interface RoleDtoService {
    Long createRole(RoleDto roleDto);
    List<RoleDto> getAllRole();
    void updateRole(RoleDto roleDto);
    void deleteRole(long id);
}
