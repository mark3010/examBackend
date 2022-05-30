package mark025e.exam.backend.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CyclistRequest {
    private int id;
    private String name;
    private String team;
    private int age;
    private int timeTotal;
    private int sprintPoints;
    private int mountainPoints;
}
