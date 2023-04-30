package com.example.datastorageproject.DTO;

public record EmployeeDTO(Integer id, String name, String surname, String phoneNumber, String email) {
    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
