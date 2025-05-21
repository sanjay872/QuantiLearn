package com.medsync.auth_service.dtoService.dtoServiceImpl;

import com.medsync.auth_service.dto.AccountDto;
import com.medsync.auth_service.dtoService.AccountDtoService;
import com.medsync.auth_service.mapper.AccountMapper;
import com.medsync.auth_service.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountDtoServiceImpl implements AccountDtoService {

    private final AccountMapper accountMapper;
    private final AccountService accountService;

    public AccountDtoServiceImpl(
            AccountMapper accountMapper,
            AccountService accountService){
        this.accountMapper=accountMapper;
        this.accountService=accountService;
    }

    @Override
    public Long createAccount(AccountDto accountDto) {
        return accountService.createAccount(accountMapper.fromDto(accountDto));
    }

    @Override
    public AccountDto getAccount(long id) {
        return accountMapper.toDto(accountService.getAccount(id));
    }

    @Override
    public List<AccountDto> getAllAccount() {
        return accountService.getAllAccount().stream().map(accountMapper::toDto).toList();
    }

    @Override
    public void updateAccountEmail(long id, String email) {
        accountService.updateAccountEmail(id,email);
    }

    @Override
    public void updateAccountPassword(long id, String password) {
        accountService.updateAccountPassword(id,password);
    }

    @Override
    public void deleteAccount(long id) {
        accountService.deleteAccount(id);
    }
}
