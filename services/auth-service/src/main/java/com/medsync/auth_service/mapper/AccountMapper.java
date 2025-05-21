package com.medsync.auth_service.mapper;

import com.medsync.auth_service.dto.AccountDto;
import com.medsync.auth_service.entity.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    Account fromDto(AccountDto accountDto);
    AccountDto toDto(Account account);
}
