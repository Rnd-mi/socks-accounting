package ru.stepanov.socksaccounting.service;

import org.springframework.stereotype.Service;
import ru.stepanov.socksaccounting.dto.SockDto;

import java.util.List;

@Service
public class SocksServiceImpl implements SocksService {
    @Override
    public void income(SockDto sockDto) {

    }

    @Override
    public SockDto outcome() {
        return null;
    }

    @Override
    public List<SockDto> getAll() {
        return null;
    }
}
