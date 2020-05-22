package com.challenge.service;

import com.challenge.entity.Challenge;
import com.challenge.repository.ChallengeRepository;
import com.challenge.service.interfaces.ChallengeServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ChallengeService implements ChallengeServiceInterface {

    @Autowired
    ChallengeRepository repo;

    @Override
    public List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId) {
        return repo.findByAccelerationIdAndUserId(accelerationId, userId);
    }

    @Override
    public Challenge save(Challenge object) {
        return repo.save(object);
    }
}
