package com.webapp.banca.demo.dao.impl;

import com.webapp.banca.demo.dao.AccountDao;
import com.webapp.banca.demo.dao.repository.AccountRepository;
import com.webapp.banca.demo.model.entity.AccountEntity;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.adapter.rxjava.RxJava3Adapter;

@Service
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Maybe<AccountEntity> insert(AccountEntity accountEntity) {
        return RxJava3Adapter.monoToMaybe(this.accountRepository.insert(accountEntity));
    }

    @Override
    public Flowable<AccountEntity> findAll() {
        return RxJava3Adapter.fluxToFlowable(this.accountRepository.findAll());
    }

    @Override
    public Maybe<AccountEntity> findById(String accountId) {
        return RxJava3Adapter.monoToMaybe(this.accountRepository.findById(accountId));
    }
}
