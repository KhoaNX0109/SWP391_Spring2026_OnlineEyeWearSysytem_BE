package com.eyewear.backend.service;

import com.eyewear.backend.entity.Frame;
import com.eyewear.backend.repository.FrameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FrameService {

    @Autowired
    private FrameRepository frameRepository;

    public List<Frame> getAllFrames() {
        return frameRepository.findAll();
    }

    public Frame updateFrame(Integer id, Frame frameDetails) {
        return frameRepository.findById(id).map(frame -> {
            frame.setBrand(frameDetails.getBrand());
            frame.setSize(frameDetails.getSize());
            frame.setColor(frameDetails.getColor());
            frame.setPrice(frameDetails.getPrice());
            frame.setStock(frameDetails.getStock());
            return frameRepository.save(frame);
        }).orElseThrow(() -> new RuntimeException("Frame not found with id " + id));
    }

    public void deleteFrame(Integer id) {
        if (!frameRepository.existsById(id)) {
            throw new RuntimeException("Frame not found with id " + id);
        }
        frameRepository.deleteById(id);
    }
}
