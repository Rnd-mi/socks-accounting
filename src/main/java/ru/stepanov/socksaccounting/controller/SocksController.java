package ru.stepanov.socksaccounting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.stepanov.socksaccounting.dto.SockDto;
import ru.stepanov.socksaccounting.service.SocksService;

import java.util.List;

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
    public SockDto outcome() {
        return service.outcome();
    }

    @GetMapping
    public List<SockDto> getAll() {
        return service.getAll();
    }
}
