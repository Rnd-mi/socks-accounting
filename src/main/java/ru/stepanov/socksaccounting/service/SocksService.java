package ru.stepanov.socksaccounting.service;

import ru.stepanov.socksaccounting.dto.SockDto;

import java.util.List;

public interface SocksService {
    void income(SockDto sockDto);

    SockDto outcome();

    List<SockDto> getAll();
}
