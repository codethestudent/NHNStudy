package com.nhnacademy.edu.springboot.accountopenapi.controller;

import com.nhnacademy.edu.springboot.accountopenapi.domain.Account;
import com.nhnacademy.edu.springboot.accountopenapi.service.AccountClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountClientService accountClientService;

    @GetMapping
    public ResponseEntity<?> getAccounts() {
        return ResponseEntity.ok(accountClientService.getAccounts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAccount(@PathVariable Long id) {
        return ResponseEntity.ok(accountClientService.getAccount(id));
    }

    @PostMapping
    public String createAccount(@RequestBody Account account) {
        accountClientService.createAccount(account);
        return "ok";
    }

    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable Long id) {
        accountClientService.deleteAccount(id);
        return "ok";
    }
}
