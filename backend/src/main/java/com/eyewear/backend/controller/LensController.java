package com.eyewear.backend.controller;

import com.eyewear.backend.entity.Lens;
import com.eyewear.backend.service.LensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/lenses")
public class LensController {

    @Autowired
    private LensService lensService;

    @GetMapping
    public List<Lens> getAllLenses() {
        return lensService.getAllLenses();
    }

    @PutMapping("/{id}")
    public Lens updateLens(@PathVariable Integer id, @RequestBody Lens lensDetails) {
        return lensService.updateLens(id, lensDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteLens(@PathVariable Integer id) {
        lensService.deleteLens(id);
    }
}
