package mark025e.exam.backend.api;

import mark025e.exam.backend.dto.CandidateResponse;
import mark025e.exam.backend.service.CandidateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class CandidateController {
    CandidateService candidateService;

    public CandidateController(CandidateService c) {this.candidateService = c;}

    @GetMapping
    public List<CandidateResponse> getAllCandidates(@RequestParam(value = "party", required = false) String party) {
        return candidateService.getAllCandidates(party);

        // query param written as URL + ?party=A where A is partyletter
    }
}
