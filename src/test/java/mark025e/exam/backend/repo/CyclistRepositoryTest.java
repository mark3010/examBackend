package mark025e.exam.backend.repo;

import mark025e.exam.backend.entity.Cyclist;
import mark025e.exam.backend.entity.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CyclistRepositoryTest {
    @Autowired
    CyclistRepository cyclistRepository;
    @Autowired
    TeamRepository teamRepository;


    @BeforeEach
    void setup() {
        teamRepository.saveAll( List.of(
                Team.builder()
                        .name("TEAM-A")
                        .build(),
                Team.builder()
                        .name("TEAM-B")
                        .build())
        );

        cyclistRepository.saveAll(
                List.of(
                        Cyclist.builder()
                        .name("Person 1")
                        .team(teamRepository.getTeamByName("TEAM-A"))
                        .age(10)
                        .timeTotal(Duration.ZERO.plusHours(2).plusMinutes(42).plusSeconds(2))
                        .sprintPoints(2)
                        .mountainPoints(3)
                        .build(),
                Cyclist.builder()
                        .name("Person 2")
                        .team(teamRepository.getTeamByName("TEAM-A"))
                        .age(30)
                        .timeTotal(Duration.ZERO.plusHours(2).plusMinutes(42).plusSeconds(2))
                        .sprintPoints(2)
                        .mountainPoints(3)
                        .build(),
                Cyclist.builder()
                        .name("Person 3")
                        .team(teamRepository.getTeamByName("TEAM-B"))
                        .age(20)
                        .timeTotal(Duration.ZERO.plusHours(2).plusMinutes(42).plusSeconds(2))
                        .sprintPoints(2)
                        .mountainPoints(3)
                        .build())
        );
        }


    @Test
    void getAllByTeam_Name() {
        //test using in memory h2 database
        List<Cyclist> teamA = cyclistRepository.getAllByTeam_Name("TEAM-A");
        assertEquals(teamA.size(),2);

        List<Cyclist> teamB = cyclistRepository.getAllByTeam_Name("TEAM-B");
        assertEquals(teamB.size(),1);
    }
}