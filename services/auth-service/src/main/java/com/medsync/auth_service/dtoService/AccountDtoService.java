package com.medsync.auth_service.dtoService;

import com.medsync.auth_service.dto.AccountDto;

import java.util.List;

public interface AccountDtoService {
    Long createAccount(AccountDto accountDto);
    AccountDto getAccount(long id);
    List<AccountDto> getAllAccount();
    void updateAccountEmail(long id, String email);
    void updateAccountPassword(long id, String password);
    void deleteAccount(long id);
}
