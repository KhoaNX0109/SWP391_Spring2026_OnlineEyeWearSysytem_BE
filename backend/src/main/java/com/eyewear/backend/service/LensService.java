package com.eyewear.backend.service;

import com.eyewear.backend.entity.Lens;
import com.eyewear.backend.repository.LensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LensService {

    @Autowired
    private LensRepository lensRepository;

    public List<Lens> getAllLenses() {
        return lensRepository.findAll();
    }

    public Lens updateLens(Integer id, Lens lensDetails) {
        return lensRepository.findById(id).map(lens -> {
            lens.setBrand(lensDetails.getBrand());
            lens.setLensType(lensDetails.getLensType());
            lens.setBasePrice(lensDetails.getBasePrice());
            return lensRepository.save(lens);
        }).orElseThrow(() -> new RuntimeException("Lens not found with id " + id));
    }

    public void deleteLens(Integer id) {
        if (!lensRepository.existsById(id)) {
            throw new RuntimeException("Lens not found with id " + id);
        }
        lensRepository.deleteById(id);
    }
}
