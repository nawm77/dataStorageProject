package com.example.datastorageproject.DTO;

import com.example.datastorageproject.Model.Invoice;
import com.example.datastorageproject.Model.Part;

public record OrderPartDTO(Integer id, Integer amount, Part part, Invoice invoice) {
    @Override
    public String toString() {
        return "OrderPartDTO{" +
                "id=" + id +
                ", amount=" + amount +
                ", part=" + part.getName() +
                ", invoice=" + invoice.getDescription() +
                '}';
    }
}
