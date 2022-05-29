package mark025e.exam.backend.config;


import lombok.RequiredArgsConstructor;

import mark025e.exam.backend.entity.Candidate;
import mark025e.exam.backend.entity.Party;
import mark025e.exam.backend.repo.CandidateRepository;
import mark025e.exam.backend.repo.PartyRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DummyData implements ApplicationRunner {
    private CandidateRepository candidateRepository;
    private PartyRepository partyRepository;

    public DummyData(CandidateRepository candidateRepository, PartyRepository partyRepository) {
        this.candidateRepository = candidateRepository;
        this.partyRepository = partyRepository;
    }

    public List<Party> makeParties() {
        return List.of(
                Party.builder()
                    .name("venstre")
                    .letter("V")
                    .build(),
                Party.builder()
                        .name("mere venstre")
                        .letter("VV")
                        .build());
    }

    public List<Candidate> makeCandidates() {
        return List.of(Candidate.builder()
                .name("guy number 1")
                .party(partyRepository.getReferenceById(1))
                .build(),
        Candidate.builder()
                .name("guy number 2")
                .party(partyRepository.getReferenceById(1))
                .build(),
        Candidate.builder()
                .name("guy number 3")
                .party(partyRepository.getReferenceById(1))
                .build(),
        Candidate.builder()
                .name("guy number 4")
                .party(partyRepository.getReferenceById(1))
                .build(),
        Candidate.builder()
                .name("guy number a")
                .party(partyRepository.getReferenceById(2))
                .build(),
        Candidate.builder()
                .name("guy number b")
                .party(partyRepository.getReferenceById(2))
                .build(),
        Candidate.builder()
                .name("guy number c")
                .party(partyRepository.getReferenceById(2))
                .build(),
        Candidate.builder()
                .name("guy number d")
                .party(partyRepository.getReferenceById(2))
                .build()
        );
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        partyRepository.deleteAll();
        partyRepository.saveAll(makeParties());

        candidateRepository.deleteAll();
        candidateRepository.saveAll(makeCandidates());
    }
}
