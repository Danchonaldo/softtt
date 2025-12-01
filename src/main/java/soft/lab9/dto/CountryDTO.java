package soft.lab9.dto;

import jakarta.persistence.Basic;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryDTO {
    private Long id;
    private String name;
    private String code;
}