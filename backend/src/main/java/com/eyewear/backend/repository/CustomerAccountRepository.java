package com.eyewear.backend.repository;

import com.eyewear.backend.entity.CustomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CustomerAccountRepository extends JpaRepository<CustomerAccount, Integer> {
    Optional<CustomerAccount> findByUsername(String username);

    boolean existsByUsername(String username);
}