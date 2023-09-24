package ru.stepanov.socksaccounting.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "socks")
public class Sock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "color")
    @NotNull
    private String color;

    @Column(name = "cotton_part")
    @NotNull
    @Size(min = 0, max = 100)
    private short cottonPart;

    @Column(name = "quantity")
    @NotNull
    @Size(min = 1)
    private int quantity;

    public Sock() {
    }

    public Sock(String color, short cottonPart, int quantity) {
        this.color = color;
        this.cottonPart = cottonPart;
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public short getCottonPart() {
        return cottonPart;
    }

    public void setCottonPart(short cottonPart) {
        this.cottonPart = cottonPart;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sock sock = (Sock) o;
        return color.equals(sock.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }
}
