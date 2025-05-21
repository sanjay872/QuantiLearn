package com.medsync.auth_service.service;


import com.medsync.auth_service.entity.Account;

import java.util.List;

public interface AccountService {
    Long createAccount(Account account);
    Account getAccount(long id);
    List<Account> getAllAccount();
    void updateAccountEmail(long id, String email);
    void updateAccountPassword(long id, String password);
    void deleteAccount(long id);
}
