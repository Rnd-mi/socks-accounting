package ru.stepanov.socksaccounting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.stepanov.socksaccounting.model.Sock;

import java.util.Optional;

@Repository
public interface SocksRepository extends JpaRepository<Sock, String> {
    Optional<Sock> findByColorIgnoreCaseAndCottonPart(String color, short cottonPart);

    @Query(
            value = "select sum(quantity) from socks where color = :color and cotton_part = :cottonPart",
            nativeQuery = true
          )
    Optional<Integer> findByCottonPartEquals(@Param("color") String color,
                                             @Param("cottonPart") short cottonPart);

    @Query(
            value = "select sum(quantity) from socks where color = :color and cotton_part > :cottonPart",
            nativeQuery = true
          )
    Optional<Integer> findByCottonPartMoreThan(@Param("color") String color,
                                               @Param("cottonPart") short cottonPart);

    @Query(
            value = "select sum(quantity) from socks where color = :color and cotton_part < :cottonPart",
            nativeQuery = true
          )
    Optional<Integer> findByCottonPartLessThan(@Param("color") String color,
                                               @Param("cottonPart") short cottonPart);
}
