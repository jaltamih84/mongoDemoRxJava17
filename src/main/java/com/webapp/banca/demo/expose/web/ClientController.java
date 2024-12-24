package com.webapp.banca.demo.expose.web;

import com.webapp.banca.demo.business.ClientService;
import com.webapp.banca.demo.model.domain.Client;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bank/")
@Slf4j
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "client/{clientId}",
            produces = {"application/json"})
    public Maybe<Client> getClient(@PathVariable String clientId) {
        return this.clientService.findById(clientId);
    }

    @GetMapping(value = "/clients",
            produces = {"application/json"})
    public Flowable<Client> getClients() {
        return this.clientService.findAll();
    }

    @PostMapping(value = "/client",
            produces = {"application/json"})
    public Maybe<Client> postClient(@RequestBody Client client) {
        return this.clientService.insert(client);
    }
}
