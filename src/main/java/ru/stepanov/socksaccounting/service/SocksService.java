package ru.stepanov.socksaccounting.service;

import ru.stepanov.socksaccounting.model.Sock;

import java.util.List;

public interface SocksService {
    void income(Sock sockDto);

    void outcome(Sock sockDto);

    List<Sock> getAll();
}
