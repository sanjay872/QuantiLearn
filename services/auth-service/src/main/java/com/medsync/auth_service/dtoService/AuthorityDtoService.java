package com.medsync.auth_service.dtoService;


import com.medsync.auth_service.dto.AuthorityDto;

import java.util.List;

public interface AuthorityDtoService {
    Long createAuthority(AuthorityDto authorityDto);
    List<AuthorityDto> getAllAuthority();
    void updateAuthority(AuthorityDto authorityDto);
    void deleteAuthority(long id);
}
