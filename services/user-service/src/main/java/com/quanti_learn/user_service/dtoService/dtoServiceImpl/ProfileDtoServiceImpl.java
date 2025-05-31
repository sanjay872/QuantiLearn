package com.quanti_learn.user_service.dtoService.dtoServiceImpl;

import com.quanti_learn.user_service.dto.ProfileDto;
import com.quanti_learn.user_service.dtoService.ProfileDtoService;
import com.quanti_learn.user_service.mapper.ProfileMapper;
import com.quanti_learn.user_service.service.ProfileService;
import org.springframework.stereotype.Service;

@Service
public class ProfileDtoServiceImpl implements ProfileDtoService {

    private final ProfileMapper mapper;
    private final ProfileService service;

    public ProfileDtoServiceImpl(
        ProfileMapper profileMapper,
        ProfileService profileService
    ){
        this.mapper=profileMapper;
        this.service=profileService;
    }

    @Override
    public ProfileDto createProfile(ProfileDto profile) {
        return mapper.toDto(service.createProfile(mapper.fromDto(profile)));
    }

    @Override
    public ProfileDto getProfile(String userId) {
        return mapper.toDto(service.getProfile(userId));
    }

    @Override
    public void updateProfile(ProfileDto profile) {
        service.updateProfile(mapper.fromDto(profile));
    }

    @Override
    public void deleteProfile(String userId) {
        service.deleteProfile(userId);
    }
}
