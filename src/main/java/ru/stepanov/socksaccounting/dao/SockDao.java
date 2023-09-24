package ru.stepanov.socksaccounting.dao;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "socks")
public class SockDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "color")
    @NotNull
    private String color;

    @Column(name = "cottonPart")
    @NotNull
    @Size(min = 0, max = 100)
    private int cottonPart;

    @Column(name = "quantity")
    @NotNull
    @Size(min = 1)
    private int quantity;

    public SockDao() {
    }

    public SockDao(String color, int cottonPart, int quantity) {
        this.color = color;
        this.cottonPart = cottonPart;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SockDao sockDao = (SockDao) o;
        return id == sockDao.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
