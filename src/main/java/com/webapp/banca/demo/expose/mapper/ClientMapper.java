package com.webapp.banca.demo.expose.mapper;

import com.webapp.banca.demo.model.domain.Client;
import com.webapp.banca.demo.model.domain.ClientType;
import com.webapp.banca.demo.model.domain.Document;
import com.webapp.banca.demo.model.domain.Person;
import com.webapp.banca.demo.model.entity.ClientEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ClientMapper {

    public ClientEntity getClientEntityInsertOfClient(Client client) {
        return ClientEntity.builder()
                .id(UUID.randomUUID().toString())
                .account(client.getAccount())
                .clientTypeCode(client.getType().getCode())
                .clientTypeDescription(client.getType().getDescription())
                .pPersonaId(client.getPerson().getPersonaId())
                .pFirstName(client.getPerson().getFirstName())
                .pLastName(client.getPerson().getLastName())
                .pPhoneNumber(client.getPerson().getPhoneNumber())
                .documentType(client.getPerson().getDocument().getType())
                .documentNumber(client.getPerson().getDocument().getNumber())
                .pAge(client.getPerson().getAge())
                .pEmeal(client.getPerson().getEmeal())
                .pStatusCivil(client.getPerson().getStatusCivil())
                .active(client.getActive())
                .build();
    }

    public Client getClientOfClientEntity(ClientEntity clientEntity) {
        return Client.builder()
                .clientId(clientEntity.getId())
                .account(clientEntity.getAccount())
                .type(ClientType.builder()
                        .code(clientEntity.getClientTypeCode())
                        .description(clientEntity.getClientTypeDescription())
                        .build())
                .person(Person.builder()
                        .personaId(clientEntity.getPPersonaId())
                        .firstName(clientEntity.getPFirstName())
                        .lastName(clientEntity.getPLastName())
                        .phoneNumber(clientEntity.getPPhoneNumber())
                        .document(Document.builder()
                                .type(clientEntity.getDocumentType())
                                .number(clientEntity.getDocumentNumber())
                                .build())
                        .age(clientEntity.getPAge())
                        .emeal(clientEntity.getPEmeal())
                        .statusCivil(clientEntity.getPStatusCivil())
                        .build())
                .active(clientEntity.getActive())
                .build();
    }
}
