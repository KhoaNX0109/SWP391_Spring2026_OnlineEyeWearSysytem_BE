package com.eyewear.backend.repository;

import com.eyewear.backend.entity.Lens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LensRepository extends JpaRepository<Lens, Integer> {
}
