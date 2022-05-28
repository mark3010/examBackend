package mark025e.exam.backend.repo;

import mark025e.exam.backend.entity.Party;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepository extends JpaRepository<Party,Integer> {
}
