package mark025e.exam.backend.service;

import mark025e.exam.backend.dto.CandidateRequest;
import mark025e.exam.backend.dto.CandidateResponse;
import mark025e.exam.backend.entity.Candidate;
import mark025e.exam.backend.entity.Party;
import mark025e.exam.backend.error.Client4xxException;
import mark025e.exam.backend.repo.CandidateRepository;
import mark025e.exam.backend.repo.PartyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public List<CandidateResponse> getAllCandidates(String letter, Pageable pageable) {

        List<Candidate> candidates;

        if (letter != null) {
            candidates = candidateRepository.getAllByParty_Letter(letter);
        } else {
            Page<Candidate> candidatesPage = candidateRepository.findAll(pageable);
            candidates = candidatesPage.getContent();
        }

        return candidates.stream().map((candidate) ->new CandidateResponse(candidate)).collect(Collectors.toList());
    }

    public CandidateResponse getCandidate(int id) throws Exception {
        Candidate c = candidateRepository.findById(id).orElseThrow(()->new Client4xxException("No candidate with this id exists"));
        return new CandidateResponse(c);
    }


    public CandidateResponse addCandidate(CandidateRequest body) {
        //TODO: Party is not taken from request, fix later
        Candidate c = Candidate.builder()
                .name(body.getName())
                .party(partyRepository.getReferenceById(1))
                .build();

        Candidate candidate = candidateRepository.save(c);

        return new CandidateResponse(candidate);
    }

    public void deleteCandidate(int id) {
        //TODO: error handling, missing entity
        candidateRepository.deleteById(id);
    }

    public CandidateResponse editCandidate(CandidateRequest body) {
        //TODO: error handling, missing entity, Party is not taken from request
        Candidate candidateToEdit = candidateRepository.getReferenceById(body.getId());

        candidateToEdit.setParty(partyRepository.getReferenceById(1));
        candidateToEdit.setName(body.getName());

        Candidate candidate = candidateRepository.save(candidateToEdit);
        return new CandidateResponse(candidate);
    }
}
