package com.example.datastorageproject.DTO;

public record CarDTO(Integer id, String make, String model, Integer horsePower, String fuel, String color, String carVinNumber, Integer price, Boolean isProduced, Boolean isAvailable, Boolean isNew) {
    @Override
    public String toString() {
        return "CarDTO{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", horsePower=" + horsePower +
                ", fuel='" + fuel + '\'' +
                ", color='" + color + '\'' +
                ", carVinNumber='" + carVinNumber + '\'' +
                ", price=" + price +
                ", isProduced=" + isProduced +
                ", isAvailable=" + isAvailable +
                ", isNew=" + isNew +
                '}';
    }
}
