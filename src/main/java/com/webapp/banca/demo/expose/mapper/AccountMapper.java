package com.webapp.banca.demo.expose.mapper;

import com.webapp.banca.demo.expose.util.Operation;
import com.webapp.banca.demo.expose.util.Utilitary;
import com.webapp.banca.demo.model.domain.Account;
import com.webapp.banca.demo.model.dto.Transaction;
import com.webapp.banca.demo.model.entity.AccountEntity;
import com.webapp.banca.demo.model.response.BalanceResponse;
import com.webapp.banca.demo.model.response.TransactionResponse;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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

    public TransactionResponse getTransactionResponseOfAccountWithdrawal(AccountEntity accountEntity) {
        Transaction tx = Transaction.builder()
                .clientId(accountEntity.getNumber())
                .type(Operation.WITHDRAWAL.getCode())
                .amount(BigDecimal.ZERO) //Este monto se debe actualizar con el monto del retiro
                .date(Utilitary.getStringFromDateFormat(new Date()))
                .description(Operation.WITHDRAWAL.getDescription())
                .build();
        Transaction[] arrayTx = {tx};
        return TransactionResponse.builder()
                .type(Operation.WITHDRAWAL.toString())
                .amountBalance(accountEntity.getBalance())
                .date(tx.getDate())
                .transactions(arrayTx)
                .build();
    }

    public TransactionResponse getTransactionResponseOfAccountDeposit(AccountEntity accountEntity) {
        Transaction tx = Transaction.builder()
                .clientId(accountEntity.getNumber())
                .type(Operation.DEPOSIT.getCode())
                .amount(BigDecimal.ZERO) //Este monto se debe actualizar con el monto del deposito
                .date(Utilitary.getStringFromDateFormat(new Date()))
                .description(Operation.DEPOSIT.getDescription())
                .build();
        Transaction[] arrayTx = {tx};
        return TransactionResponse.builder()
                .type(Operation.DEPOSIT.toString())
                .amountBalance(accountEntity.getBalance())
                .date(tx.getDate())
                .transactions(arrayTx)
                .build();
    }

}