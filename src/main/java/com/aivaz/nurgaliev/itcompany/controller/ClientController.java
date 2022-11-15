package com.aivaz.nurgaliev.itcompany.controller;

import com.aivaz.nurgaliev.itcompany.entity.Client;
import com.aivaz.nurgaliev.itcompany.exception.DataNotFoundException;
import com.aivaz.nurgaliev.itcompany.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * Получение заказчика по идентификатору заказчика
     * @param clientId - Id заказчика(Integer)
     * @return Client
     * 200-Если запрос прошел успешно.
     * 404-Если был предоставлен неверный id (не существует заказчик).
     * 500-Ошибка вызванная сервером.
     */
    @GetMapping("/client/{clientId}")
    public Client getClient(@PathVariable(name = "clientId") Integer clientId) {
        try {
            return clientService.getClientById(clientId);
        } catch (DataNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    /**
     * Получение всех заказчиков
     * @return List<Client> - Список заказчиков
     * 200-Если запрос прошел успешно.
     * 404-Если не существуют заказчики.
     * 500-Ошибка вызванная сервером.
     */
    @GetMapping("/clients")
    public List<Client> getAllClients() {
        try {
            return clientService.getAllClients();
        } catch (DataNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

}
