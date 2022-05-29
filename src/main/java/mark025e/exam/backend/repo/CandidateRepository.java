package mark025e.exam.backend.repo;


import mark025e.exam.backend.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate,Integer> {
    List<Candidate> getAllByParty_Letter(String letter);
}
