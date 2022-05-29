package mark025e.exam.backend.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandidateRequest {
    private int id;
    private String name;
    private String party;
}
