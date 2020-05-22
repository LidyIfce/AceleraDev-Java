package com.challenge.endpoints;

import com.challenge.entity.Acceleration;
import com.challenge.service.impl.AccelerationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/acceleration")
@AllArgsConstructor
@RestController
public class AccelerationController {

    private AccelerationService accelerationService;

    @GetMapping("/{id}")
    public Optional<Acceleration> findById(@PathVariable Long id){
        return accelerationService.findById(id);
    }
    @GetMapping()
    public List<Acceleration> findByCompanyId(@RequestParam(required = false) Long companyId){
        if(companyId != null)
            return accelerationService.findByCompanyId(companyId);

        return accelerationService.findAll();
    }
}
