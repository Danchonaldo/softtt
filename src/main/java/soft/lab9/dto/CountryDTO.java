package soft.lab9.dto;

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