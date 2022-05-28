package mark025e.exam.backend.service;

import mark025e.exam.backend.dto.CandidateResponse;
import mark025e.exam.backend.entity.Candidate;
import mark025e.exam.backend.repo.CandidateRepository;
import mark025e.exam.backend.repo.PartyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidateService {
    CandidateRepository candidateRepository;
    PartyRepository partyRepository;

    public CandidateService(CandidateRepository candidateRepository, PartyRepository partyRepository) {
        this.candidateRepository = candidateRepository;
        this.partyRepository = partyRepository;
    }

    public List<CandidateResponse> getAllCandidates(String letter) {

        List<Candidate> candidates;

        if (letter != null) {
            candidates = candidateRepository.getAllByParty_Letter(letter);
        } else {
            candidates = candidateRepository.findAll();
        }

        return candidates.stream().map((candidate) ->new CandidateResponse(candidate)).collect(Collectors.toList());
    }
}
