package com.example.datastorageproject.Repository;

import com.example.datastorageproject.Model.OrderPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface OrderPartRepository extends JpaRepository<OrderPart, Integer> {
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM OrderPart o WHERE o.invoice.id = :invoiceId AND o.part.id = :partId")
    void deleteByInvoiceIdAndPartId(Integer invoiceId, Integer partId);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO order_part (amount, invoice_id, part_id) VALUES (:amount, :invoiceId, :partId)", nativeQuery = true)
    void saveOrderPart(Integer amount, Integer invoiceId, Integer partId);
}
