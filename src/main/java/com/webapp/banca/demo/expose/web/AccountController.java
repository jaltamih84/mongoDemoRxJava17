package com.webapp.banca.demo.expose.web;

import com.webapp.banca.demo.business.AccountService;
import com.webapp.banca.demo.model.domain.Account;
import com.webapp.banca.demo.model.response.BalanceResponse;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bank/")
@Slf4j
public class AccountController {

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;

    @GetMapping(value = "account/{accountId}",
            produces = {"application/json"})
    public Maybe<Account> getAccount(@PathVariable String accountId) {
        logger.info("Processing request for /api/bank/account/{accountId}");
        return this.accountService.findById(accountId);
    }

    @GetMapping(value = "account/{accountId}/balance",
            produces = {"application/json"})
    public Maybe<BalanceResponse> getBalance(@PathVariable String accountId) {
        logger.info("Processing request for /api/bank/account/{accountId}/balance");
        return this.accountService.getBalanceByIdAccount(accountId);
    }

    @GetMapping(value = "accounts",
            produces = {"application/json"})
    public Flowable<Account> getAccounts() {
        logger.info("Procesando la solicitud para /api/bank/accounts");
        return this.accountService.findAll();
    }

    @PostMapping(value = "account",
            produces = {"application/json"})
    public Maybe<Account> postAccount(@RequestBody Account account) {
        logger.info("Procesando la solicitud para /api/bank/account");
        return this.accountService.insert(account);
    }
}
