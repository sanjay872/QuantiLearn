package com.medsync.auth_service.dtoService.dtoServiceImpl;

import com.medsync.auth_service.dto.AuthorityDto;
import com.medsync.auth_service.dtoService.AuthorityDtoService;
import com.medsync.auth_service.mapper.AuthorityMapper;
import com.medsync.auth_service.service.AuthorityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityDtoServiceImpl implements AuthorityDtoService {

    private final AuthorityMapper authorityMapper;
    private final AuthorityService authorityService;

    public AuthorityDtoServiceImpl(
            AuthorityMapper authorityMapper,
            AuthorityService authorityService){
        this.authorityMapper=authorityMapper;
        this.authorityService=authorityService;
    }

    @Override
    public Long createAuthority(AuthorityDto authorityDto) {
        return authorityService.createAuthority(authorityMapper.fromDto(authorityDto));
    }

    @Override
    public List<AuthorityDto> getAllAuthority() {
        return authorityService.getAllAuthority().stream().map(authorityMapper::toDto).toList();
    }

    @Override
    public void updateAuthority(AuthorityDto authorityDto) {
        authorityService.updateAuthority(authorityMapper.fromDto(authorityDto));
    }

    @Override
    public void deleteAuthority(long id) {
        authorityService.deleteAuthority(id);
    }
}
