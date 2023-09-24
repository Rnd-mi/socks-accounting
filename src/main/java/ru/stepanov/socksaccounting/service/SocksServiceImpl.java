package ru.stepanov.socksaccounting.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import ru.stepanov.socksaccounting.dto.SockDto;
import ru.stepanov.socksaccounting.exception.InvalidDataFormatException;
import ru.stepanov.socksaccounting.exception.InvalidOperationException;
import ru.stepanov.socksaccounting.exception.SockNotFoundException;
import ru.stepanov.socksaccounting.model.Sock;
import ru.stepanov.socksaccounting.repository.SocksRepository;

@Service
public class SocksServiceImpl implements SocksService {
    private SocksRepository repository;

    public SocksServiceImpl(SocksRepository repository) {
        this.repository = repository;
    }

    @Override
    public void income(SockDto sockDto) {
        Sock stored = repository
                .findByColorIgnoreCaseAndCottonPart(sockDto.getColor(), sockDto.getCottonPart())
                .orElse(new Sock(sockDto.getColor(), sockDto.getCottonPart(), 0));
        try {
            stored.setQuantity(stored.getQuantity() + sockDto.getQuantity());
            repository.save(stored);
        } catch (DataIntegrityViolationException e) {
            throw new InvalidDataFormatException();
        }
    }

    @Override
    public void outcome(SockDto sockDto) {
        Sock stored = repository
                .findByColorIgnoreCaseAndCottonPart(sockDto.getColor(), sockDto.getCottonPart())
                .orElseThrow(() -> new SockNotFoundException());

        try {
            stored.setQuantity(stored.getQuantity() - sockDto.getQuantity());
            repository.save(stored);
        } catch (DataIntegrityViolationException e) {
            throw new InvalidDataFormatException();
        }
    }

    @Override
    public Integer getQuantity(String color, String operation , short cottonPart) {
        if (operation.equalsIgnoreCase("equal")) {
            return repository.findByCottonPartEquals(color, cottonPart)
                    .orElseThrow(() -> new SockNotFoundException());
        }

        if (operation.equalsIgnoreCase("moreThan")) {
            return repository.findByCottonPartMoreThan(color, cottonPart)
                    .orElseThrow(() -> new SockNotFoundException());
        }

        if (operation.equalsIgnoreCase("lessThan")) {
            return repository.findByCottonPartLessThan(color, cottonPart)
                    .orElseThrow(() -> new SockNotFoundException());
        }
        throw new InvalidOperationException();
    }


}
