package com.webapp.banca.demo.expose.web;

import com.webapp.banca.demo.business.ClientService;
import com.webapp.banca.demo.model.domain.Client;
import com.webapp.banca.demo.model.domain.ClientType;
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
public class ClientController {

    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "client/{clientId}",
            produces = {"application/json"})
    public Maybe<Client> getClient(@PathVariable String clientId) {
        logger.info("Processing request for /api/bank/client/{clientId}");
        return this.clientService.findById(clientId);
    }

    @GetMapping(value = "clients",
            produces = {"application/json"})
    public Flowable<Client> getClients() {
        logger.info("Procesando la solicitud para /api/bank/clients");
        return this.clientService.findAll();
    }

    @GetMapping("clientsType")
    public Flowable<ClientType> getClientsByTypeCode() {
        return clientService.getClientsByTypeCode();
    }

    @PostMapping(value = "client",
            produces = {"application/json"})
    public Maybe<Client> postClient(@RequestBody Client client) {
        logger.info("Procesando la solicitud para /api/bank/client");
        return this.clientService.insert(client);
    }
}
