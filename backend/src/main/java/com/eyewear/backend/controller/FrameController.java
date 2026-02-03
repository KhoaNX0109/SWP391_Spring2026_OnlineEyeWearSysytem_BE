package com.eyewear.backend.controller;

import com.eyewear.backend.entity.Frame;
import com.eyewear.backend.service.FrameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/frames")
public class FrameController {

    @Autowired
    private FrameService frameService;

    @GetMapping
    public List<Frame> getAllFrames() {
        return frameService.getAllFrames();
    }

    @PutMapping("/{id}")
    public Frame updateFrame(@PathVariable Integer id, @RequestBody Frame frameDetails) {
        return frameService.updateFrame(id, frameDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteFrame(@PathVariable Integer id) {
        frameService.deleteFrame(id);
    }
}
