package com.challenge.endpoints;


import com.challenge.entity.User;
import com.challenge.service.impl.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @GetMapping
    public List<User> findByCompanyIdAndAccelerationName(@RequestParam(required = false) Long companyId, @RequestParam(required = false) String accelerationName){
        if(companyId != null)
            return userService.findByCompanyId(companyId);
        if(accelerationName != null)
            return userService.findByAccelerationName(accelerationName);

        return userService.findAll();
    }

}
