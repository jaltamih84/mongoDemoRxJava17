package com.webapp.banca.demo.controller;

import com.webapp.banca.demo.business.AccountService;
import com.webapp.banca.demo.dao.repository.AccountRepository;
import com.webapp.banca.demo.expose.web.v2.AccountControllerV2;
import com.webapp.banca.demo.model.entity.AccountEntity;
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


@SpringJUnitConfig(AccountEntity.class)
public class AccountControllerTest {
    @Mock
    AccountRepository accountRepository;
    @Mock
    AccountService accountService;

    WebTestClient client;
    AccountEntity[] accountsArray;
    AccountEntity account;

    @BeforeEach
    void setUp(ApplicationContext context) {
        MockitoAnnotations.openMocks(this);
        client = WebTestClient.bindToController(new AccountControllerV2(accountRepository,accountService))
                .build();
        accountsArray = new AccountEntity[]{
                TestUtilGeneral.generateAccountAhorro(),
                TestUtilGeneral.generateAccountCuentaCorriente(),
                TestUtilGeneral.generateAccountPlazoFijo()
        };

        account = TestUtilGeneral.generateAccountAhorro();
    }

    @Test()
    public void testGetAllCustomer() {
        // Simulamos que el repositorio devuelve una lista de Customer
        given(accountRepository.findAll()).willReturn(Flux.just(accountsArray));
        client.get().uri("/api/bank/v2/accounts")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(AccountEntity.class)
                .hasSize(3);

    }

	@Test
	public void testGetCustomerById() {
		// Simulamos el comportamiento del repositorio
		given(accountRepository.findById("1")).willReturn(Mono.just(account));
		client.get().uri("/api/bank/v2/accounts/{id}", "1")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectBodyList(AccountEntity.class)
				.hasSize(1);
	}

}
