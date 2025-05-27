package com.medsync.auth_service.dtoService;

import com.medsync.auth_service.dto.AccountDto;
import com.medsync.auth_service.dto.AuthResponseDto;
import com.medsync.auth_service.dto.LoginDto;
import com.medsync.auth_service.dto.RegisterDto;

import java.util.List;

public interface AccountDtoService {
    AuthResponseDto createAccount(RegisterDto registerDto);
    AuthResponseDto loginAccount(LoginDto loginDto);
    AccountDto getAccount(String userId);
    List<AccountDto> getAllAccount();
    void updateAccountEmail(long id, String email);
    void updateAccountPassword(long id, String password);
    void deleteAccount(long id);
    void addRoleToUser(String userId, String roleName);
}
