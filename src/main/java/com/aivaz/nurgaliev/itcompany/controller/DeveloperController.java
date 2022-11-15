package com.aivaz.nurgaliev.itcompany.controller;

import com.aivaz.nurgaliev.itcompany.entity.Developer;
import com.aivaz.nurgaliev.itcompany.exception.DataNotFoundException;
import com.aivaz.nurgaliev.itcompany.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class DeveloperController {
    private final DeveloperService developerService;

    @Autowired
    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    /**
     * Получение разработчика по его id
     * @param developerId - id разработчика(Integer)
     * @return
     * 200-Если запрос прошел успешно.
     * 404-Если был предоставлен неверный id (не существует разработчик).
     * 500-Ошибка вызванная сервером.
     */
    @GetMapping("/developer/{developerId}")
    public Developer getDeveloperById(@PathVariable(name = "developerId") Integer developerId) {
        try {
            return developerService.getDeveloperById(developerId);
        } catch (DataNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }


}
