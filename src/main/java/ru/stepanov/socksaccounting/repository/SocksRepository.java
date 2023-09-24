package ru.stepanov.socksaccounting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.stepanov.socksaccounting.dao.SockDao;

@Repository
public interface SocksRepository extends JpaRepository<SockDao, Integer> {
}
