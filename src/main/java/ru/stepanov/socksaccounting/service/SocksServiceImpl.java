package ru.stepanov.socksaccounting.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import ru.stepanov.socksaccounting.exception.InvalidDataFormat;
import ru.stepanov.socksaccounting.model.Sock;
import ru.stepanov.socksaccounting.repository.SocksRepository;

import java.util.List;

@Service
public class SocksServiceImpl implements SocksService {
    private SocksRepository repository;

    public SocksServiceImpl(SocksRepository repository) {
        this.repository = repository;
    }

    @Override
    public void income(Sock sock) {
        try {
            repository.save(sock);
        } catch (DataIntegrityViolationException e) {
            throw new InvalidDataFormat();
        }
    }

    @Override
    public void outcome(Sock sock) {
        List<Sock> all = repository.findAll();

//        for (Sock sockDao : all) {
//            if () {
//
//            }
//        }
    }

    @Override
    public List<Sock> getAll() {
        return null;
    }
}
