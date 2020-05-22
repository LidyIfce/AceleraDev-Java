package com.challenge.service;

import com.challenge.entity.Acceleration;
import com.challenge.repository.AccelerationRepository;
import com.challenge.service.interfaces.AccelerationServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccelerationService implements AccelerationServiceInterface {

    @Autowired
    private AccelerationRepository repo;

    @Override
    public Optional<Acceleration> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Acceleration> findByCompanyId(Long companyId) {
        return repo.findByCompanyId(companyId);
    }

    @Override
    public Acceleration save(Acceleration object) {
        return repo.save(object);
    }
}
