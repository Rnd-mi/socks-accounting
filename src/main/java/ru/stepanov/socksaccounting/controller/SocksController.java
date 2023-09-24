package ru.stepanov.socksaccounting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.stepanov.socksaccounting.dto.SockDto;
import ru.stepanov.socksaccounting.model.Sock;
import ru.stepanov.socksaccounting.service.SocksService;

@RestController
@RequestMapping("/api/socks")
public class SocksController {
    @Autowired
    private SocksService service;

    public SocksController(SocksService service) {
        this.service = service;
    }

    @PostMapping("/income")
    public void income(@RequestBody SockDto sockDto) {
        service.income(sockDto);
    }

    @PostMapping("/outcome")
    public void outcome(@RequestBody SockDto sockDto) {
        service.outcome(sockDto);
    }

    @GetMapping
    public Integer getQuantity(String color, String operation, short cottonPart) {
        return service.getQuantity(color, operation, cottonPart);
    }
}
