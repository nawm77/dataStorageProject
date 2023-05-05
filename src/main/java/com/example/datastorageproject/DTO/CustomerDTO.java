package com.example.datastorageproject.DTO;

public record CustomerDTO(Integer id, String name, String surname, String phoneNumber, String email) {
    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
