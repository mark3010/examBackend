package mark025e.exam.backend.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String letter;

    @OneToMany(mappedBy = "party", cascade = CascadeType.ALL) //el persist? el merge?
    private Set<Candidate> candidates = new HashSet<>();

    public Party(String name, String partyletter) {
        this.name = name;
        this.letter = partyletter;
    }

    public void addCandidate(Candidate candidate) {
        this.candidates.add(candidate);
        candidate.setParty(this);
    }

    public void addCandidates(Set<Candidate> candidates) {
        this.candidates.addAll(candidates);
        for (Candidate candidate : candidates) {
            candidate.setParty(this);
        }
    }
}
