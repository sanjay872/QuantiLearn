package com.medsync.auth_service.service.serviceImpl;

import com.medsync.auth_service.entity.Account;
import com.medsync.auth_service.exception.exceptions.CustomException;
import com.medsync.auth_service.exception.exceptions.CustomNotFoundException;
import com.medsync.auth_service.repository.AccountRepository;
import com.medsync.auth_service.service.AccountService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AccountServiceImpl(
                            AccountRepository accountRepository,
                            BCryptPasswordEncoder bCryptPasswordEncoder)
    {
        this.accountRepository=accountRepository;
        this.bCryptPasswordEncoder=bCryptPasswordEncoder;
    }

    @Override
    public Long createAccount(Account account) {
        return accountRepository.save(account).getId();
    }

    @Override
    public Account getAccount(long id) {
        Optional<Account> accountOptional=accountRepository.findById(id);
        if(accountOptional.isPresent()){
            return accountOptional.get();
        }
        throw new CustomNotFoundException("Account Not Found!");
    }

    @Override
    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    public void updateAccountEmail(long id, String email) {
        Optional<Account> existAccountOptional=accountRepository.findById(id);
        if(existAccountOptional.isPresent()){
            Account existAccount=existAccountOptional.get();
            existAccount.setEmail(email);
            accountRepository.save(existAccount);
        }
        else{
            throw new CustomException("Email update failed!");
        }
    }

    @Override
    public void updateAccountPassword(long id, String password) {
        Optional<Account> existAccountOptional=accountRepository.findById(id);
        if(existAccountOptional.isPresent()){
            Account existAccount=existAccountOptional.get();
            existAccount.setPassword(bCryptPasswordEncoder.encode(password));
            accountRepository.save(existAccount);
        }
        else{
            throw new CustomException("Password update failed!");
        }
    }

    @Override
    public void deleteAccount(long id) {
        Optional<Account> existAccountOptional=accountRepository.findById(id);
        if(existAccountOptional.isPresent()){
            accountRepository.delete(existAccountOptional.get());
        }
        else{
            throw new CustomException("Account deletion failed!");
        }
    }
}
