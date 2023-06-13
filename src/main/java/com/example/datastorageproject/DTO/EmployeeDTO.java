package com.example.datastorageproject.DTO;

import com.example.datastorageproject.Model.Position;

public record EmployeeDTO(Integer id, String name, String lastname, String phoneNumber, String email, Position position) {
    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + lastname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", position='" + position.getPositionName() + '\'' +
                ", salary='" + position.getSalary() + '\'' +
                '}';
    }
}

//public class EmployeeDTO{
//    private Integer id;
//    private String name;
//    private String surname;
//    private String phoneNumber;
//    private String email;
//    private String password;
//    private Position position;
//}
