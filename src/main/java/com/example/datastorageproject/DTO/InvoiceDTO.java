package com.example.datastorageproject.DTO;

public record InvoiceDTO(Integer id, String description) {
    @Override
    public String toString() {
        return "InvoiceDTO{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
    /*TODO Подумать над тем, что должно быть в toString(нужна ли информация о машине, о сотруднике, о клиенте)*/
}
