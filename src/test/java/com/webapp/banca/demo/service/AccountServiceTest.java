package com.webapp.banca.demo.service;

import com.webapp.banca.demo.business.impl.AccountServiceImpl;
import com.webapp.banca.demo.dao.repository.AccountRepository;
import com.webapp.banca.demo.model.domain.Account;
import com.webapp.banca.demo.model.entity.AccountEntity;
import com.webapp.banca.demo.util.TestUtilGeneral;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.adapter.rxjava.RxJava3Adapter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;


@SpringBootTest
public class AccountServiceTest {
    @Mock
    AccountRepository accountRepository;

    AccountEntity[] accountsArray;
    AccountEntity account;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        accountsArray = new AccountEntity[]{
                TestUtilGeneral.generateAccountAhorro(),
                TestUtilGeneral.generateAccountCuentaCorriente(),
                TestUtilGeneral.generateAccountPlazoFijo()
        };

        account = TestUtilGeneral.generateAccountAhorro();
    }

    @Test
    public void testGetAllCustomer() {
        given(accountRepository.findAll()).willReturn(Flux.just(accountsArray));

        assertNotNull(accountsArray);
        assertEquals(3, accountsArray.length);
        assertEquals("ahorro", accountsArray[0].getProductCode());
        assertEquals("cc", accountsArray[1].getProductCode());
        assertEquals("pf", accountsArray[2].getProductCode());


    }

    @Test
    public void testGetCustomerById() {
        given(accountRepository.findById("1")).willReturn(Mono.just(account));
        //Maybe<Account> resultado = accountService.findById("677c88a2d9be8c12a23647fe");
        assertNotNull(account);
        assertEquals("ahorro", account.getProductCode());
    }

}
