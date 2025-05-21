package com.medsync.auth_service.mapper;

import com.medsync.auth_service.dto.AuthorityDto;
import com.medsync.auth_service.entity.Authority;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorityMapper {
    Authority fromDto(AuthorityDto authorityDto);
    AuthorityDto toDto(Authority authority);
}
