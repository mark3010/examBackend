package mark025e.exam.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mark025e.exam.backend.entity.Cyclist;
import mark025e.exam.backend.entity.Team;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.Duration;

@Getter
@Setter
@NoArgsConstructor
public class CyclistResponse {

    private int id;
    private String name;
    private int age;
    private String team;
    private String timeTotal;
    private int sprintPoints;
    private int mountainPoints;

    public CyclistResponse(Cyclist cyclist) {
        this.id = cyclist.getId();
        this.name = cyclist.getName();
        this.age = cyclist.getAge();
        this.team = cyclist.getTeam().getName();

        //reformat duration to be readable on frontend. good example of response utility
        Long s = cyclist.getTimeTotal().getSeconds();
        String timePretty = String.format("%d:%02d:%02d", s/3600, (s % 3600) / 60, (s % 60));

        this.timeTotal = timePretty;
        this.sprintPoints = cyclist.getSprintPoints();
        this.mountainPoints = cyclist.getMountainPoints();
    }

}
