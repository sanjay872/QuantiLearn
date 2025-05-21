package com.medsync.auth_service.controller;

import com.medsync.auth_service.dto.AccountDto;
import com.medsync.auth_service.dtoService.AccountDtoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    private final AccountDtoService accountDtoService;

    public AuthController(AccountDtoService accountDtoService){
        this.accountDtoService=accountDtoService;
    }

    @PostMapping
    public ResponseEntity<Long> createAccount(AccountDto accountDto){
        return new ResponseEntity<>(accountDtoService.createAccount(accountDto), HttpStatus.CREATED);
    }
}
