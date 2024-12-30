package com.webapp.banca.demo.business;

import com.webapp.banca.demo.model.domain.Account;
import com.webapp.banca.demo.model.response.BalanceResponse;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;

public interface AccountService {

    Maybe<Account> insert(Account account);

    Maybe<Account> findById(String accountId);

    Maybe<BalanceResponse> getBalanceByIdAccount(String accountId);

    Flowable<Account> findAll();
}
