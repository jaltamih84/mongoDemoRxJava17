package com.webapp.banca.demo.controller;

import com.webapp.banca.demo.business.ClientService;
import com.webapp.banca.demo.dao.repository.ClientRepository;
import com.webapp.banca.demo.expose.web.v2.ClientControllerV2;
import com.webapp.banca.demo.model.entity.ClientEntity;
import com.webapp.banca.demo.util.TestUtilGeneral;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mockito.BDDMockito.given;

@SpringJUnitConfig(ClientEntity.class)
public class ClientControllerTest {
    @Mock
    ClientRepository customerRepository;
    @Mock
    ClientService customerService;

    WebTestClient client;

    ClientEntity[] customersArray;
    ClientEntity customerEntity;

    @BeforeEach
    void setUp(ApplicationContext context) {
        MockitoAnnotations.openMocks(this);
        client = WebTestClient.bindToController(new ClientControllerV2(customerRepository, customerService))
                .build();
        customersArray = new ClientEntity[]{
                TestUtilGeneral.generateClient(),
                TestUtilGeneral.generateClient(),
                TestUtilGeneral.generateClient()
        };

        customerEntity = TestUtilGeneral.generateClient();
    }

    @Test()
    public void testGetAllCustomer() {
        // Simulamos que el repositorio devuelve una lista de Customer
        given(customerRepository.findAll()).willReturn(Flux.just(customersArray));
        client.get().uri("/api/bank/v2/clients")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(ClientEntity.class)
                .hasSize(3);

    }

    @Test
    public void testGetCustomerById() {
        // Simulamos el comportamiento del repositorio
        given(customerRepository.findById("1")).willReturn(Mono.just(customerEntity));
        client.get().uri("/api/bank/v2/clients/{id}", "1")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(ClientEntity.class)
                .hasSize(1);
    }
}
