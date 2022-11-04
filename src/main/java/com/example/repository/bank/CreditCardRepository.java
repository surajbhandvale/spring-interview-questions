package com.example.repository.bank;

import com.example.entity.CreditCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CreditCardRepository extends JpaRepository<CreditCardEntity, Long> {
}