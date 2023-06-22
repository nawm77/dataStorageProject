package com.example.datastorageproject.DTO;

public record OrderInfoDTO(Integer id, String make, String model, String carVinNumber, String description) {
    @Override
    public String toString() {
        return "OrderInfoDTO{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", id='" + id + '\'' +
                ", carVinNumber='" + carVinNumber + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
