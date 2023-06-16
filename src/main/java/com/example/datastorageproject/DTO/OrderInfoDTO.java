package com.example.datastorageproject.DTO;

public record OrderInfoDTO(String make, String model, String carVinNumber, String description) {
    @Override
    public String toString() {
        return "OrderInfoDTO{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", carVinNumber='" + carVinNumber + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
