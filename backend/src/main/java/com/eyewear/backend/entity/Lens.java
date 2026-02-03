package com.eyewear.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Lens")
public class Lens {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lens_id")
    private Integer lensId;

    private String brand;

    @Column(name = "lens_type")
    private String lensType;

    @Column(name = "base_price")
    private BigDecimal basePrice;
}
