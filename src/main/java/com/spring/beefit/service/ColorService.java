package com.spring.beefit.service;

import com.spring.beefit.entity.Color;
import com.spring.beefit.repository.ColorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorService {

    private final ColorRepository repository;

    public ColorService(ColorRepository repository) {
        this.repository = repository;
    }

    public List<Color> getAllColors() {
        return repository.getAll();
    }

}
