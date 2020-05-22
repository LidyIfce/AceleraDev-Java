package com.challenge.endpoints;

import com.challenge.entity.Company;
import com.challenge.service.impl.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
@AllArgsConstructor
public class CompanyController {
    private CompanyService companyService;

    @GetMapping("/{id}")
    public Optional<Company> findById(@PathVariable Long id){
        return companyService.findById(id);
    }

    @GetMapping
    public List<Company> findByAccelerationAndUserId(@RequestParam(required = false) Long accelerationId, @RequestParam(required = false) Long userId){
        if(accelerationId != null)
            return companyService.findByAccelerationId(accelerationId);
        if(userId != null)
            return companyService.findByUserId(userId);

        return companyService.findAll();
    }
}
