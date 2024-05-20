package com.spring.beefit.service;

import com.spring.beefit.entity.Design;
import com.spring.beefit.repository.DesignRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesignService {

    private final DesignRepository repository;

    public DesignService(DesignRepository repository) {
        this.repository = repository;
    }

    public List<Design> getAllDesigns() {
        return repository.getAll();
    }

}
