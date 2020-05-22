package com.challenge.service;

import com.challenge.entity.User;
import com.challenge.repository.UserRepository;
import com.challenge.service.interfaces.UserServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserServiceInterface {
    @Autowired
    UserRepository repo;

    @Override
    public Optional<User> findById(Long userId) {
        return repo.findById(userId);
    }

    @Override
    public List<User> findByAccelerationName(String name) {
        return repo.findByAccelerationName(name);
    }

    @Override
    public List<User> findByCompanyId(Long companyId) {
        return repo.findByCompanyId(companyId);
    }

    @Override
    public User save(User object) {
        object.setCreatedAt(LocalDateTime.now());
        return repo.save(object);
    }
}
