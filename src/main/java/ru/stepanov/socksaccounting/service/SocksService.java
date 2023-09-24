package ru.stepanov.socksaccounting.service;

import ru.stepanov.socksaccounting.dto.SockDto;

public interface SocksService {
    void income(SockDto sockDto);

    void outcome(SockDto sockDto);

    Integer getQuantity(String color, String operation, short cottonPart);
}
