package com.webapp.banca.demo.expose.web.v2;

import com.webapp.banca.demo.business.ClientService;
import com.webapp.banca.demo.dao.repository.ClientRepository;
import com.webapp.banca.demo.model.entity.ClientEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/api/bank/v2")
@Slf4j
@AllArgsConstructor
public class ClientControllerV2 {

    private static final Logger logger = LoggerFactory.getLogger(ClientControllerV2.class);

    private ClientRepository acccountRepository;
    private ClientService ClientService;

    @GetMapping("/clients")
    public Flux<ClientEntity> viewAccounts(@RequestHeader Map<String, String> headers) {
        return acccountRepository.findAll();
    }

    @GetMapping("/clients/{id}")
    public Mono<ClientEntity> viewAccount(@RequestHeader Map<String, String> headers, @PathVariable String id) {
        return acccountRepository.findById(id);
    }
}
