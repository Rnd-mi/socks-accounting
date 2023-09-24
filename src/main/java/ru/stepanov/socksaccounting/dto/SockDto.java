package ru.stepanov.socksaccounting.dto;

import java.util.Objects;

public class SockDto {
    private String color;

    private short cottonPart;

    private int quantity;

    public SockDto(String color, short cottonPart, int quantity) {
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
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        SockDto sock = (SockDto) o;
        return this.color.equals(sock.color) && this.cottonPart == sock.cottonPart;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, cottonPart);
    }
}
