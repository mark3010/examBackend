package mark025e.exam.backend.repo;


import mark025e.exam.backend.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate,Integer> {
    List<Candidate> getAllByParty_Letter(String letter);
}
