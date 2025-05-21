package com.medsync.auth_service.service.serviceImpl;

import com.medsync.auth_service.entity.Authority;
import com.medsync.auth_service.exception.exceptions.CustomException;
import com.medsync.auth_service.repository.AuthorityRepository;
import com.medsync.auth_service.service.AuthorityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    private final AuthorityRepository authorityRepository;

    public AuthorityServiceImpl(AuthorityRepository authorityRepository){
            this.authorityRepository=authorityRepository;
    }

    @Override
    public Long createAuthority(Authority authority) {
        return authorityRepository.save(authority).getId();
    }

    @Override
    public List<Authority> getAllAuthority() {
        return authorityRepository.findAll();
    }

    @Override
    public void updateAuthority(Authority authority) {
        Optional<Authority> authorityOptional=authorityRepository.findById(authority.getId());
        if(authorityOptional.isPresent()){
            authorityRepository.save(authority);
        }
        else{
            throw new CustomException("Authority update failed!");
        }
    }

    @Override
    public void deleteAuthority(long id) {
        Optional<Authority> authorityOptional=authorityRepository.findById(id);
        if(authorityOptional.isPresent()){
            authorityRepository.delete(authorityOptional.get());
        }
        else{
            throw new CustomException("Authority deletion failed!");
        }
    }
}
