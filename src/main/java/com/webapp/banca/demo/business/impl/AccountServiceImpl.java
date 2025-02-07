package com.webapp.banca.demo.business.impl;

import com.webapp.banca.demo.business.AccountService;
import com.webapp.banca.demo.dao.AccountDao;
import com.webapp.banca.demo.expose.mapper.AccountMapper;
import com.webapp.banca.demo.model.domain.Account;
import com.webapp.banca.demo.model.entity.AccountEntity;
import com.webapp.banca.demo.model.response.BalanceResponse;
import com.webapp.banca.demo.model.response.TransactionResponse;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;

@Service
public class AccountServiceImpl implements AccountService {
    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Maybe<Account> insert(Account account) {
        logger.info("Processing service insert()");
        return this.accountDao.insert(this.accountMapper.getAccountEntityInsertOfAccount(account))
                .map(this.accountMapper::getAccountOfAccountEntity);
    }

    @Override
    public Maybe<Account> findById(String accountId) {
        logger.info("Processing service findById()");
        return this.accountDao.findById(accountId)
                .map(this.accountMapper::getAccountOfAccountEntity);
    }

    @Override
    public Maybe<BalanceResponse> getBalanceByIdAccount(String accountId) {
        logger.info("Processing service getBalanceByIdAccount()");
        return this.accountDao.findById(accountId)
                .map(this.accountMapper::getBalanceAccountOfAccountEntity);
    }

    @Override
    public Flowable<Account> findAll() {
        logger.info("Processing service findAll()");
        return this.accountDao.findAll()
                .map(this.accountMapper::getAccountOfAccountEntity);
    }

    @Override
    public Maybe<TransactionResponse> withdraw(String accountId, BigDecimal amount) {
        logger.info("Processing service withdraw()");
        Maybe<AccountEntity> maybeResponse = this.accountDao.findById(accountId);

        return maybeResponse
                .map(accEntity -> {
                    // Restar el valor
                    BigDecimal updatedAmount = accEntity.getBalance().subtract(amount);
                    accEntity.setBalance(updatedAmount);
                    return accEntity; // Retornar la AccountEntity actualizada
                })
                .map(this.accountMapper::getTransactionResponseOfAccountWithdrawal)
                .map(txResponse -> {
                    Arrays.stream(txResponse.getTransactions()).findFirst().get().setAmount(amount);
                    return txResponse; // Retornar la TransactionResponse actualizada
                });

    }

    @Override
    public Maybe<TransactionResponse> deposit(String accountId, BigDecimal amount) {
        logger.info("Processing service deposit()");
        Maybe<AccountEntity> maybeResponse = this.accountDao.findById(accountId);

        return maybeResponse
                .map(accEntity -> {
                    // Restar el valor
                    BigDecimal updatedAmount = accEntity.getBalance().add(amount);
                    accEntity.setBalance(updatedAmount);
                    return accEntity; // Retornar la AccountEntity actualizada
                })
                .map(this.accountMapper::getTransactionResponseOfAccountDeposit)
                .map(txResponse -> {
                    Arrays.stream(txResponse.getTransactions()).findFirst().get().setAmount(amount);
                    return txResponse; // Retornar la TransactionResponse actualizada
                });
    }


}
