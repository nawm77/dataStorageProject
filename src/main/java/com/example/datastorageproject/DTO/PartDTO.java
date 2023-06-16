package com.example.datastorageproject.DTO;

public record PartDTO(Integer id, Integer availableCount, String name, Integer price) {
    @Override
    public String toString() {
        return "PartDTO{" +
                "availableCount=" + availableCount +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", id=" + id +
                '}';
    }
}
