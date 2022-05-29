package mark025e.exam.backend.api;

import mark025e.exam.backend.dto.CandidateRequest;
import mark025e.exam.backend.dto.CandidateResponse;
import mark025e.exam.backend.service.CandidateService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/candidates")
public class CandidateController {
    CandidateService candidateService;

    public CandidateController(CandidateService c) {this.candidateService = c;}

    @GetMapping
    public List<CandidateResponse> getAllCandidates(@RequestParam(value = "party", required = false) String party, Pageable pageable) {
        return candidateService.getAllCandidates(party,pageable);
        // query param written as URL + ?party=A where A is partyletter
    }

    @GetMapping("/{id}")
    CandidateResponse getCandidate(@PathVariable int id) throws Exception {
        return candidateService.getCandidate(id);
    }

    @PostMapping
    public CandidateResponse addCandidate(@RequestBody CandidateRequest body){
        return candidateService.addCandidate(body);
    }

    @DeleteMapping("/{id}")
    public void deleteCandidate(@PathVariable int id){
        candidateService.deleteCandidate(id);
    }

    @PutMapping("/{id}")
    public CandidateResponse editCandidate(@RequestBody CandidateRequest body) {
        return candidateService.editCandidate(body);
    }



}
