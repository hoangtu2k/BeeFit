package com.spring.beefit.service;

import com.spring.beefit.entity.Size;
import com.spring.beefit.repository.SizeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeService {

    private final SizeRepository repository;

    public SizeService(SizeRepository repository) {
        this.repository = repository;
    }

    public List<Size> getAllSizes() {
        return repository.getAll();
    }

}
