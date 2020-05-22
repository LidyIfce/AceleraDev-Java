package com.challenge.endpoints;


import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Candidate;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.impl.CandidateService;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidate")
@AllArgsConstructor
public class CandidateController {

    private CandidateService candidateService;

    @GetMapping("/{userId}/{accelerationId}/{companyId}")
    public CandidateDTO findById(@PathVariable Long userId, @PathVariable Long accelerationId, @PathVariable Long companyId) {

        return this.mapToCandidateDTO(candidateService.findById(userId, companyId, accelerationId).get());
    }

    @GetMapping
    public List<CandidateDTO> findByCompanyIdAndAccelerationId(@RequestParam(required = false) Long companyId,
                                                               @RequestParam(required = false) Long accelerationId) {

        if (companyId != null)
            return this.mapToCandidateDTO(candidateService.findByCompanyId(companyId));

        if (accelerationId != null)
            return this.mapToCandidateDTO(candidateService.findByAccelerationId(accelerationId));

        return this.mapToCandidateDTO(candidateService.findAll());
    }

    private CandidateDTO mapToCandidateDTO(Candidate candidate) {
        return CandidateMapper.INSTANCE.map(candidate);
    }

    private List<CandidateDTO> mapToCandidateDTO(List<Candidate> candidates) {
        return CandidateMapper.INSTANCE.map(candidates);
    }

}
