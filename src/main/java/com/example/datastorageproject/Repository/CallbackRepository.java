package com.example.datastorageproject.Repository;

import com.example.datastorageproject.Model.Callback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CallbackRepository extends JpaRepository<Callback, Integer> {
}
