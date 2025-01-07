package com.webapp.banca.demo.expose.mapper;

import com.webapp.banca.demo.model.domain.Account;
import com.webapp.banca.demo.model.entity.AccountEntity;
import com.webapp.banca.demo.model.response.BalanceResponse;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public AccountEntity getAccountEntityInsertOfAccount(Account account) {
        return AccountEntity
                .builder()
                .id(account.getId())
                .number(account.getNumber())
                .productCode(account.getProductCode())
                .flagComision(account.getFlagComision())
                .maxOperation(account.getMaxOperation())
                .startDate(account.getStartDate().toString())
                .endDate(account.getEndDate().toString())
                .balance(account.getBalance())
                .currency(account.getCurrency())
                .active(account.getActive())
                .build();
    }

    public Account getAccountOfAccountEntity(AccountEntity accountEntity) {
        return Account.builder()
                .id(accountEntity.getId())
                .number(accountEntity.getNumber())
                .productCode(accountEntity.getProductCode())
                .flagComision(accountEntity.getFlagComision())
                .maxOperation(accountEntity.getMaxOperation())
                .startDate(accountEntity.getStartDate())
                .endDate(accountEntity.getEndDate())
                .balance(accountEntity.getBalance())
                .currency(accountEntity.getCurrency())
                .active(accountEntity.getActive())
                .build();
    }

    public BalanceResponse getBalanceAccountOfAccountEntity(AccountEntity accountEntity) {
        return BalanceResponse.builder()
                .clientId(accountEntity.getId())
                .accountBalance(accountEntity.getBalance())
                .build();
    }

}