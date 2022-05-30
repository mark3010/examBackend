package mark025e.exam.backend.entity;

import lombok.*;

import javax.persistence.*;
import java.time.Duration;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cyclist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;

    //I know literally nothing about tour de france, so I will make assumptions regarding the format:
    private Duration timeTotal;
    private int sprintPoints;
    private int mountainPoints;

    @ManyToOne()
    private Team team;


    public Cyclist(String name) {
        this.name = name;
    }
}
