package soft.lab9.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
    private Long id;
    private String name;
    private int price;
    private int quantity;
    private CountryDTO manufacturer;
}