package mark025e.exam.backend.repo;

import mark025e.exam.backend.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team,Integer> {
    Team getTeamByName(String name);
}
