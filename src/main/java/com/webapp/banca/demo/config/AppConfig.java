package com.webapp.banca.demo.config;

import com.webapp.banca.demo.business.AccountService;
import com.webapp.banca.demo.business.impl.AccountServiceImpl;
import org.springframework.context.annotation.Bean;

public class AppConfig {
    @Bean
    public AccountService accountService() {
        return new AccountServiceImpl();
    }

}
