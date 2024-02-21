package com.nhnacademy.edu.springboot.accountopenapi.domain;

import java.util.List;

public interface AccountAdaptor {
    List<Account> getAccounts();

    Account getAccount(Long id);

    void createAccount(Account account);

    void deleteAccount(Long id);
}
