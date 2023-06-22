package com.example.datastorageproject.DTO;

public record CarInfoServiceDTO(Integer id, String make, String model, Integer horsePower, String fuel, String color, Integer price, String carVinNumber, Boolean isProduced, Boolean isAvailable, Boolean isNew, String status) {
    @Override
    public String toString() {
        return "CarInfoServiceDTO{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", horsePower=" + horsePower +
                ", fuel='" + fuel + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", carVinNUmber='" + carVinNumber + '\'' +
                ", isProduced=" + isProduced +
                ", isAvailable=" + isAvailable +
                ", isNew=" + isNew +
                ", status='" + status + '\'' +
                '}';
    }
}
