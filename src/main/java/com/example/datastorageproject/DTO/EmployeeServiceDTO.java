package com.example.datastorageproject.DTO;

public record EmployeeServiceDTO(String name, String lastname, String phoneNumber, String description) {
    @Override
    public String toString() {
        return "EmployeeServiceDTO{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
