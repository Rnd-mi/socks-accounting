package ru.stepanov.socksaccounting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.stepanov.socksaccounting.model.Sock;
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
    public void income(@RequestBody Sock sockDto) {
        service.income(sockDto);
    }

    @PostMapping("/outcome")
    public void outcome(@RequestBody Sock sockDto) {
        service.outcome(sockDto);
    }

    @GetMapping
    public List<Sock> getAll() {
        return service.getAll();
    }
}
