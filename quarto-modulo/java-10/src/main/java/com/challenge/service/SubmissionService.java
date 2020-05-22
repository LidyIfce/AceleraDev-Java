package com.challenge.service;

import com.challenge.entity.Submission;
import com.challenge.repository.SubmissionRepository;
import com.challenge.service.interfaces.SubmissionServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
@AllArgsConstructor
public class SubmissionService implements SubmissionServiceInterface {
    @Autowired
    SubmissionRepository repo;

    @Override
    public BigDecimal findHigherScoreByChallengeId(Long challengeId) {
        return repo.findHigherScoreByChallengeId(challengeId).orElse(BigDecimal.ZERO);
    }

    @Override
    public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
        return repo.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
    }

    @Override
    public Submission save(Submission object) {
        return repo.save(object);
    }
}
