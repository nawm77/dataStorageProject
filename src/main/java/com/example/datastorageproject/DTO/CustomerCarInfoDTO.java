package com.example.datastorageproject.DTO;

public record CustomerCarInfoDTO(Integer id, String name, String lastname, String phoneNumber, String email, String make, String model, String carVinNumber) {
    @Override
    public String toString() {
        return "CustomerCarInfoDTO{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", carVinNumber='" + carVinNumber + '\'' +
                '}';
    }
}
