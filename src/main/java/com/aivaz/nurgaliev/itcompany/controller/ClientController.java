package com.aivaz.nurgaliev.itcompany.controller;

import com.aivaz.nurgaliev.itcompany.entity.Client;
import com.aivaz.nurgaliev.itcompany.exception.DataNotFoundException;
import com.aivaz.nurgaliev.itcompany.service.ClientService;
import com.aivaz.nurgaliev.itcompany.util.PageAndEntityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


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
     * @param pageNo - номер страницы - по умолчанию 1
     * @param pageSize - размер страницы - по умолчанию 50
     * @param sortBy - сортировка по clientId или clientStartCooperationDate в возрастающем порядке,
     *               в убывающем будет -clientId или -clientStartCooperationDate
     *               остальные поля доступные сортировки: clientName
     *
     * Пример запроса:
     *  http://localhost:8080/clients?pageNo=1&pageSize=3&sortBy=-clientId
     *  http://localhost:8080/clients?pageNo=1&pageSize=3&sortBy=clientId
     *  http://localhost:8080/clients?pageNo=1&pageSize=3&sortBy=-clientStartCooperationDate
     *  http://localhost:8080/clients?pageNo=1&pageSize=3&sortBy=clientStartCooperationDate
     * @return
     * 200-Если запрос прошел успешно.
     * 404-Если не существуют заказчики.
     * 500-Ошибка вызванная сервером.
     */
    @GetMapping("/clients")
    public PageAndEntityResponse<Client> getAllClients(@RequestParam(defaultValue = "1") Integer pageNo,
                                                       @RequestParam(defaultValue = "50") Integer pageSize,
                                                       @RequestParam(defaultValue = "clientId") String sortBy) {
        try {
            return clientService.getAllClients(pageNo - 1, pageSize, sortBy);
        } catch (DataNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

}
