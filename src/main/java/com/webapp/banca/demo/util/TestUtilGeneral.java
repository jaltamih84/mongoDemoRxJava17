package com.webapp.banca.demo.util;

import com.webapp.banca.demo.model.entity.AccountEntity;
import com.webapp.banca.demo.model.entity.ClientEntity;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class TestUtilGeneral {

    public static AccountEntity generateAccountAhorro(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return AccountEntity.builder()
                .id(UUID.randomUUID().toString())
                .number("191-927-7044-1010")
                .productCode("ahorro")
                .flagComision(0)
                .maxOperation(3)
                .startDate(sdf.format(new Date()))
                .endDate(sdf.format(new Date()))
                .balance(BigDecimal.valueOf(1500.55))
                .currency("soles")
                .active(1)
                .build();
    }

    public static AccountEntity generateAccountCuentaCorriente(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return AccountEntity.builder()
                .id(UUID.randomUUID().toString())
                .number("191-927-7044-6060")
                .productCode("cc")
                .flagComision(0)
                .maxOperation(3)
                .startDate(sdf.format(new Date()))
                .endDate(sdf.format(new Date()))
                .balance(BigDecimal.valueOf(7000))
                .currency("soles")
                .active(1)
                .build();
    }

    public static AccountEntity generateAccountPlazoFijo(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return AccountEntity.builder()
                .id(UUID.randomUUID().toString())
                .number("191-927-7044-0000")
                .productCode("pf")
                .flagComision(0)
                .maxOperation(3)
                .startDate(sdf.format(new Date()))
                .endDate(sdf.format(new Date()))
                .balance(BigDecimal.valueOf(25500))
                .currency("soles")
                .active(1)
                .build();
    }


    public static ClientEntity generateClient(){
        return ClientEntity.builder()
                .id(UUID.randomUUID().toString())
                .account("191-927-7044-1010")
                .clientTypeCode(1)
                .clientTypeDescription("Personal")
                .pPersonaId("123456")
                .pAge(41)
                .pFirstName("Juan")
                .pLastName("Altamirano")
                .pPhoneNumber("956897544")
                .pEmeal("jaltamih@gmail.com")
                .pStatusCivil("soltero")
                .active(1)
                .build();
    }
}
