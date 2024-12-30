package com.webapp.banca.demo.dao;

import com.webapp.banca.demo.model.entity.AccountEntity;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;

public interface AccountDao {
    Maybe<AccountEntity> insert(AccountEntity account);
    Flowable<AccountEntity> findAll();
    Maybe<AccountEntity> findById(String accountId);
}
