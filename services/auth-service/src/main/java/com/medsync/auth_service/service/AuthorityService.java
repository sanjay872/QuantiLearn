package com.medsync.auth_service.service;


import com.medsync.auth_service.entity.Authority;

import java.util.List;

public interface AuthorityService {
    Long createAuthority(Authority authority);
    List<Authority> getAllAuthority();
    void updateAuthority(Authority authority);
    void deleteAuthority(long id);
}
