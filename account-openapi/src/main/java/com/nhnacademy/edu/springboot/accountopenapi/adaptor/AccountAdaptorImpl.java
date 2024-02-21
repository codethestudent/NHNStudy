package com.nhnacademy.edu.springboot.accountopenapi.adaptor;

import com.nhnacademy.edu.springboot.accountopenapi.config.AccountAdaptorProperties;
import com.nhnacademy.edu.springboot.accountopenapi.domain.Account;
import com.nhnacademy.edu.springboot.accountopenapi.domain.AccountAdaptor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class AccountAdaptorImpl implements AccountAdaptor {
    private final RestTemplate restTemplate;
    private final AccountAdaptorProperties accountAdaptorProperties;

    public AccountAdaptorImpl(RestTemplate restTemplate, AccountAdaptorProperties accountAdaptorProperties) {
        this.restTemplate = restTemplate;
        this.accountAdaptorProperties = accountAdaptorProperties;
    }

    @Override
    public List<Account> getAccounts() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<Account>> exchange = restTemplate.exchange(accountAdaptorProperties.getAddress() + "/accounts",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<List<Account>>() {
                });
        return exchange.getBody();
    }

    @Override
    public Account getAccount(Long id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Account> exchange = restTemplate.exchange(accountAdaptorProperties.getAddress() + "/accounts/" + id,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<Account>() {
                });
        return exchange.getBody();
    }

    @Override
    public void createAccount(Account account) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<Account> requestEntity = new HttpEntity<>(account, httpHeaders);
        restTemplate.exchange(accountAdaptorProperties.getAddress() + "/accounts",
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });
    }

    @Override
    public void deleteAccount(Long id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<Account> requestEntity = new HttpEntity<>(httpHeaders);
        restTemplate.exchange(accountAdaptorProperties.getAddress() + "/accounts/" + id,
                HttpMethod.DELETE,
                requestEntity,
                new ParameterizedTypeReference<Account>() {
                });
    }
}
