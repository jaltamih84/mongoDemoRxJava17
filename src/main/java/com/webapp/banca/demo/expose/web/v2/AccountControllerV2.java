package com.webapp.banca.demo.expose.web.v2;

import com.webapp.banca.demo.business.AccountService;
import com.webapp.banca.demo.dao.repository.AccountRepository;
import com.webapp.banca.demo.model.entity.AccountEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/api/bank/v2")
@Slf4j
@AllArgsConstructor
public class AccountControllerV2 {

    private AccountRepository acccountRepository;
    private AccountService accountService;

    @GetMapping("/accounts")
    public Flux<AccountEntity> viewAccounts(@RequestHeader Map<String, String> headers) {
        return acccountRepository.findAll();
    }

    @GetMapping("/accounts/{id}")
    public Mono<AccountEntity> viewAccount(@RequestHeader Map<String, String> headers, @PathVariable String id) {
        return acccountRepository.findById(id);
    }
}
