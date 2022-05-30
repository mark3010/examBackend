package mark025e.exam.backend.repo;


import mark025e.exam.backend.entity.Cyclist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CyclistRepository extends JpaRepository<Cyclist,Integer> {
    List<Cyclist> getAllByTeam_Name(String name);
}
