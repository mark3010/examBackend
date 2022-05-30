package mark025e.exam.backend.service;

import mark025e.exam.backend.dto.CyclistRequest;
import mark025e.exam.backend.dto.CyclistResponse;
import mark025e.exam.backend.entity.Cyclist;
import mark025e.exam.backend.error.Client4xxException;
import mark025e.exam.backend.repo.CyclistRepository;
import mark025e.exam.backend.repo.TeamRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CyclistService {
    CyclistRepository cyclistRepository;
    TeamRepository teamRepository;

    public CyclistService(CyclistRepository cyclistRepository, TeamRepository teamRepository) {
        this.cyclistRepository = cyclistRepository;
        this.teamRepository = teamRepository;
    }

    public List<CyclistResponse> getAllCyclist(String teamName) {
        List<Cyclist> cyclists;

        if (teamName != null) {
            cyclists = cyclistRepository.getAllByTeam_Name(teamName);
        } else {
            cyclists = cyclistRepository.findAll();
        }

        return cyclists.stream().map((cyclist) ->new CyclistResponse(cyclist)).collect(Collectors.toList());
    }

    public CyclistResponse getCyclist(int id) throws Exception {
        Cyclist c = cyclistRepository.findById(id).orElseThrow(()->new Client4xxException("No cyclist with this id exists"));
        return new CyclistResponse(c);
    }


    public CyclistResponse addCyclist(CyclistRequest body) {
        Cyclist c = Cyclist.builder()
                .name(body.getName())
                .team(teamRepository.getTeamByName(body.getTeam()))
                .age(body.getAge())
                .timeTotal(Duration.ZERO.plusSeconds(body.getTimeTotal()))
                .mountainPoints(body.getMountainPoints())
                .sprintPoints(body.getSprintPoints())
                .build();

        Cyclist cyclist = cyclistRepository.save(c);

        return new CyclistResponse(cyclist);
    }

    public void deleteCyclist(CyclistRequest body) {
        cyclistRepository.deleteById(body.getId());
    }

    public CyclistResponse editCyclist(CyclistRequest body) {
        //throwing custom error to show error handling
        Cyclist cyclistToEdit = cyclistRepository.findById(body.getId()).orElseThrow(()->new Client4xxException("No cyclist with this id exists"));

        cyclistToEdit.setTeam(teamRepository.getTeamByName(body.getTeam()));
        cyclistToEdit.setName(body.getName());
        cyclistToEdit.setAge(body.getAge());
        cyclistToEdit.setMountainPoints(body.getMountainPoints());
        cyclistToEdit.setSprintPoints(body.getSprintPoints());
        cyclistToEdit.setTimeTotal(Duration.ZERO.plusSeconds(body.getTimeTotal()));

        Cyclist cyclist = cyclistRepository.save(cyclistToEdit);
        return new CyclistResponse(cyclist);
    }

    public CyclistResponse getJerseyWinner(String type) {
        //variable needed for getAllCyclists method
        String teamName = null;

        List<CyclistResponse> list = getAllCyclist(teamName);
        CyclistResponse jerseyWinner = null;

        switch (type) {
            case "yellow":
                jerseyWinner = list.stream().min(Comparator.comparing(CyclistResponse::getTimeTotal)).orElseThrow(NoSuchElementException::new);
            break;
            case "mountain":
                jerseyWinner = list.stream().max(Comparator.comparing(CyclistResponse::getMountainPoints)).orElseThrow(NoSuchElementException::new);
            break;
            case "green":
                jerseyWinner = list.stream().max(Comparator.comparing(CyclistResponse::getSprintPoints)).orElseThrow(NoSuchElementException::new);
            break;
            case "white":
                //filter by age <= 26
                list = list.stream().filter(cyclistResponse -> cyclistResponse.getAge()<= 26).collect(Collectors.toList());
                jerseyWinner = list.stream().min(Comparator.comparing(CyclistResponse::getTimeTotal)).orElseThrow(NoSuchElementException::new);
        }

        return jerseyWinner;

    }
}
