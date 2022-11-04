package com.example.repository.bank;

import com.example.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
}