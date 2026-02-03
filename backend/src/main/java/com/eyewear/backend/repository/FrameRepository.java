package com.eyewear.backend.repository;

import com.eyewear.backend.entity.Frame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrameRepository extends JpaRepository<Frame, Integer> {
}
