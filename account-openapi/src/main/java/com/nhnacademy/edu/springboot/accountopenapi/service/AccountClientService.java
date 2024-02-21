package com.nhnacademy.edu.springboot.accountopenapi.service;

import com.nhnacademy.edu.springboot.accountopenapi.domain.Account;
import com.nhnacademy.edu.springboot.accountopenapi.domain.AccountAdaptor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountClientService {
    private final AccountAdaptor accountAdaptor;

    public List<Account> getAccounts() {
        return accountAdaptor.getAccounts();
    }

    public Account getAccount(Long id) {
        return accountAdaptor.getAccount(id);
    }

    public void createAccount(Account account) {
        accountAdaptor.createAccount(account);
    }

    public void deleteAccount(Long id) {
        accountAdaptor.deleteAccount(id);
    }
}
