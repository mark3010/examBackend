package mark025e.exam.backend.config;


import mark025e.exam.backend.entity.Cyclist;
import mark025e.exam.backend.entity.Team;
import mark025e.exam.backend.repo.CyclistRepository;
import mark025e.exam.backend.repo.TeamRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;

@Component
public class DummyData implements ApplicationRunner {
    private CyclistRepository cyclistRepository;
    private TeamRepository teamRepository;

    public DummyData(CyclistRepository cyclistRepository, TeamRepository teamRepository) {
        this.cyclistRepository = cyclistRepository;
        this.teamRepository = teamRepository;
    }

    public List<Team> makeTeams() {
        return List.of(
                Team.builder()
                    .name("TeamMark")
                    .build(),
                Team.builder()
                        .name("Movistar")
                        .build(),
                Team.builder()
                        .name("TotalEnergies")
                        .build());
    }

    public List<Cyclist> makeCyclists() {
        //Be aware! I will assign random points to all cyclists
        return List.of(
        //team 1
        Cyclist.builder()
                .name("Cykel myggen")
                .team(teamRepository.getReferenceById(1))
                .age(10)
                .timeTotal(Duration.ZERO.plusHours(2).plusMinutes(42).plusSeconds(2))
                .sprintPoints(2)
                .mountainPoints(3)
                .build(),
        Cyclist.builder()
                .name("Bjarne Riis")
                .team(teamRepository.getReferenceById(1))
                .age(23)
                .timeTotal(Duration.ZERO.plusHours(3).plusMinutes(00).plusSeconds(21))
                .sprintPoints(1)
                .mountainPoints(10)
                .build(),
        Cyclist.builder()
                .name("Holger fra \"Find Holger\"")
                .team(teamRepository.getReferenceById(1))
                .age(10)
                .timeTotal(Duration.ZERO.plusHours(2).plusMinutes(44).plusSeconds(22))
                .sprintPoints(0)
                .mountainPoints(0)
                .build(),
        Cyclist.builder()
                .name("Deres majestæt dronning Margrethe")
                .team(teamRepository.getReferenceById(1))
                .age(34)
                .timeTotal(Duration.ZERO.plusHours(2).plusMinutes(39).plusSeconds(44))
                .sprintPoints(7)
                .mountainPoints(1)
                .build(),
        Cyclist.builder()
                .name("Ole henriksen")
                .team(teamRepository.getReferenceById(1))
                .age(32)
                .timeTotal(Duration.ZERO.plusHours(2).plusMinutes(52).plusSeconds(10))
                .sprintPoints(0)
                .mountainPoints(0)
                .build(),
        Cyclist.builder()
                .name("Wulff Morgenthaler")
                .team(teamRepository.getReferenceById(1))
                .age(40)
                .timeTotal(Duration.ZERO.plusHours(2).plusMinutes(32).plusSeconds(2))
                .sprintPoints(4)
                .mountainPoints(6)
                .build(),
        Cyclist.builder()
                .name("Amin Jensen")
                .team(teamRepository.getReferenceById(1))
                .age(22)
                .timeTotal(Duration.ZERO.plusHours(2).plusMinutes(22).plusSeconds(4))
                .sprintPoints(0)
                .mountainPoints(0)
                .build(),
        Cyclist.builder()
                .name("Klon #42")
                .team(teamRepository.getReferenceById(1))
                .age(35)
                .timeTotal(Duration.ZERO.plusHours(2).plusMinutes(30).plusSeconds(52))
                .sprintPoints(1)
                .mountainPoints(6)
                .build(),
        //team 2
        Cyclist.builder()
                .name("OLIVEIRA Nelson")
                .team(teamRepository.getReferenceById(2))
                .age(34)
                .timeTotal(Duration.ZERO.plusHours(2).plusMinutes(43).plusSeconds(20))
                .sprintPoints(0)
                .mountainPoints(0)
                .build(),
        Cyclist.builder()
                .name("VERONA Carlos")
                .team(teamRepository.getReferenceById(2))
                .age(33)
                .timeTotal(Duration.ZERO.plusHours(2).plusMinutes(59).plusSeconds(59))
                .sprintPoints(0)
                .mountainPoints(2)
                .build(),
        Cyclist.builder()
                .name("ERVITI Imanol")
                .team(teamRepository.getReferenceById(2))
                .age(32)
                .timeTotal(Duration.ZERO.plusHours(2).plusMinutes(12).plusSeconds(32))
                .sprintPoints(0)
                .mountainPoints(1)
                .build(),
        Cyclist.builder()
                .name("IZAGIRRE Gorka")
                .team(teamRepository.getReferenceById(2))
                .age(31)
                .timeTotal(Duration.ZERO.plusHours(2).plusMinutes(32).plusSeconds(1))
                .sprintPoints(4)
                .mountainPoints(3)
                .build(),
        Cyclist.builder()
                .name("JORGENSON Matteo")
                .team(teamRepository.getReferenceById(2))
                .age(30)
                .timeTotal(Duration.ZERO.plusHours(2).plusMinutes(45).plusSeconds(22))
                .sprintPoints(2)
                .mountainPoints(1)
                .build(),
        Cyclist.builder()
                .name("MAS enric")
                .team(teamRepository.getReferenceById(2))
                .age(29)
                .timeTotal(Duration.ZERO.plusHours(2).plusMinutes(40).plusSeconds(33))
                .sprintPoints(5)
                .mountainPoints(0)
                .build(),

        //team 3
        Cyclist.builder()
                .name("FERRON Valentin")
                .team(teamRepository.getReferenceById(3))
                .age(28)
                .timeTotal(Duration.ZERO.plusHours(2).plusMinutes(52).plusSeconds(22))
                .sprintPoints(1)
                .mountainPoints(1)
                .build(),
        Cyclist.builder()
                .name("DOUBEY Fabien")
                .team(teamRepository.getReferenceById(3))
                .age(25)
                .timeTotal(Duration.ZERO.plusHours(2).plusMinutes(47).plusSeconds(17))
                .sprintPoints(2)
                .mountainPoints(2)
                .build(),
        Cyclist.builder()
                .name("VUILLERMOZ Alexis")
                .team(teamRepository.getReferenceById(3))
                .age(42)
                .timeTotal(Duration.ZERO.plusHours(2).plusMinutes(39).plusSeconds(12))
                .sprintPoints(3)
                .mountainPoints(0)
                .build(),
        Cyclist.builder()
                .name("JOUSSEAUME Alan")
                .team(teamRepository.getReferenceById(3))
                .age(22)
                .timeTotal(Duration.ZERO.plusHours(2).plusMinutes(45).plusSeconds(32))
                .sprintPoints(0)
                .mountainPoints(0)
                .build(),
        Cyclist.builder()
                .name("SAGAN Peter")
                .team(teamRepository.getReferenceById(3))
                .age(28)
                .timeTotal(Duration.ZERO.plusHours(2).plusMinutes(41).plusSeconds(0))
                .sprintPoints(5)
                .mountainPoints(3)
                .build(),
        Cyclist.builder()
                .name("LATOUR Pierre")
                .team(teamRepository.getReferenceById(3))
                .age(32)
                .timeTotal(Duration.ZERO.plusHours(2).plusMinutes(48).plusSeconds(11))
                .sprintPoints(0)
                .mountainPoints(0)
                .build()
        );
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        teamRepository.deleteAll();
        teamRepository.saveAll(makeTeams());

        cyclistRepository.deleteAll();
        cyclistRepository.saveAll(makeCyclists());
    }
}
