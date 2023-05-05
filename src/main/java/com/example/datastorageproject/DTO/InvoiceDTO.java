package com.example.datastorageproject.DTO;

public record InvoiceDTO(Integer id, String description) {
    /*TODO Подумать над тем, что должно быть в toString(нужна ли информация о машине, о сотруднике, о клиенте)*/
}
