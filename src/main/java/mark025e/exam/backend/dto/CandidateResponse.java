package mark025e.exam.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mark025e.exam.backend.entity.Candidate;
import mark025e.exam.backend.entity.Party;

@Getter
@Setter
@NoArgsConstructor
public class CandidateResponse {
    private String name;
    private String party;
    public CandidateResponse(Candidate candidate) {
        this.name = candidate.getName();
        this.party = candidate.getParty().getLetter();
    }

}
