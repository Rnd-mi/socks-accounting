package ru.stepanov.socksaccounting.service;

import org.springframework.stereotype.Service;
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
        repository.save(sock);
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
