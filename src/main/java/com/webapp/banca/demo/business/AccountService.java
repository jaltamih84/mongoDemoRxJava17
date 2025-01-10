package com.webapp.banca.demo.business;

import com.webapp.banca.demo.model.domain.Account;
import com.webapp.banca.demo.model.response.BalanceResponse;
import com.webapp.banca.demo.model.response.TransactionResponse;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;

import java.math.BigDecimal;

public interface AccountService {

    Maybe<Account> insert(Account account);

    Maybe<Account> findById(String accountId);

    Maybe<BalanceResponse> getBalanceByIdAccount(String accountId);

    Flowable<Account> findAll();

    Maybe<TransactionResponse> withdraw(String accountId, BigDecimal amount);

    Maybe<TransactionResponse> deposit(String accountId, BigDecimal amount);

}
