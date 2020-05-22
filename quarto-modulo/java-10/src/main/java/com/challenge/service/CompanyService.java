package com.challenge.service;

import com.challenge.entity.Company;
import com.challenge.repository.CompanyRepository;
import com.challenge.service.interfaces.CompanyServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class CompanyService implements CompanyServiceInterface {
    @Autowired
    CompanyRepository repo;

    @Override
    public Optional<Company> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Company> findByAccelerationId(Long accelerationId) {
        return repo.findByAccelerationId(accelerationId);
    }

    @Override
    public List<Company> findByUserId(Long userId) {
        return repo.findByUserId(userId);
    }

    @Override
    public Company save(Company object) {
        return repo.save(object);
    }
}
